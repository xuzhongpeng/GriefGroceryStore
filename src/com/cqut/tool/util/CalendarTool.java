package com.cqut.tool.util;

import java.util.Calendar;

public class CalendarTool {
	/**
	 * 
	 * 得到当前年份后两位
	 * @author wzj
	 * @date 2017年6月30日 下午3:09:41
	 * @return
	 */
	public static String getYearAfterTwo(){ 
		 Calendar calendar =  Calendar.getInstance() ;
		 String yeaString = String.valueOf(calendar.get(Calendar.YEAR));
		 yeaString = yeaString.substring(yeaString.length()-2);
		 return  yeaString;
		
	}
	
}
