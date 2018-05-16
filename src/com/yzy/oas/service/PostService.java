package com.yzy.oas.service;


import com.yzy.oas.pojo.Menus;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;

import java.util.List;

public interface PostService {

	/**
	 * 保存岗位信息
	 * **/
	public void savePostService(PostVo pvo);
	/**
	 * 查询岗位信息列表
	 * **/
	public List<PostVo> loadPostListService();
	
	/**
	 * 查询某个岗位信息
	 * **/
	public PostVo loadPostService(Integer pid);
	
	/**
	 * 更新岗位信息
	 * **/
	public void updatePostService(PostVo pvo);
	
	/**
	 * 完成角色授权，给中间表，保存数据
	 * 1,2,3,4,5,6
	 * **/
	public void savePostOfMenus(String pmids);

    List<Menus> loadPostMenus(PostVo pvo);

    void delPost(PostVo pvo);


}
