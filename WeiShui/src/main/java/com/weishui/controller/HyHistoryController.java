package com.weishui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weishui.model.HyHistory;
import com.weishui.service.HyHistoryService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping(value = "/hyHistory")
public class HyHistoryController {
	@Resource
	HyHistoryService hyHistoryService;
	
	@RequestMapping(value = "/getDataByPage")
	@ResponseBody
	public Map<String, Object> getAllPackets(@RequestParam("draw")int draw,@RequestParam("start")int start,
											@RequestParam("length")int length,HttpServletRequest request) {
		String search =request.getParameterValues("search[value]")[0];
		List<HyHistory> list=hyHistoryService.selectHistoryByPage(start,length,search);
		for(HyHistory history : list){
			history.setSendTime(history.getSendTime().substring(0,19));
		}
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("draw", draw);
		result.put("recordsTotal", hyHistoryService.getHistoryCount(search));
		result.put("recordsFiltered", hyHistoryService.getHistoryCount(search));
		result.put("data", list);
		return result;
		
	}
	@RequestMapping(value = "/getTrafficMonth")
	@ResponseBody
	public Map<String, Object> getTrafficMonth(@RequestParam("sendTime")String sendTime,
			@RequestParam("station")String station) {
		List<Map<String, String>> list=hyHistoryService.getTrafficMonth(sendTime, station);
		List<Object> list1=new ArrayList<Object>();
		List<Object> list2=new ArrayList<Object>();
		for(Map map:list){
			list1.add(map.get("sendTime"));
			list2.add(map.get("traffic"));
		}
		Map resultMap=new HashMap();
		resultMap.put("xData", list1);
		resultMap.put("yData", list2);
		return resultMap;
	}
	@RequestMapping(value = "/getVoltageMonth")
	@ResponseBody
	public Map<String, Object> getVoltageMonth(@RequestParam("sendTime")String sendTime,
			@RequestParam("station")String station) {
		List<Map<String, String>> list=hyHistoryService.getVoltageMonth(sendTime, station);
		List<Object> list1=new ArrayList<Object>();
		List<Object> list2=new ArrayList<Object>();
		for(Map map:list){
			list1.add(map.get("sendTime"));
			list2.add(map.get("voltage"));
		}
		Map resultMap=new HashMap();
		resultMap.put("xData", list1);
		resultMap.put("yData", list2);
		return resultMap;
	}
}
