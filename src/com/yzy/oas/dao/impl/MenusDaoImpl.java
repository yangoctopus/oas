package com.yzy.oas.dao.impl;



import com.yzy.oas.dao.MenusDao;
import com.yzy.oas.pojo.Menus;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenusDaoImpl 
	extends BaseDao implements MenusDao {

	
	@Override
	public List<Menus> loadMenusList() {
		// TODO Auto-generated method stub
		return (List<Menus>) super.getHibernateTemplate().find("from Menus");
	}


}
