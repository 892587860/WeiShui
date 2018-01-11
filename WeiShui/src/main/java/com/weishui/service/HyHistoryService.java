package com.weishui.service;

import java.util.List;
import java.util.Map;


import com.weishui.model.HyHistory;

public interface HyHistoryService {
	int insert(HyHistory record);

	int insertSelective(HyHistory record);
	
	List<HyHistory> findAll();
	
	List<HyHistory> selectHistoryByPage(int start,int length,String search);
	
	List<Map<String, String>> getTrafficMonth(String sendTime,String station);
	
	List<Map<String, String>> getVoltageMonth(String sendTime,String station);
    
    long getHistoryCount(String search);
}
