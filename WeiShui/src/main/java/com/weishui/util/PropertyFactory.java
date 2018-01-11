package com.weishui.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyFactory {

	private static final Logger LOGGER = Logger.getLogger(PropertyFactory.class);

	private static Map<String, Properties> propMap = null;
	
	public static String getProperty(String filePath, String name) {
		if (propMap == null) {
			propMap = new HashMap<String, Properties>();
		}
		String key = getFileNameFromPath(filePath);
		ClassLoader classLoader = PropertyFactory.class.getClassLoader();  
        URL resource = classLoader.getResource(filePath);  
        String path = resource.getPath();  
        System.out.println(path);  
      
		if (!propMap.containsKey(key)) {
			Properties prop = new Properties();
			try {
				  InputStream is = classLoader.getResourceAsStream(filePath);  
				prop.load(is);
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				LOGGER.error(e.getStackTrace(), e);
				e.printStackTrace();
				return null;
			}
			propMap.put(key, prop);
			return prop.getProperty(name);
		}
		return propMap.get(key).getProperty(name);
	}

	private static String getFileNameFromPath(String path) {
		int location = path.lastIndexOf("/");
		if (location == -1) {
			return null;
		}
		return path.substring(location + 1);
	}

	
}
