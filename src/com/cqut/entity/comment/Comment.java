package com.cqut.entity.comment;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class Comment extends Entity{
	
	@ID
	private String ID;
	private String dailyID;
	private String comment;
	private Date commentTime;
	private String useredID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDailyID() {
		return dailyID;
	}

	public void setDailyID(String dailyID) {
		this.dailyID = dailyID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getUseredID() {
		return useredID;
	}

	public void setUseredID(String useredID) {
		this.useredID = useredID;
	}

	@Override
	public String toString() {
		return "Comment [ID=" + ID + ", dailyID=" + dailyID + ", comment="
				+ comment + ", commentTime=" + commentTime + ", useredID="
				+ useredID + "]";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "comment";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

}
