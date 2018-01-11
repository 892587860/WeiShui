package com.weishui.mapper;

import java.util.List;

import com.weishui.model.TimingPacket;

public interface TimingPacketMapper {
    int insert(TimingPacket record);

    int insertSelective(TimingPacket record);
    
    List<TimingPacket> findAll();
}