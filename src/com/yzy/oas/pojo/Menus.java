package com.yzy.oas.pojo;

import java.util.HashSet;
import java.util.Set;

/***
 * 菜单类（资源）
 * **/
public class Menus {
	private Integer mid;
	private Integer pid;
	private String mname;
	private String url;
	
	////////////////////////////////
	
	private String icon;
	private Integer isParent;
	private Integer open;
	private String target;
	
	//建立Menus 和 岗位的many-to-many关系
	private Set<Post> pts = new HashSet<Post>();
	
	
	
	public Set<Post> getPts() {
		return pts;
	}
	public void setPts(Set<Post> pts) {
		this.pts = pts;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public Integer getOpen() {
		return open;
	}
	public void setOpen(Integer open) {
		this.open = open;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	
	
	

}
