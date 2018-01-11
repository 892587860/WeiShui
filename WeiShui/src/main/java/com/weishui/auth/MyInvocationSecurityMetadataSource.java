package com.weishui.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.weishui.auth.tool.AntUrlPathMatcher;
import com.weishui.auth.tool.UrlMatcher;
import com.weishui.mapper.DeptMapper;
import com.weishui.mapper.WsMenuMapper;
import com.weishui.model.WsMenu;
import com.weishui.model.WsPosition;
import com.weishui.service.DeptService;
import com.weishui.service.TimingPacketService;
import com.weishui.service.WsMenuService;
import com.weishui.service.WsUserService;
import com.weishui.util.SpringContextUtil;
//@Service
//@Transactional 
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	
//	@Resource
//	WsMenuService wsMenuService;
	
//	@Resource
//	WsMenuMapper wsMenuMapper;
//	
//	
//	@Resource
//	private DeptMapper deptMapper;
	// tomcat启动时实例化一次
//	public MyInvocationSecurityMetadataSource() {
//		loadResourceDefine();
//	}

	// tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
	private void loadResourceDefine() {
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = new SecurityConfig("ROLE_USER");
		atts.add(ca);
		resourceMap.put("/hello.jsp", atts);
		Collection<ConfigAttribute> attsno = new ArrayList<ConfigAttribute>();
		ConfigAttribute cano = new SecurityConfig("ROLE_NO");
		attsno.add(cano);
		resourceMap.put("/other.jsp", attsno);
		resourceMap.put("/admin.jsp", atts);
//		resourceMap.put("/infoPacket.jsp", attsno);
	}

//	 参数是要访问的url，返回这个url对于的所有权限（或角色）
//	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//		// 将参数转为url
//		String url = ((FilterInvocation) object).getRequestUrl();
//		Iterator<String> ite = resourceMap.keySet().iterator();
//		while (ite.hasNext()) {
//			String resURL = ite.next();
//			if (urlMatcher.pathMatchesUrl(resURL, url)) {
//				return resourceMap.get(resURL);
//			}
//		}
//		return null;
//	}
	
	@Override  
    public Collection<ConfigAttribute> getAttributes(Object object)  
            throws IllegalArgumentException {  
        String url = ((FilterInvocation) object).getRequestUrl();  
        int firstQuestionMarkIndex = url.indexOf("?");  
        if (firstQuestionMarkIndex != -1) {  
            url = url.substring(0, firstQuestionMarkIndex);  
        }  
        System.out.println("url:" + url);  
        List<ConfigAttribute> result = new ArrayList<ConfigAttribute>();  
        ConfigAttribute attribute = new SecurityConfig("ROLE_BASE");  
        result.add(attribute);  
        ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
        WsMenuService wsMenuService = (WsMenuService)SpringContextUtil.getBean(WsMenuService.class);
        try {  
        	List<Map<String, Object>> menuList = wsMenuService.findMenuByUri(url);  
        	System.out.println(menuList);
            if (menuList != null && menuList.size() > 0) {  
                for (Map map : menuList) {  
                    ConfigAttribute conf = new SecurityConfig((String) map.get("positionName"));  
                    result.add(conf);  
                }  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
	 private boolean urlMatcher(String permstr, String requestUri) {  
	        boolean isMatcher = false;  
	        PathMatcher matcher = new AntPathMatcher();  
	        isMatcher = matcher.match(permstr, requestUri);  
	        return isMatcher;  
	    } 
	public boolean supports(Class<?> clazz) {
		return true;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
}
