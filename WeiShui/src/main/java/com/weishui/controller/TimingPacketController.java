package com.weishui.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.weishui.model.TimingPacket;
import com.weishui.service.TimingPacketService;

@Controller
@RequestMapping(value = "/timing")
public class TimingPacketController {

	
	@Resource
	TimingPacketService timingPacketService;
	
	@RequestMapping(value = "/getAllData")
	@ResponseBody
	public List<TimingPacket> getAllPackets() {
		 
		return timingPacketService.findAll();
	}
	
	@RequestMapping(value = "/getRemoteData")
	@ResponseBody
	public List<TimingPacket> getRemoteData() {
		 
		return timingPacketService.findAll();
	}
}
