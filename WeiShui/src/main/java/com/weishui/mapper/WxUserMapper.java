package com.weishui.mapper;

import java.util.List;

import com.weishui.model.WxUser;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);
    
    int updateByOpenIdSelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
    
    WxUser selectByOpenId(String openId);
}