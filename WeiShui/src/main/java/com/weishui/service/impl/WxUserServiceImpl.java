package com.weishui.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.WxUserMapper;
import com.weishui.model.WxUser;
import com.weishui.service.WxUserService;

@Service
@Transactional
public class WxUserServiceImpl implements WxUserService{
	@Resource
	WxUserMapper wxUserMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(WxUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(WxUser record) {
		// TODO Auto-generated method stub
		return wxUserMapper.insertSelective(record);
	}

	@Override
	public WxUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(WxUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(WxUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WxUser getUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectPositionByUname(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxUser selectByOpenId(String openId) {
		return wxUserMapper.selectByOpenId(openId);
	}

	@Override
	public int updateByOpenIdSelective(WxUser record) {
		return wxUserMapper.updateByOpenIdSelective(record);
	}


	
	
}
