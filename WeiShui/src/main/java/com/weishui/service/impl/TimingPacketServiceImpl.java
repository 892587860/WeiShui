package com.weishui.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.TimingPacketMapper;
import com.weishui.model.TimingPacket;
import com.weishui.service.TimingPacketService;
//可以消除xml中对bean的配置  
@Service  
//此处使用spring的声明式事务，不在使用sqlsession和提交事务了  
@Transactional 
public class TimingPacketServiceImpl implements TimingPacketService{
	
	@Resource
	private TimingPacketMapper timingPacketMapper;

	@Override
	public int insert(TimingPacket record) {
		return timingPacketMapper.insert(record);
	}

	@Override
	public int insertSelective(TimingPacket record) {
		return timingPacketMapper.insertSelective(record);
	}

	@Override
	public List<TimingPacket> findAll() {
		return timingPacketMapper.findAll();
	}

}
