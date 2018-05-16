package com.yzy.oas.dao;

import com.yzy.oas.pojo.User;

import java.util.List;


public interface UserDao {

	/**
	 * 添加用户信息
	 * **/
	public void addUser(User user);
	
	/***
	 * 获得用户列表
	 * **/
	List<User> loadUserList();

    void delUser(User user);

    User findSingleUser(Integer uid);

    void updateUser(User user);

    List<User> loadUserByUname(String username);
}
