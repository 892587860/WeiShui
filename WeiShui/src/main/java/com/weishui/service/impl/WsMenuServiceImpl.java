package com.weishui.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.weishui.mapper.WsMenuMapper;
import com.weishui.model.WsMenu;
import com.weishui.service.WsMenuService;
@Service
@Transactional
public class WsMenuServiceImpl implements WsMenuService{
	
	@Resource
	WsMenuMapper wsMenuMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(WsMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(WsMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WsMenu selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(WsMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(WsMenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> findMenuByUri(String requestUri) {
		List<Map<String, Object>> list = wsMenuMapper.findMenuByUri(requestUri);
//        List<WsMenu> menus = new ArrayList<WsMenu>();  
//        for (WsMenu menu : list) {  
//            if (urlMatcher(menu.getUrl(), requestUri))  
//            	menus.add(menu);  
//        }  
        return list;  
	}
    private boolean urlMatcher(String permstr, String requestUri) {  
        boolean isMatcher = false;  
        PathMatcher matcher = new AntPathMatcher();  
        isMatcher = matcher.match(permstr, requestUri);  
        return isMatcher;  
    } 
}
