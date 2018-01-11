package com.weishui.service;

import java.util.List;

import com.weishui.model.WsUser;
/**
 * 微信用户service
 * @author admin
 *
 */
public interface WsUserService {
	int deleteByPrimaryKey(String id);

    int insert(WsUser record);

    int insertSelective(WsUser record);

    WsUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WsUser record);

    int updateByPrimaryKey(WsUser record);
    
    public WsUser getUserByName(String username);
    /**
     * 根据用户名来获得认证所需的角色名，返回角色名的字符串数组
     * @param username
     * @return
     */
    public String selectPositionByUname(String username);
}
