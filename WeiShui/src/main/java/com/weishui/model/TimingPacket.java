package com.weishui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//定时报
public class TimingPacket {
	private String id;
	//报头
	private String frameStartChar; //帧起始符2B
	private String centralAddress; //中心站地址1B
	private String headRemoteAddress; //遥测站地址5B
	private String password; //密码2B
	private String functionCode; //功能码1B
	private String packetUpwardChar; //报文上行标识符4b
	private Integer mainBodyLength; //报文正文长度12b
	private String packetStartChar; //报文起始符1B
	//报文正文较长时，对报文正文分包
	private String packetTotalSize; //包总数12b
	private String packeSerialNumber; //序列号12b
	
	//正文
	private String mainBodySerialNumber; //流水号2B
	private String transmitTime; //发报时间6B（bcd码）
	private String romoteAdressChar; //遥测站地址标识符
	private String romoteAdress; //遥测站地址
	private String remoteCategoryCode; //遥测站分类码
	private String observeTimeChar; //观测时间标识符
	private String observeTime; //观测时间
	private List<Map<String,String>> elements = new ArrayList<Map<String,String>>();
	private String underWaterInstantDepth; //地下水瞬时埋深
	private String instantWaterTemp; //瞬时水温 
	
	private String powerVoltage; //电源电压
	//报文结束符1B
	private String packetEndChar; 
	
	//校验码2B
	private String validateCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrameStartChar() {
		return frameStartChar;
	}

	public void setFrameStartChar(String frameStartChar) {
		this.frameStartChar = frameStartChar;
	}

	public String getCentralAddress() {
		return centralAddress;
	}

	public void setCentralAddress(String centralAddress) {
		this.centralAddress = centralAddress;
	}

	public String getHeadRemoteAddress() {
		return headRemoteAddress;
	}

	public void setHeadRemoteAddress(String headRemoteAddress) {
		this.headRemoteAddress = headRemoteAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getPacketUpwardChar() {
		return packetUpwardChar;
	}

	public void setPacketUpwardChar(String packetUpwardChar) {
		this.packetUpwardChar = packetUpwardChar;
	}

	public Integer getMainBodyLength() {
		return mainBodyLength;
	}

	public void setMainBodyLength(Integer mainBodyLength) {
		this.mainBodyLength = mainBodyLength;
	}

	public String getPacketStartChar() {
		return packetStartChar;
	}

	public void setPacketStartChar(String packetStartChar) {
		this.packetStartChar = packetStartChar;
	}

	public String getPacketTotalSize() {
		return packetTotalSize;
	}

	public void setPacketTotalSize(String packetTotalSize) {
		this.packetTotalSize = packetTotalSize;
	}

	public String getPackeSerialNumber() {
		return packeSerialNumber;
	}

	public void setPackeSerialNumber(String packeSerialNumber) {
		this.packeSerialNumber = packeSerialNumber;
	}

	public String getMainBodySerialNumber() {
		return mainBodySerialNumber;
	}

	public void setMainBodySerialNumber(String mainBodySerialNumber) {
		this.mainBodySerialNumber = mainBodySerialNumber;
	}

	public String getTransmitTime() {
		return transmitTime;
	}

	public void setTransmitTime(String transmitTime) {
		this.transmitTime = transmitTime;
	}

	public String getRomoteAdressChar() {
		return romoteAdressChar;
	}

	public void setRomoteAdressChar(String romoteAdressChar) {
		this.romoteAdressChar = romoteAdressChar;
	}

	public String getRomoteAdress() {
		return romoteAdress;
	}

	public void setRomoteAdress(String romoteAdress) {
		this.romoteAdress = romoteAdress;
	}

	public String getRemoteCategoryCode() {
		return remoteCategoryCode;
	}

	public void setRemoteCategoryCode(String remoteCategoryCode) {
		this.remoteCategoryCode = remoteCategoryCode;
	}

	public String getObserveTimeChar() {
		return observeTimeChar;
	}

	public void setObserveTimeChar(String observeTimeChar) {
		this.observeTimeChar = observeTimeChar;
	}

	public String getObserveTime() {
		return observeTime;
	}

	public void setObserveTime(String observeTime) {
		this.observeTime = observeTime;
	}

	public List<Map<String, String>> getElements() {
		return elements;
	}

	public void setElements(List<Map<String, String>> elements) {
		this.elements = elements;
	}

	public String getPacketEndChar() {
		return packetEndChar;
	}

	public void setPacketEndChar(String packetEndChar) {
		this.packetEndChar = packetEndChar;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getPowerVoltage() {
		return powerVoltage;
	}

	public void setPowerVoltage(String powerVoltage) {
		this.powerVoltage = powerVoltage;
	}

	public String getUnderWaterInstantDepth() {
		return underWaterInstantDepth;
	}

	public void setUnderWaterInstantDepth(String underWaterInstantDepth) {
		this.underWaterInstantDepth = underWaterInstantDepth;
	}

	public String getInstantWaterTemp() {
		return instantWaterTemp;
	}

	public void setInstantWaterTemp(String instantWaterTemp) {
		this.instantWaterTemp = instantWaterTemp;
	}

	
	
}
