package com.cqut.entity.userManage;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class userManage extends Entity{
	
	@ID
	private int ID;
	private String userID;
	private String userName;
	private String password;
	private int type;
	private String email;
	private Date registerTime;
	private String headImg;
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	@Override
	public String toString() {
		return "userManage [ID=" + ID + ", userID=" + userID + ", userName="
				+ userName + ", password=" + password + ", type=" + type
				+ ", email=" + email + ", registerTime=" + registerTime
				+ ", headImg=" + headImg + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "user";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}
}
