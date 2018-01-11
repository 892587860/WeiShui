package com.weishui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptSessions;
import org.springframework.context.ApplicationContext;

import com.weishui.model.TimingPacket;
import com.weishui.service.TimingPacketService;
public class TimingPacketParseUtil {
	
	public static boolean parseUpPacket(String packet){
		TimingPacket timingPacket = new TimingPacket();
		timingPacket.setId(GenerateUUID.getUUID());
		List<Map<String,String>> elements = new ArrayList<Map<String,String>>();
		int pos=0;
		//报头
		//帧起始符2B
		timingPacket.setFrameStartChar(packet.substring(0, pos+4));
		pos += 4;
		//中心站地址1B
		timingPacket.setCentralAddress(packet.substring(pos,pos+2));
		pos += 2;
		//遥测站地址5B
		timingPacket.setHeadRemoteAddress(packet.substring(pos,pos+10));
		pos += 10;
		//密码2B
		timingPacket.setPassword(packet.substring(pos,pos+4));
		pos += 4;
		//功能码1B
		timingPacket.setFunctionCode(packet.substring(pos,pos+2));
		pos += 2;
		//报文上行标识符4b
		timingPacket.setPacketUpwardChar(HexConvertUtil.hexTobinary(packet.substring(pos,pos+1)));
		//"0000"表示上行，"1000"表示下行
		if("1000".equals(timingPacket.getPacketUpwardChar())){
			return false;
		}
		pos += 1;
		//报文正文长度12b
		timingPacket.setMainBodyLength(Integer.parseInt(packet.substring(pos,pos+3),16));
		pos += 3;
		//报文起始符1B
		timingPacket.setPacketStartChar(packet.substring(pos,pos+2));
		pos += 2;
		//报文起始符为SYN(16H) 多包传输正文起始
		if("16".equals(timingPacket.getPacketStartChar())){
			//多包的包总数12b
			timingPacket.setPacketTotalSize(packet.substring(pos,pos+3));
			pos+=3;
			//本包的序列号12b
			timingPacket.setPackeSerialNumber(packet.substring(pos,pos+3));
			pos+=3;
		}
		//正文
		//流水号2B
		timingPacket.setMainBodySerialNumber(packet.substring(pos,pos+4));
		pos += 4;
		//发报时间6B（bcd码）
		timingPacket.setTransmitTime(packet.substring(pos,pos+12));
		pos += 12;
		//遥测站地址标识符2B
		timingPacket.setRomoteAdressChar(packet.substring(pos,pos+4));
		pos += 4;
		//遥测站地址5B
		timingPacket.setRomoteAdress(packet.substring(pos,pos+10));
		pos += 10;
		//遥测站分类码1B
		timingPacket.setRemoteCategoryCode(packet.substring(pos,pos+2));
		pos += 2;
		//观测时间标识符2B
		timingPacket.setObserveTimeChar(packet.substring(pos,pos+4));
		pos += 4;
		//观测时间5B
		timingPacket.setObserveTime(packet.substring(pos,pos+10));
		pos += 10;
		//要素信息组
		String elementString = packet.substring(pos);
		//38为电源电压的标识符引导符，表示要素信息组结束
		while(!"38".equals(elementString.substring(0,2))){
			Map<String, String> map = new HashMap<String, String>();
			elementString = getElement(elementString,timingPacket);
			elements.add(map);
		}
		timingPacket.setElements(elements);
		//获取电源电压值
		Map<String, String> map = new HashMap<String, String>();
		elementString = getElement(elementString,timingPacket);
		
		
		timingPacket.setPacketEndChar(elementString.substring(0,2));
		timingPacket.setValidateCode(elementString.substring(2,6));
		
		ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
		final TimingPacketService service = (TimingPacketService)SpringContextUtil.getBean(TimingPacketService.class);
		service.insert(timingPacket);
//		list = service.findAll();
//		Browser.withCurrentPage(new Runnable() {  
//            public void run() {  
//                ScriptSessions.addFunctionCall("onPageLoad", list); // 参数一是页面的javascript函数，参数二是函数的参数  
//            }  
//        });  
		return true;
	}
	//获取要素（或参数）属性和属性值
	public static String getElement(String elementString,TimingPacket timingPacket){
		
		//标识符引导符
		String leadChar = elementString.substring(0,2); 
		//标识符
		String charString = elementString.substring(2,4); 
		//将标识符转成2进制
		String binString=HexConvertUtil.hexTobinary(charString);
		//前5位表示数据字节数
		int byteSize = Integer.parseInt(binString.substring(0,5), 2);
		//后三位表示小数点后位数
		int pointPosition = Integer.parseInt(binString.substring(5,8), 2);
		//定义要素属性
		String elementKey = null ;
		String elementValue  = elementString.substring(4,4+byteSize*2);
		//0E地下水瞬时埋深 米 N(6,2)
		if("0E".equals(leadChar)){
			elementKey = "地下水瞬时埋深";
			timingPacket.setUnderWaterInstantDepth(addPointToStr(elementValue, pointPosition));

		}else if("03".equals(leadChar)){//03H C 瞬时水温 摄氏度 N(3,1)
			elementKey = "瞬时水温 ";
			timingPacket.setInstantWaterTemp(addPointToStr(elementValue, pointPosition));

		}if("38".equals(leadChar)){ //38H VT 电源电压 伏特 N(4,2)
			elementKey = "电源电压";
			timingPacket.setPowerVoltage(addPointToStr(elementValue, pointPosition));
		}
		//根据得到的数据字节数截取要素值
		
		
	//	map.put(elementKey, addPointToStr(elementValue, pointPosition));
		
		
		elementString = elementString.substring(4+byteSize*2);
		return elementString;
	}
	//在字符串指定位置中加小数点
	public static String addPointToStr(String str,int pointPosition){
		int size = str.length();
		String str1 = str.substring(0,size-pointPosition);
		String str2 = str.substring(size-pointPosition,size);
		return str1+"."+str2;
	}
	
	private static List<TimingPacket> list =new ArrayList<TimingPacket>();
}
