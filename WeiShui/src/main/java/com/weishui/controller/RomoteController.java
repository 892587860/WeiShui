package com.weishui.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weishui.service.HyTelemetryService;
@Controller
@RequestMapping(value="remote")
public class RomoteController {
	@Resource
	HyTelemetryService hyTelemetryService;
	
	@RequestMapping(value="/selectRemotePackets")
	@ResponseBody
	public Map<String, Object> selectRemotePackets(){
		List<Map<String, String>> list=hyTelemetryService.selectRemotePackets();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("data", list);
		return map;
	}
}
