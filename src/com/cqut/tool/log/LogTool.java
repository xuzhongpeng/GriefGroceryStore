package com.cqut.tool.log;

import org.apache.log4j.Logger;


public class LogTool implements ILogTool {
	
	Logger logger;
	
	public LogTool(Class<?> clazz) {
		logger  =  Logger.getLogger(clazz);
	}
	
	@Override
	public void  error(Object message) {
		logger.error(message);
	}
}
