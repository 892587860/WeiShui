package com.weishui.controller;

import java.util.LinkedList;
import java.util.List;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.springframework.context.ApplicationContext;

import com.weishui.model.TimingPacket;
import com.weishui.service.TimingPacketService;
import com.weishui.util.SpringContextUtil;

public class SendMessage {
	public void addMessage() {
		ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
		TimingPacketService service = (TimingPacketService)SpringContextUtil.getBean(TimingPacketService.class);
		list = service.findAll();
		Browser.withCurrentPage(new Runnable() {// 启用监听客户端当前页线程
			public void run() {// 把数据添加到客户端调用的方法中
				ScriptSessions.addFunctionCall("receiveMessages", list.toString());
			}
		});
	}

	private List<TimingPacket> list = new LinkedList<TimingPacket>();
}
