package com.cqut.tool.util;

import java.text.DecimalFormat;

public class BeanUtil {
	/**
	 * @author wangyuanqin
	 * @param ParentCode 父节点code
	 * @param lastCode 上一个节点code
	 * @return 当前节点code
	 */
	public static synchronized String creatId(String ParentCode,String lastCode){
		/**
		 * if(ParentCode.equals("")||ParentCode==null){
		 * ParentCode="";
		 * }
		 * */
		
		if(lastCode == null || lastCode.equals("")  ){
			lastCode = ParentCode + "0000";
		}
		int currentFourNumber = Integer.parseInt(lastCode.substring(ParentCode.length(), lastCode.length())) + 1;
		DecimalFormat df = new DecimalFormat( "0000" );
		String currentCode =  ParentCode + df.format(currentFourNumber);
		return currentCode;
	}
}
