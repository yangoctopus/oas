package com.yzy.oas.dao;

import java.util.List;
import com.yzy.oas.pojo.Menus;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;

public interface MenusDao {

	/**
	 * 加载数据库所有菜单资源
	 * **/
	public List<Menus> loadMenusList();


}
