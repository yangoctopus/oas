package com.yzy.oas.web.action;

import java.util.List;

import com.yzy.oas.service.MenusService;
import com.yzy.oas.vo.MenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class MenusAction 
	extends BaseAction implements ModelDriven<MenusVo>{

	private MenusVo mvo = new MenusVo();

	//封装响应到客户端的数据，转化为json的数组
	private List<MenusVo> mvoList;


	//注入service对象
	@Autowired
	private MenusService menusService;
	

	public List<MenusVo> getMvoList() {
		return mvoList;
	}

	@Override
	public MenusVo getModel() {
		// TODO Auto-generated method stub
		return mvo;
	}
	
	/**
	 * 打开角色授权窗口
	 * ***/
	public String loadPrivilegeUI(){
		//获得pid
		req.put("pid",mvo.getPid());
		return "privilegeUI";
	}
	
	/***
	 * 处理加载所有菜单资源的请求
	 * 响应ajax异步请求
	 * **/
	public String loadMenus(){
		mvoList=menusService.loadMeunsListService();
		
		return "loadMenus";
	}


	
}
