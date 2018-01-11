package com.weishui.mapper;

import java.util.List;

import com.weishui.model.WsUser;

public interface WsUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(WsUser record);

    int insertSelective(WsUser record);

    WsUser selectByPrimaryKey(String id);
    
    WsUser selectUserByName(String userName);
    
    String selectPositionByUname(String userName);

    int updateByPrimaryKeySelective(WsUser record);

    int updateByPrimaryKey(WsUser record);
}