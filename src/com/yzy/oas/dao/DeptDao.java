package com.yzy.oas.dao;

import com.yzy.oas.pojo.Dept;

import java.util.List;


public interface DeptDao {

	/***
	 * 查询所有部门信息
	 * **/
	public List<Dept> loadDeptList();

	/*
	* 添加部门
	* */
	public void saveDept(Dept dept);

	/*查询单个部门
	* */
	public Dept loadSingleDept(Dept dept);

	/*
	* 修改部门
	* */
	public void updateDept(Dept dept);

	/*删除部门*/
	public void delDept(Dept dept);
}
