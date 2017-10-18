package com.cqut.entity.picture;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Picture  extends Entity{
	@ID
	private String ID;
	private String pictureName;
	private String url;
	private String userID;
	private String picDescribe;
	private int state;
	private Date pulishTime;
	
	@Override
	public String toString() {
		return "Picture [ID=" + ID + ", pictureName=" + pictureName + ", url="
				+ url + ", userID=" + userID + ", picDescribe=" + picDescribe
				+ ", pulishTime=" + pulishTime + "]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPicDescribe() {
		return picDescribe;
	}

	public void setPicDescribe(String picDescribe) {
		this.picDescribe = picDescribe;
	}

	public Date getPulishTime() {
		return pulishTime;
	}

	public void setPulishID(Date pulishTime) {
		this.pulishTime = pulishTime;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "picture";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
