package com.yzy.oas.dao;


import com.yzy.oas.pojo.Menus;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;

import java.util.List;

public interface PostDao {
	
	/**
	 * 添加岗位信息
	 * **/
	public void addPost(Post post);
	
	/***
	 * 查询岗位信息列表
	 * */
	public List<Post> loadPostList();
	
	/***
	 * 查询某个岗位信息
	 * **/
	public Post loadPost(Integer pid);
	
	/**
	 * 更新岗位信息
	 * **/
	public void updatePost(Post post);

    List<Menus> loadPostMenus(Post post);

    void delPost(Post post);


}
