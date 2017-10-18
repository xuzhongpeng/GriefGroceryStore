/**
 * @Title: DoubleEditor.java
 * @Package com.cqut.controller.basecontroller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author matao@cqrainbowsoft.com
 * @date 2014-8-15 下午9:06:49
 * @version V1.0
 */
package com.cqut.controller.base;

import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * 项目名称：CisdiRswpManage
 * 类名称：DoubleEditor
 * 类描述：   
 * 创建人：xhay
 * 创建时间：2014-8-15 下午9:06:49
 * 修改人：xhay
 * 修改时间：2014-8-15 下午9:06:49
 * 修改备注：   
 * @version 1.0
 * 软件工程创新实验室  
 */
public class DoubleEditor extends PropertiesEditor {
	@Override    
	public void setAsText(String text) throws IllegalArgumentException {    
		if (text == null || text.equals("")) {    
			text = "0";    
		}    
		setValue(Double.parseDouble(text));    
	}    

	@Override    
	public String getAsText() {    
		return getValue().toString();    
	} 
}
