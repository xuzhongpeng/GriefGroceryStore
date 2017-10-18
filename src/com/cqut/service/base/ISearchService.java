package com.cqut.service.base;

import java.util.List;
import java.util.Map;


public interface ISearchService {
	/**
	 * 多表查询
	 */
	public List<Map<String, Object>> searchForeign(String[] properties,
			String[] foreignEntitys,String condition,boolean isForeignKey);
	//带join的多表查询
	public List<Map<String, Object>> searchForeignWithJoin(String[] properties,
			String joinEntity, String[] foreignEntitys,String condition,boolean isForeignKey);
	
	/**
	 * 页面表格
	 */
	public int getForeignCount(String[] foreignEntitys,String condition,boolean isForeignKey);
	public int getForeignCountWithJoin(String joinEntity,String[] foreignEntitys,String condition,boolean isForeignKey);
	public int getForeignCountInFull(String primaryKey,String joinEntity,String[] foreignEntitys,String condition,boolean isForeignKey);
	
	/**
	 * 分页查询
	 */
	//参数最简单的分页查询，也就是最常用的
	public List<Map<String, Object>> searchPaging(String[] properties,
		String[] foreignEntitys, String condition,boolean isForeignKey, int pageNum, int pageIndex);
	
	//带join的分页查询
	public List<Map<String, Object>> searchPagingWithJoin(String[] properties,String joinEntity,
			String[] foreignEntitys, String condition,boolean isForeignKey, int pageNum, int pageIndex);
		
	//完整参数的分页查询
	public List<Map<String, Object>> searchPagingInFull(String[] properties,String joinEntity,
			String[] foreignEntitys, String condition, boolean isForeignKey,
			String groupField, String orderField, String sortMode,int pageNum, int pageIndex);
	

}
