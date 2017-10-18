package com.cqut.entity.testReport;

import java.util.Date;

import com.cqut.entity.base.Entity;
import com.cqut.service.tableCreator.ID;

public class TestReport extends Entity{
	
	@ID
	private String ID;
	private String receiptlistID;
	private String taskID;
	private String fileID;
	private String versionNumber;
	private String versionInformation;
	private int state;
	private String dismissreason2;
	private String dismissreason3;
	private String remarks;
	private int sendState;
	private String sendMan;
	private String receiveMan;
	private Date sendTime;
	
	public String getID() {
		return ID;
	}	
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getReceiptlistID() {
		return receiptlistID;
	}	
	
	public void setReceiptlistID(String receiptlistID) {
		this.receiptlistID = receiptlistID;
	}
	public String getTaskID() {
		return taskID;
	}	
	
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getFileID() {
		return fileID;
	}	
	
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public String getVersionNumber() {
		return versionNumber;
	}	
	
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public String getVersionInformation() {
		return versionInformation;
	}	
	
	public void setVersionInformation(String versionInformation) {
		this.versionInformation = versionInformation;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public String getDismissreason2() {
		return dismissreason2;
	}	
	
	public void setDismissreason2(String dismissreason2) {
		this.dismissreason2 = dismissreason2;
	}
	public String getDismissreason3() {
		return dismissreason3;
	}	
	
	public void setDismissreason3(String dismissreason3) {
		this.dismissreason3 = dismissreason3;
	}
	public String getRemarks() {
		return remarks;
	}	
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public int getSendState() {
		return sendState;
	}

	public void setSendState(int sendState) {
		this.sendState = sendState;
	}

	public String getSendMan() {
		return sendMan;
	}

	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}

	public String getReceiveMan() {
		return receiveMan;
	}

	public void setReceiveMan(String receiveMan) {
		this.receiveMan = receiveMan;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "TestReport [" +  "ID=" + ID  + ", " +  "receiptlistID=" + receiptlistID  + ", " +  "taskID=" + taskID  + ", " +  "fileID=" + fileID  + ", " +  "versionNumber=" + versionNumber  + ", " +  "versionInformation=" + versionInformation  + ", " +  "state=" + state  + ", " +  "dismissreason2=" + dismissreason2  + ", " +  "dismissreason3=" + dismissreason3  + ", " +  "remarks=" + remarks  + ", "   + "]";
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "testReport";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "ID";
	}
}
