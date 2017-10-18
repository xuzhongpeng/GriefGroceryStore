package com.cqut.controller.base;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class FloatEditor extends PropertiesEditor{
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
