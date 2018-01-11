package com.weishui.mapper;

import java.util.List;
import java.util.Map;

import com.weishui.model.WsMenu;

public interface WsMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(WsMenu record);

    int insertSelective(WsMenu record);

    WsMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WsMenu record);

    int updateByPrimaryKey(WsMenu record);
    
	List<Map<String, Object>> findMenuByUri(String requestUri);
}