package com.cqut.tool.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesTool {
	static Properties systemPram;
	static Map<String, String> propMap = new HashMap<String, String>();

	public PropertiesTool() {
		// System.out.println("读取sys配置信息");

		systemPram = new Properties();
		InputStream inStream = PropertiesTool.class.getClassLoader()
				.getResourceAsStream("systemParameters.properties");
	

		if (inStream != null) {
			try {
				systemPram.load(new InputStreamReader(inStream , "UTF-8"));

				Set<Object> Setkeyset = systemPram.keySet();
				for (Object object : Setkeyset) {
					String propValue = systemPram
							.getProperty(object.toString()).toString();
					propMap.put(object.toString(), propValue);
				}
			} catch (IOException e) {
				System.out.println("读取系统配置出错");
				e.printStackTrace();
			}
		} else {
			System.err.println("系统配置路径出错");
		}
	}

	public static String getSystemPram(String key) {
		if (propMap.containsKey(key))
			return propMap.get(key);
		else {
			Object o = systemPram.getProperty(key);
			if (o != null) {
				propMap.put(key, o.toString());
				return o.toString();
			} else {
				System.err.println("读取" + key + "出错");
				return null;
			}
		}
	}

	public String getSeparatorChar() {
		String os = System.getProperty("os.name").toUpperCase();
		if (os.toLowerCase().startsWith("WIN")) {
			return "\\";
		}
		return "/";
	}
}
