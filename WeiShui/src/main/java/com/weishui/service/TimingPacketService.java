package com.weishui.service;

import java.util.List;

import com.weishui.model.TimingPacket;

public interface TimingPacketService {
	int insert(TimingPacket record);

	int insertSelective(TimingPacket record);
	
	List<TimingPacket> findAll();
}
