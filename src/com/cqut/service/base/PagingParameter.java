package com.cqut.service.base;

public class PagingParameter {
	private String[] properties;
	private String[] foreignEntitys;
	private String condition;
	private boolean isForeignKey;
	private String groupField;
	private String orderField;
	private String sortMode;
	private int pageNum;
	private int pageIndex;
	private String joinEntity; 
	
	public PagingParameter(String[] properties, String[] foreignEntitys,
			String condition, int pageNum, int pageIndex) {
		super();
		this.properties = properties;
		this.foreignEntitys = foreignEntitys;
		this.condition = condition;
		this.pageNum = pageNum;
		this.pageIndex = pageIndex;
	}

	public PagingParameter(String[] properties, String[] foreignEntitys,
			String condition, boolean isForeignKey, String groupField,
			String orderField, String sortMode, int pageNum, int pageIndex) {
		this.properties = properties;
		this.foreignEntitys = foreignEntitys;
		this.condition = condition;
		this.isForeignKey = isForeignKey;
		this.groupField = groupField;
		this.orderField = orderField;
		this.sortMode = sortMode;
		this.pageNum = pageNum;
		this.pageIndex = pageIndex;
	}




	public String[] getProperties() {
		return properties;
	}
	public void setProperties(String[] properties) {
		this.properties = properties;
	}
	public String[] getForeignEntitys() {
		return foreignEntitys;
	}
	public void setForeignEntitys(String[] foreignEntitys) {
		this.foreignEntitys = foreignEntitys;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public boolean isForeignKey() {
		return isForeignKey;
	}
	public void setForeignKey(boolean isForeignKey) {
		this.isForeignKey = isForeignKey;
	}
	public String getGroupField() {
		return groupField;
	}
	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getSortMode() {
		return sortMode;
	}
	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getJoinEntity() {
		return joinEntity;
	}

	public void setJoinEntity(String joinEntity) {
		this.joinEntity = joinEntity;
	}
	
	

}
