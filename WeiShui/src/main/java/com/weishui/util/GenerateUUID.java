package com.weishui.util;

import java.util.UUID;

public class GenerateUUID {

	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(uuid);
		return uuid;
	}
}
