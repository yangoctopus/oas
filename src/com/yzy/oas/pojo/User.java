package com.yzy.oas.pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private Integer uid;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private String email;
	
	//封装数据库查询的部门的名称
	private String dname;
	//封装数据库查询的岗位的名称
	private String pname;
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	//建立User和Dept关系（many-to-one）
	private Dept dept;
	//建立User和Post关系（many-to-many）
	private Set<Post> psts=new HashSet<Post>();
	
	
	public Set<Post> getPsts() {
		return psts;
	}

	public void setPsts(Set<Post> psts) {
		this.psts = psts;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User(Integer uid, String username, 
			String phone, String dname,
			String pname) {
		super();
		this.uid = uid;
		this.username = username;
		this.phone = phone;
		this.dname = dname;
		this.pname=pname;
	}
	
	public User() {
		super();
	 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	
	

}
