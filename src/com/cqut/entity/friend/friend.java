package com.cqut.entity.friend;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class friend  extends Entity{
	
	@ID
	private String ID;
	private String userID;
	private String friendID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFriendID() {
		return friendID;
	}

	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}

	@Override
	public String toString() {
		return "friend [ID=" + ID + ", userID=" + userID + ", friendID=" + friendID
				+ "]";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "friend";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

}
