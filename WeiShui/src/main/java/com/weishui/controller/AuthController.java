package com.weishui.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.weishui.model.Dept;
import com.weishui.model.WxUser;
import com.weishui.service.DeptService;
import com.weishui.service.WxUserService;
import com.weishui.tool.AdvancedUtil;
import com.weishui.tool.WXBizDataCrypt;
import com.weishui.util.PropertyFactory;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	@Resource
	DeptService deptService;

	@Resource
	WxUserService wxUserService;

	@RequestMapping(value = "/getAllDepts.do")
	@ResponseBody
	public List<Dept> getAllDepts() {
		List<Dept> list = deptService.getAlDepts();
		return list;
	}

	@RequestMapping(value = "/addDept.do")
	@ResponseBody
	public String addDept(String deptName, String desc) {
		Dept dept = new Dept();
		dept.setDeptName(deptName);
		dept.setDescription(desc);
		dept.setCreateTime(new Date());
		dept.setUpdateTime(new Date());
		deptService.insertSelective(dept);
		return "success";
	}

	@RequestMapping(value = "/delDeptByIds.do")
	@ResponseBody
	public String delDeptByIds(String deptIds) {
		List<String> list = Arrays.asList(deptIds.split(","));
		deptService.deleteByIds(list);
		return "success";
	}

	@RequestMapping(value = "/getDeptById.do")
	@ResponseBody
	public Dept getDeptById(String deptId) {
		return deptService.getDeptById(deptId);
	}

	@RequestMapping(value = "/updateDeptById.do")
	@ResponseBody
	public String updateDeptById(String deptId, String deptName, String desc) {
		Dept dept = new Dept();
		dept.setId(deptId);
		dept.setDeptName(deptName);
		dept.setDescription(desc);
		dept.setUpdateTime(new Date());
		deptService.updateDeptById(dept);
		return "success";
	}

	@RequestMapping(value = "/tologin.do")
	@ResponseBody
	public JSONObject loginByWeixin(HttpServletRequest request, HttpServletResponse response, @RequestParam String jsCode,
			@RequestParam String iv, @RequestParam String encryptedData) throws Exception {
		HttpSession httpSession = request.getSession();
		JSONObject returnObject = new JSONObject();
		if (jsCode == null || "".equals(jsCode)) {
			System.out.println("缺少必要参数");
		} else {
			JSONObject obj = getWxUserInfo(jsCode, iv, encryptedData);
			if (obj.containsKey("errcode")) {
				String errcode = obj.get("errcode").toString();
				System.out.println("微信返回的错误码{}:" + errcode);
			} else if (obj.containsKey("session_key")) {
				System.out.println("\n调微信成功=================\n");
				// 开始处理userInfo
				String openId = obj.get("openId").toString();
				System.out.println("openId==" + openId);
				// 先查询openId存在不存在，存在不入库，不存在就入库
				WxUser userResult = wxUserService.selectByOpenId(openId);
				WxUser wxUser=getUserObject(obj);
				if (!StringUtils.isEmpty(userResult)) {
					userResult.setUpdateTime(new Date());
					wxUserService.updateByOpenIdSelective(userResult);
					System.out.println("openId已经存在，更新微信用户信息\n");
				} else {
					wxUser.setCreateTime(new Date());
					wxUser.setUpdateTime(new Date());
					wxUserService.insertSelective(wxUser);
					System.out.println("openId不存在，插入微信用户到数据库\n");
				}
				// (1) 获得sessionkey
				String sessionKey = obj.get("session_key").toString();
				System.out.println("sessionKey==" + sessionKey);
				System.out.println("openId==" + openId);
				// (2) 得到sessionkey以后存到缓存，key值采用不会重复的uuid
				String maskSessionKey = UUID.randomUUID().toString();
				// (3) 首先根据openId，取出来之前存的openId对应的sessionKey的值。
				WxUser oldUser = wxUserService.selectByOpenId(openId);
				if (!StringUtils.isEmpty(userResult)) {
					System.out.println("\noldSeesionKey==" + userResult.getSessionKey());
					System.out.println("新的sessionKey=="+sessionKey+"\n");
				}
				// (4) 更新openId对应的sessionKey
				oldUser.setSessionKey(sessionKey);
				oldUser.setMaskSessionKey(maskSessionKey);
				wxUserService.updateByOpenIdSelective(oldUser);
				
				// (5) 开始缓存新的sessionKey： key --> uuid， value -->
				// sessionObj
				JSONObject sessionObj = new JSONObject();
				sessionObj.put("openId", openId);
				sessionObj.put("sessionKey", sessionKey);
				// tokenCache.getJedis().set(rsession,
				// sessionObj.toJSONString());
				httpSession.setAttribute("openId", openId);

				// (6) 开始缓存新的openId与session对应关系 ： key --> openId , value
				// --> rsession
				// tokenCache.getJedis().set(openId, rsession);
				//
				// String newOpenId = tokenCache.getJedis().get(openId);
				// String newrSession = tokenCache.getJedis().get(rsession);
				// System.out.println("新的openId==" + newOpenId);
				// System.out.println("新的newrSession==" + newrSession);
				// (7) 把新的sessionKey返回给小程序
				returnObject.put("maskSessionKey", maskSessionKey);
//				returnObject.put("errno", 0);
			}
		}
		return returnObject;
	}
	/**
	 * 根据json转换为对象
	 * @param obj
	 * @return
	 */
	private static WxUser getUserObject(JSONObject jsonObject) {
		WxUser wxUser = new WxUser();
//		JSONObject jsonObject = obj.getJSONObject("userInfo");
		wxUser.setOpenId(jsonObject.getString("openId"));
		wxUser.setNickname(jsonObject.getString("nickName"));
		wxUser.setSex(Short.parseShort(jsonObject.getString("gender")));
		wxUser.setLanguage(jsonObject.getString("language"));
		wxUser.setCountry(jsonObject.getString("country"));
		wxUser.setProvince(jsonObject.getString("province"));
		wxUser.setCity(jsonObject.getString("city"));
		wxUser.setHeadimgUrl(jsonObject.getString("avatarUrl"));
		wxUser.setSessionKey(jsonObject.get("session_key").toString());
		return wxUser;
	}
	/**
	 * 获取微信用户的openid、sessionKey以及详细信息
	 * @param jsCode
	 * @param iv
	 * @param encryptedData
	 * @return
	 */
	private JSONObject getWxUserInfo(String jsCode, String iv, String encryptedData) {

		JSONObject jsonObject;

		String deString = null;

		String appId = PropertyFactory.getProperty("/weixin.properties", "AppID");
		String appSecret = PropertyFactory.getProperty("/weixin.properties", "AppSecret");

		try {
			JSONObject aString = AdvancedUtil.getAccessToken(appId, appSecret, jsCode);

			if (aString != null)
				System.out.println("session_key=" + aString.getString("session_key"));

			String sessionKey = aString.getString("session_key");

			if (sessionKey == null) {
				return aString;
			}

			deString = WXBizDataCrypt.getInstance().decrypt(encryptedData, sessionKey, iv, "utf-8");
			System.out.println("destring=" + deString);

			if (deString == null) {
				return aString;
			}

			jsonObject = JSONObject.parseObject(deString);
			jsonObject.put("session_key", sessionKey);
			System.out.println("jsonobject=" + jsonObject);
		} catch (Exception e) {
			jsonObject = JSONObject.parseObject("{\"errcode\":\"" + e.getStackTrace() + "\"}");
			e.printStackTrace();
			deString = "error";
		}
		return jsonObject;
	}


//	@RequestMapping("/getUserInfo")
//	public @ResponseBody String getUserInfo(HttpServletRequest request, HttpServletResponse response,
//			@RequestParam String jsCode, @RequestParam String iv, @RequestParam String encryptedData)
//					throws ServletException, IOException {
//		int campusId = 1;
//
//		UserInfo UserInfo = null;
//
//		JSONObject jsonObject;
//
//		jsonObject = getWxInfo(jsCode, iv, encryptedData);
//
//		List list = new ArrayList<Object>();
//		JSONArray jsonArray = new JSONArray();
//
//		UserInfo = getUserInfo(jsonObject);
//
//		String openId = UserInfo.getOpenId();
//
//		insertUser(UserInfo, campusId, openId);
//
//		list.add(jsonObject);
//		jsonArray.add(list);
//
//		return jsonArray.toString();
//
//	}


}
