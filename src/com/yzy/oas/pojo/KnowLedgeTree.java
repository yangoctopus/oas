package com.yzy.oas.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 知识树对应的pojo类
 * **/
public class KnowLedgeTree {

	private Integer ktid;
	private Integer ktpid;
	private String ktname;
	private String url;
	
	
	//配置知识节点和知识版本one-many-to的关系
	private Set<KnowLedgeVersion> kvers
		=new HashSet<KnowLedgeVersion>();
	
	public Set<KnowLedgeVersion> getKvers() {
		return kvers;
	}
	
	public void setKvers(Set<KnowLedgeVersion> kvers) {
		this.kvers = kvers;
	}
	public Integer getKtid() {
		return ktid;
	}
	public void setKtid(Integer ktid) {
		this.ktid = ktid;
	}
	public Integer getKtpid() {
		return ktpid;
	}
	public void setKtpid(Integer ktpid) {
		this.ktpid = ktpid;
	}
	public String getKtname() {
		return ktname;
	}
	public void setKtname(String ktname) {
		this.ktname = ktname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
