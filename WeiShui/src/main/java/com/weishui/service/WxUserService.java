package com.weishui.service;


import java.util.List;

import com.weishui.model.WxUser;

public interface WxUserService {
	int deleteByPrimaryKey(String id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String id);
    
    WxUser selectByOpenId(String openId);

    int updateByPrimaryKeySelective(WxUser record);
    
    int updateByOpenIdSelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
    
    public WxUser getUserByName(String username);
    /**
     * 根据用户名来获得认证所需的角色名，返回角色名的字符串数组
     * @param username
     * @return
     */
    public String selectPositionByUname(String username);
}
