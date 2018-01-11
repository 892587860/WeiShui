package com.weishui.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.HyTelemetryMapper;
import com.weishui.service.HyTelemetryService;

@Service
@Transactional
public class HyTelemetryServiceImpl implements HyTelemetryService{
	
	@Resource
	HyTelemetryMapper hyTelemetryMapper;
	@Override
	public List<Map<String, String>> selectRemotePackets() {
		return hyTelemetryMapper.selectRemotePackets();
	}

}
