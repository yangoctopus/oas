package com.yzy.oas.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yzy.oas.dao.MenusDao;
import com.yzy.oas.pojo.Menus;
import com.yzy.oas.service.MenusService;
import com.yzy.oas.vo.MenusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenusServiceImpl implements MenusService {

	//注入dao对象
	@Autowired
	private MenusDao menusDao;
	@Override
	public List<MenusVo> loadMeunsListService() {
		// TODO Auto-generated method stub
		List<MenusVo> mvoList=new ArrayList<MenusVo>();
		
		List<Menus> mlist=menusDao.loadMenusList();
		
		for(Menus m:mlist){
			MenusVo mvo = new MenusVo();
			BeanUtils.copyProperties(m, mvo);
			
			mvoList.add(mvo);
		}
		return mvoList;
	}

}
