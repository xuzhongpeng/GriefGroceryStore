package com.cqut.entity.dailyManage;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class daily extends Entity{
	
	@ID
	private String ID;
	private String userID;
	private int contentType;
	private String title;
	private String content;
	private String pictureID;
	private Date releaseTime;
	private String musicSrc;
	private int loved;
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

	public int getContentType() {
		return contentType;
	}

	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPictureID() {
		return pictureID;
	}

	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Override
	public String toString() {
		return "daily [ID=" + ID + ", userID=" + userID + ", contentType="
				+ contentType + ", title=" + title + ", content=" + content
				+ ", pictureID=" + pictureID + ", releaseTime=" + releaseTime+",musicSrc=" + musicSrc
				+ ",loved="+loved+"]";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "daily";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}

	public String getMusicSrc() {
		return musicSrc;
	}

	public void setMusicSrc(String musicSrc) {
		this.musicSrc = musicSrc;
	}

	public int getLoved() {
		return loved;
	}

	public void setLoved(int loved) {
		this.loved = loved;
	}

}
