package com.yzy.oas.pojo;

import java.util.HashSet;
import java.util.Set;

//部门的pojo类
public class Dept {

	private Integer did;
	private String dname;
	private String ddesc;
	
	//建立Dept和User关系（one-to-many）
	private Set<User> urs=new HashSet<User>();
	
	
	public Set<User> getUrs() {
		return urs;
	}
	public void setUrs(Set<User> urs) {
		this.urs = urs;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	
	
}
