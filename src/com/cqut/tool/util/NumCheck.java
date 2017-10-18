package com.cqut.tool.util;

public class NumCheck {
	// 用来检测字符串是否是数字
	public static boolean numCheck(String str) {
		if (str.length() == 0) {
			return false;
		}
		char ch = str.charAt(0);
		boolean result = false;
		
		if (ch == '-') {
			String subStr = str.substring(1);
			if (subStr.matches("[0-9]+\\.?[0-9]*")) {
				result = true;
			}
		} else {
			if (str.matches("[0-9]+\\.?[0-9]*")) {
				result = true;
			}
		}

		return result;
	}
}
