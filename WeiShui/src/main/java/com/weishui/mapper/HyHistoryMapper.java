package com.weishui.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.weishui.model.HyHistory;

public interface HyHistoryMapper {
    int insert(HyHistory record);

    int insertSelective(HyHistory record);
    
    List<HyHistory> findAll();
    
    List<HyHistory> selectHistoryByPage(@Param(value="start") Integer start,@Param(value="length") Integer length,
    		@Param(value="search") String search);
    
    long getHistoryCount(@Param(value="search") String search);
    
    List<Map<String, String>> getTrafficMonth(@Param(value="sendTime") String sendTime,@Param(value="station") String station);
    
    List<Map<String, String>> getVoltageMonth(@Param(value="sendTime") String sendTime,@Param(value="station") String station);
}