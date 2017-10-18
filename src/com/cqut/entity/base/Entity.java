package com.cqut.entity.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public abstract class Entity implements Serializable{

	public void setProperties(Map<String, Object> properties) {
		Field[] fields = this.getClass().getDeclaredFields(); //从类中
		for(Field field:fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			try {
				if(this.getClass().getDeclaredMethod("get"+fieldName.toUpperCase().charAt(0)+fieldName.substring(1))==null) {
					continue;
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				continue;
			}
			//properties 从数据库取出来的
			Object value = properties.get(fieldName);//toUpperCase()
			//System.out.println(fieldName+"---------"+field.getType()+"------"+field.getType().isPrimitive());
			if(!isBaseDataType(field.getType())&&value!=null) {
				try {
					ByteArrayInputStream bi = new ByteArrayInputStream(
							(byte[]) value);
					ObjectInputStream oi = new ObjectInputStream(bi);
					value = oi.readObject();
					bi.close();
					oi.close();
				} catch (Exception e) {
					System.out.println("translation" + e.getMessage());
					e.printStackTrace();
				}
			}
			try {
				if(value!=null) {
					field.set(this, value);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Set<Entry<String, Object>> getProperties() {
		return toMap().entrySet();
	}

	/*protected Object getProperty(String property) {
		Object value = properties.get(property);
		if(value==null) {
			return null;
		}else if (isBaseDataType(value.getClass())) {
			return value;
		}else if(value.getClass().equals(Timestamp.class)) {
			return new Date(((Timestamp)value).getTime());
		} else {
			try {
				ByteArrayInputStream bi = new ByteArrayInputStream(
						(byte[]) value);
				ObjectInputStream oi = new ObjectInputStream(bi);
				value = oi.readObject();
				bi.close();
				oi.close();
			} catch (Exception e) {
				System.out.println("translation" + e.getMessage());
				e.printStackTrace();
			}
		}
		return value;
	}

	protected void setProperty(String property, Object value) {
		Class clazz = value.getClass();
		if (isBaseDataType(clazz)) {
			properties.put(property, value);
		} else {
			byte[] bytes = null;
			try {
				ByteArrayOutputStream bo = new ByteArrayOutputStream();
				ObjectOutputStream oo = new ObjectOutputStream(bo);
				oo.writeObject(value);
				bytes = bo.toByteArray();
				bo.close();
				oo.close();
			} catch (Exception e) {
				System.out.println("translation" + e.getMessage());
				e.printStackTrace();
			}
			properties.put(property, bytes);
		}
	}
*/
	public abstract String getTableName();

	public abstract String getPrimaryKey();

	public static <T extends Entity> String getTableName(Class<T> t) {
		{
			try {
				return t.newInstance().getTableName();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static <T extends Entity> String getPrimaryKey(Class<T> t) {
		{
			try {
				return t.newInstance().getPrimaryKey();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static boolean isBaseDataType(Class clazz) {
		//System.out.println(clazz.getGenericSuperclass());
		if (clazz.isPrimitive()||(clazz.getGenericSuperclass()!=null&&clazz.getGenericSuperclass().equals(Number.class)) || clazz.equals(String.class)
				|| clazz.equals(Date.class)) {
			return true;
		}
		return false;
	}
	
	public static String getSQlType(Class clazz) {
		String type = clazz.getSimpleName();
		if("int".equals(type)) {
			return "int(10)";
		}
		
		if("float".equals(type)) {
			return "float(1000)";
		}
		
		if("double".equals(type)) {
			return "double(2000)";
		}
		
		if("String".equals(type)) {
			return "varchar(225)";
		}
		
		if("Date".equals(type)) {
			return "datetime";
		}
		return "blob(0)";
	}
	
	public Map<String,Object> toMap() {
		Map<String,Object> temp = new HashMap<String,Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field:fields) {
			field.setAccessible(true);
			//field.getAnnotation(annotationType)
			String fieldName = field.getName();
			
			try {
				if(this.getClass().getDeclaredMethod("get"+fieldName.toUpperCase().charAt(0)+fieldName.substring(1))==null) {
					continue;
				}
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				continue;
			}
			Object value = null;
			try {
				value = field.get(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!isBaseDataType(field.getType())&&value!=null) {
				byte[] bytes = null;
				try {
					ByteArrayOutputStream bo = new ByteArrayOutputStream();
					ObjectOutputStream oo = new ObjectOutputStream(bo);
					oo.writeObject(value);
					bytes = bo.toByteArray();
					bo.close();
					oo.close();
				} catch (Exception e) {
					System.out.println("translation" + e.getMessage());
					e.printStackTrace();
				}
				value = bytes;
			}
			if(value!=null) {
				temp.put(fieldName, value);
			}
		}
		return temp;
	}
	private void writeObject(ObjectOutputStream os) throws IOException {     
	      os.defaultWriteObject();//java对象序列化默认操作     
	      os.writeObject(toMap());
	  }     
	    
	  private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {     
	      is.defaultReadObject();//java对象反序列化默认操作     
	     Map<String,Object> temp = (Map<String,Object>)is.readObject();
	     setProperties(temp);
	  }   
}
