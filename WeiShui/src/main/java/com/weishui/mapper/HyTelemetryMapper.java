package com.weishui.mapper;

import java.util.List;
import java.util.Map;

import com.weishui.model.HyTelemetry;

public interface HyTelemetryMapper {
    int deleteByPrimaryKey(String id);

    int insert(HyTelemetry record);

    int insertSelective(HyTelemetry record);

    HyTelemetry selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HyTelemetry record);

    int updateByPrimaryKey(HyTelemetry record);
    
    List<Map<String, String>> selectRemotePackets();
}