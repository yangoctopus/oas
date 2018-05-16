package com.yzy.oas.pojo;

import org.apache.struts2.json.annotations.JSON;

/**
 * 知识版本对应的pojo
 * **/
public class KnowLedgeVersion {

	private Integer kvid;
	private String title;
	private String content;
	private Integer vernum;
	private String verdate;
	
	//配置知识版本和知识节点many-to-one的关系
	private KnowLedgeTree ktree;

	public Integer getKvid() {
		return kvid;
	}

	public void setKvid(Integer kvid) {
		this.kvid = kvid;
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

	public Integer getVernum() {
		return vernum;
	}

	public void setVernum(Integer vernum) {
		this.vernum = vernum;
	}

	public String getVerdate() {
		return verdate;
	}

	public void setVerdate(String verdate) {
		this.verdate = verdate;
	}
	@JSON(serialize=false)
	public KnowLedgeTree getKtree() {
		return ktree;
	}

	public void setKtree(KnowLedgeTree ktree) {
		this.ktree = ktree;
	}
	
	
}
