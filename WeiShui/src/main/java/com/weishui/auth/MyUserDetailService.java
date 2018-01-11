package com.weishui.auth;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weishui.mapper.WsUserMapper;
import com.weishui.model.WsUser;
import com.weishui.service.WsMenuService;
import com.weishui.service.WsUserService;
import com.weishui.util.SpringContextUtil;
//@Service
public class MyUserDetailService implements UserDetailsService {
	// 登陆验证时，通过username获取用户的所有权限信息，
	// 并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用

//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
//		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//
//		GrantedAuthorityImpl auth2 = new GrantedAuthorityImpl("ROLE_ADMIN");
//		GrantedAuthorityImpl auth1 = new GrantedAuthorityImpl("ROLE_USER");
//
//		if (username.equals("lcy")) {
//			auths = new ArrayList<GrantedAuthority>();
//			auths.add(auth1);
//			auths.add(auth2);
//		}
//		User user = new User(username, "lcy", true, true, true, true, auths);
//		return user;
//	}
//	@Autowired  
//	WsUserService wsUserService;
	
//	@Resource
//	WsUserMapper wsUserMapper;
	
//	@Autowired  
//	WsMenuService wsMenuService;
	
	@Override  
    public UserDetails loadUserByUsername(String username)  
            throws UsernameNotFoundException {  
        Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  
        WsUser wsUser = new WsUser();  
        try {  ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
        WsUserService wsUserService = (WsUserService)SpringContextUtil.getBean(WsUserService.class);
        	wsUser = wsUserService.getUserByName(username);  
            String authStr = wsUserService.selectPositionByUname(username);  
//            wsUser = wsUserMapper.selectUserByName(username);  
//            String authStr = wsUserMapper.selectPositionByUname(username);  
//            for (String authName : authStr) {  
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authStr);  
                auths.add(authority);  
//            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return new org.springframework.security.core.userdetails.User(  
        		wsUser.getUserName(), wsUser.getPassword(), true, true, true, true,  
                auths);  
    }  
}