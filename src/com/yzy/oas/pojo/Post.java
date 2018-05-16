package com.yzy.oas.pojo;

import org.apache.struts2.json.annotations.JSON;

import java.util.HashSet;
import java.util.Set;

//岗位对应的pojo类
public class Post {

	private Integer pid;
	private String pname;
	private String pdesc;
	
	//建立和岗位和资源的many-to-many关系
	private Set<Menus> mns = new HashSet<Menus>();
    //建立岗位和用户的关系many-to-many
    private Set<User> ues=new HashSet<User>();
    @JSON(serialize=false)
    public Set<User> getUes() {
        return ues;
    }

    public void setUes(Set<User> ues) {
        this.ues = ues;
    }

    public Set<Menus> getMns() {
		return mns;
	}
	public void setMns(Set<Menus> mns) {
		this.mns = mns;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
	
}
