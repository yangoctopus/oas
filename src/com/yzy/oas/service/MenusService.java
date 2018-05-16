package com.yzy.oas.service;

import com.yzy.oas.vo.MenusVo;

import java.util.List;

public interface MenusService {
	
	/**
	 * 加载所有菜单资源
	 * **/
	public List<MenusVo> loadMeunsListService();

}
