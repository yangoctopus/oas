package com.yzy.oas.vo;
/***
 * 封装需要响应的代办任务信息
 * **/
public class TaskVo {

	private String taskId; //代办任务id
	private String title;  //任务标题
	private String apper;  //申请者
	private String pdate;  //申请日期
	
	private String pinstid; //任务对应的流程实例id
	
	
	private String username; //当前登录用于名称
	private String yj;//审批意见
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getYj() {
		return yj;
	}
	public void setYj(String yj) {
		this.yj = yj;
	}
	public String getPinstid() {
		return pinstid;
	}
	public void setPinstid(String pinstid) {
		this.pinstid = pinstid;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApper() {
		return apper;
	}
	public void setApper(String apper) {
		this.apper = apper;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
	
	
}
