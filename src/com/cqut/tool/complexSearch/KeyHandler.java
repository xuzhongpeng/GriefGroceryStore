package com.cqut.tool.complexSearch;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqut.tool.classLoader.ClassLoaderTool;
import com.cqut.tool.classLoader.IClassLoaderTool;
import com.cqut.tool.util.PropertiesTool;


public class KeyHandler {
	
	private static Map<String,Map<String,String>> foreignKeys = new HashMap<String, Map<String,String>>();
	
	private KeyHandler(){
		
		String entityPackage = PropertiesTool.getSystemPram("entityPath");
		if(entityPackage == null){
			System.err.println("读取entity所在路径出错,默认使用com.cqut.entity");
			entityPackage = "com.cqut.entity";
		}
		
		
		IClassLoaderTool tool = new ClassLoaderTool();
		List<Class<?>> Classes = tool.loaderClassInPackage(entityPackage);
		
		for(Class<?> c : Classes) {
			String simpleName = c.getSimpleName().toLowerCase();
			
			Map<String,String> entityKey = new HashMap<String, String>();
			
			Field[] fs = c.getDeclaredFields();
			for(Field f : fs) {
				Object o = f.getAnnotation(ForeignKey.class);
				if(o != null) {
					ForeignKey a = (ForeignKey)o;
					Class<?> targetClass = a.target();
					String field = a.field();

					String targetName = targetClass.getSimpleName().toLowerCase();
					String key = simpleName+"."+f.getName() + " = " + targetName + "." + field;
					entityKey.put(targetName, key);
					//System.out.println("   ++++++ " + targetName + "   " + key);
				}
			}
			
			if(entityKey.size() > 0) {
				//System.out.println(simpleName + "   ++++++ ");
				foreignKeys.put(simpleName, entityKey);
			}
		}
	}
	
	public static String getForeignKey(String sourceName, String targetName){
		/*for(Entry<String,Map<String,String>> outEn : foreingKeys.entrySet()){
			System.out.println("source  " + outEn.getKey() );
			for(Entry<String,String> inEn :outEn.getValue().entrySet()) {
				System.out.print(inEn.getValue() + "\t");
			}
		}*/
		
		sourceName = sourceName.toLowerCase();
		//System.out.println(sourceName + "  ___  ");
		//if(foreignKeys.containsKey(sourceName)) {
		if(foreignKeys.get(sourceName) != null) {
			//System.out.println("有的啊" + targetName);
			return foreignKeys.get(sourceName).get(targetName.toLowerCase());
		}
		else {
			return null;
		}
	}
}