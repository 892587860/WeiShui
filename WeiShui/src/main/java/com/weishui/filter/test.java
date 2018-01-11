package com.weishui.filter;

import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.cache.Cache;
import org.springframework.http.HttpRequest;

import com.alibaba.fastjson.JSON;
/**
 * java实现微信小程序登录态维护的示例代码
 * @author admin
 *
 */
public class test{
	public void loginByWeixin() throws Exception {
        logger.info("Start getSessionKey");
        String json = HttpKit.readData(getRequest());
        JSONObject reqJson = JSON.parseObject(json);
        String jsCode = reqJson.getString("code");
        if (jsCode == null || "".equals(jsCode)) {
            logger.info("缺少必要参数");
            renderJson(new OutRoot().setCode("100").setMsg(SYS.PARAMETER_FAIL));
        } else {
            List<Record> record = appInfoService.selectAppInfo();
            String appId = record.get(0).get("app_id");
            String appSecret = record.get(0).getStr("app_secret");
            if (appId == null || "".equals(appId) || appSecret == null || "".equals(appSecret)) {
                logger.info("缺少必要参数");
                renderJson(new OutRoot().setCode("100").setMsg(SYS.PARAMETER_FAIL));
            } else {
                String url = "https://api.weixin.qq.com/sns/jscode2session";
                String httpUrl = url + "?appid=" + appId + "&secret=" + appSecret + "&js_code=" + jsCode
                        + "&grant_type=authorization_code";
                String ret = HttpRequest.sendGetRequest(httpUrl);
                logger.info("微信返回的结果 {}", ret);
                if (ret == null || "".equals(ret)) {
                    logger.info("网络超时");
                    renderJson(new OutRoot().setCode("101").setMsg(SYS.CONTACT_FAIL));
                } else {
                    JSONObject obj = JSONObject.parseObject(ret);
                    if (obj.containsKey("errcode")) {
                        String errcode = obj.get("errcode").toString();
                        logger.info("微信返回的错误码{}", errcode);
                        renderJson(new OutRoot().setCode("101").setMsg(SYS.CONTACT_FAIL));
                    } else if (obj.containsKey("session_key")) {
                        logger.info("调微信成功");
                        // 开始处理userInfo
                        String openId = obj.get("openid").toString();
                        Record tbMember = new Record();
                        tbMember.set("weixin_openid", openId);
                        System.out.println("openId==" + openId);
                        // 先查询openId存在不存在，存在不入库，不存在就入库
                        List<Record> memberList = tbMemberService.selectMember(tbMember);
                        if (memberList != null && memberList.size() > 0) {
                            logger.info("openId已经存在，不需要插入");
                        } else {
                            JSONObject rawDataJson = reqJson.getJSONObject("userInfo");
                            String nickName = rawDataJson.getString("nickName");
                            String avatarUrl = rawDataJson.getString("avatarUrl");
                            String gender = rawDataJson.getString("gender");
                            String province = rawDataJson.getString("province");
                            String city = rawDataJson.getString("city");
                            String country = rawDataJson.getString("country");
                            tbMember.set("gender", gender);
                            tbMember.set("nick_name", nickName);
                            tbMember.set("avatar_url", avatarUrl);
                            Long openId2 = tbMemberService.addMember(tbMember);
                            logger.info("openId不存在，插入数据库");
                        }
                        // (1) 获得sessionkey
                        String sessionKey = obj.get("session_key").toString();
                        logger.info("sessionKey==" + sessionKey);
                        logger.info("openId==" + openId);
                        // (2) 得到sessionkey以后存到缓存，key值采用不会重复的uuid
                        String rsession = UUID.randomUUID().toString();
                        Cache tokenCache = Redis.use("redis_00");
                        // (3) 首先根据openId，取出来之前存的openId对应的sessionKey的值。
                        String oldSeesionKey = tokenCache.getJedis().get(openId);
                        if (oldSeesionKey != null && !"".equals(oldSeesionKey)) {
                            logger.info("oldSeesionKey==" + oldSeesionKey);
                            // (4) 删除之前openId对应的缓存
                            tokenCache.getJedis().del(oldSeesionKey);
                            logger.info("老的openId删除以后==" + tokenCache.getJedis().get(oldSeesionKey));
                        }
                        // (5) 开始缓存新的sessionKey： key --> uuid， value --> sessionObj
                        JSONObject sessionObj = new JSONObject();
                        sessionObj.put("openId", openId);
                        sessionObj.put("sessionKey", sessionKey);
                        tokenCache.getJedis().set(rsession, sessionObj.toJSONString());

                        // (6) 开始缓存新的openId与session对应关系 ： key --> openId , value --> rsession
                        tokenCache.getJedis().set(openId, rsession);

                        String newOpenId = tokenCache.getJedis().get(openId);
                        String newrSession = tokenCache.getJedis().get(rsession);
                        logger.info("新的openId==" + newOpenId);
                        logger.info("新的newrSession==" + newrSession);
                        // (7) 把新的sessionKey返回给小程序
                        JSONObject objret = new JSONObject();
                        objret.put("rdSessionKey", rsession);
                        objret.put("errno", 0);
                        renderJson(objret);
                    }

                }
            }
        }
    }
}
	

  