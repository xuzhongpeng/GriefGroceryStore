package com.cqut.tool.classLoader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassLoaderTool implements IClassLoaderTool {

	private ClassLoader loader = Thread.currentThread().getContextClassLoader();  

	private static Map<String,List<Class<?>>> classCache = new HashMap<String,List<Class<?>>>();
	
	/* (non-Javadoc)
	 * @see com.cqut.tool.util.IClassLoaderTool#loaderClassInPackage(java.lang.String)
	 */
	@Override
	public List<Class<?>> loaderClassInPackage(String packagePath){
		if(classCache.containsKey(packagePath))	//如果缓存中已经存在，则从缓存中读取
			return classCache.get(packagePath);
		
		 List<Class<?>> result = new ArrayList<Class<?>>();
		
		 
		 List<String> classNames = getClassNameInPackage(packagePath);
		 
		 
		 for(String name : classNames) {
			 try{
			 	result.add(this.loaderClass(name));
			 } catch(ClassNotFoundException e) {
				 System.out.println("类 " + name + "无法加载");
			 }
		 }
		 
		 classCache.put(packagePath,result);	//加入缓存
		 return result;
	}
	
	/* (non-Javadoc)
	 * @see com.cqut.tool.util.IClassLoaderTool#loaderClass(java.lang.String)
	 */
	@Override
	public Class<?> loaderClass(String classPath) throws ClassNotFoundException{
		try{
			Class<?> clazz = loader.loadClass(classPath);
			return clazz;
		} catch(ClassNotFoundException e){
			System.out.println("当前线程没有加载此类");
			Class<?> clazz = Class.forName(classPath);
			return clazz;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.cqut.tool.util.IClassLoaderTool#getClassNameInPackage(java.lang.String)
	 */
	@Override
	public List<String> getClassNameInPackage(String packagePath){

		URL url = loader.getResource(packagePath.replaceAll("\\.", "/"));
		if (url != null && "file".equals(url.getProtocol())) {  
			return getClassNameByFile(url.getPath(),  true);  
        } else {  
        	System.out.println("没有找到路径 " + packagePath);
        	return new ArrayList<String>();
        }  
	}
	
	
	/**
	 * 根据参数查找一个包及子包中所有的java类
	 * @param filePath
	 * @param childPackage
	 * @return
	 */
    private  List<String> getClassNameByFile(String filePath, boolean childPackage) {
    	
        List<String> myClassName = new ArrayList<String>();  
       
        
        //System.out.println(filePath + " ++++　　");
        filePath = filePath.replace("%20", " ");
        
        File file = new File(filePath);  
        
        for (File childFile :  file.listFiles()) {  
            if (childFile.isDirectory()) {  
                if (childPackage) {  
                    myClassName.addAll(getClassNameByFile(childFile.getPath(), childPackage));  
                }  
            } else {  
                String childFilePath = childFile.getPath();  
                if (childFilePath.endsWith(".class")) {  
                	childFilePath = childFilePath.substring(childFilePath.indexOf("classes") + 8, childFilePath.lastIndexOf("."));  
                	childFilePath = childFilePath.replace("\\", ".");  
                	childFilePath = childFilePath.replace("/", ".");
                    myClassName.add(childFilePath);  
                }  
            }  
        }  
        return myClassName;  
    }  
}
