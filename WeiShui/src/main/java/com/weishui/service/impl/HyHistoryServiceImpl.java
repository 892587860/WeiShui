package com.weishui.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.HyHistoryMapper;
import com.weishui.model.HyHistory;
import com.weishui.service.HyHistoryService;
//可以消除xml中对bean的配置  
@Service  
//此处使用spring的声明式事务，不在使用sqlsession和提交事务了  
@Transactional 
public class HyHistoryServiceImpl implements HyHistoryService{
	
	@Resource
	private HyHistoryMapper hyHistoryMapper;

	@Override
	public int insert(HyHistory record) {
		return hyHistoryMapper.insert(record);
	}

	@Override
	public int insertSelective(HyHistory record) {
		return hyHistoryMapper.insertSelective(record);
	}

	@Override
	public List<HyHistory> findAll() {
		return hyHistoryMapper.findAll();
	}

	@Override
	public List<HyHistory> selectHistoryByPage(int start, int length,String search) {
		return hyHistoryMapper.selectHistoryByPage(start, length,search);
	}

	@Override
	public long getHistoryCount(String search) {
		return hyHistoryMapper.getHistoryCount(search);
	}

	@Override
	public List<Map<String, String>> getTrafficMonth(String sendTime,String station) {
		return hyHistoryMapper.getTrafficMonth(sendTime,station);
	}
	
	@Override
	public List<Map<String, String>> getVoltageMonth(String sendTime,String station) {
		return hyHistoryMapper.getVoltageMonth(sendTime,station);
	}


}
