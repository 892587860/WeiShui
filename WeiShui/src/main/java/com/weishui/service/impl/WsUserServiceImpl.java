package com.weishui.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.WsUserMapper;
import com.weishui.model.WsMenu;
import com.weishui.model.WsUser;
import com.weishui.service.WsUserService;

@Service
@Transactional
public class WsUserServiceImpl implements WsUserService{
	@Resource
	WsUserMapper wsUserMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(WsUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(WsUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WsUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(WsUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(WsUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WsUser getUserByName(String username) {
		return wsUserMapper.selectUserByName(username);
	}

	@Override
	public String selectPositionByUname(String username) {
		return wsUserMapper.selectPositionByUname(username);
	}

	
}
