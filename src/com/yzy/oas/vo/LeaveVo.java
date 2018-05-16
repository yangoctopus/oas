package com.yzy.oas.vo;

import java.io.Serializable;

public class LeaveVo implements Serializable{
	
	private String pdid; //封装流程定义id
	private String[] apper; //审批人
	private String start;
	private String end;
	private String desces;
	private String username; //申请者
	public String getPdid() {
		return pdid;
	}
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	public String[] getApper() {
		return apper;
	}
	public void setApper(String[] apper) {
		this.apper = apper;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getDesces() {
		return desces;
	}
	public void setDesces(String desces) {
		this.desces = desces;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
