package com.weishui.util;

public class HexConvertUtil {
	//十六进制转为二进制
	public static String hexTobinary(String hexString)  
    {  
		if (hexString == null )  
            return null;  
        String bString = "", tmp;  
        for (int i = 0; i < hexString.length(); i++)  
        {  
            tmp = "0000"  
                    + Integer.toBinaryString(Integer.parseInt(hexString  
                            .substring(i, i + 1), 16));  
            bString += tmp.substring(tmp.length() - 4);  
        }  
        return bString;   
    } 
}
