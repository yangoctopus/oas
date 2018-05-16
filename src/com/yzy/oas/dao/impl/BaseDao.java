package com.yzy.oas.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport {

	@Autowired
	public void setFactorySession01(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}
