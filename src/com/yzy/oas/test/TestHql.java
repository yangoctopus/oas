package com.yzy.oas.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestHql {
	
	@Test
	public void testHql_01(){
		
		ApplicationContext appicationContext 
			= new ClassPathXmlApplicationContext("application_dao.xml",
					"activiti.cfg.xml",
					"application_service.xml");
		
		/*PostDao postDao=(PostDao) appicationContext.getBean("postDaoImpl");
		
		List<Integer> list = postDao.loadPostMenus(3);
		System.out.println(list);*/
		
		/*UserService userService=(UserService) appicationContext.getBean("userServiceImpl");
		
		//System.out.println(.size());
	
		List<UserVo> ulist=userService.loadUserListService();
		for(UserVo u:ulist){
			System.out.println(u.getUsername()+"\t"+u.getDname());
		}*/
		
		
	/*	KnowLedgeVersonDao dao=(KnowLedgeVersonDao) appicationContext.getBean("knowLedgeVersonDaoImpl");
	
		//System.out.println(dao.loadKnowLedgeVersonDao(2).size());
		System.out.println(dao.loadMaxVersion(2));*/
	}

}
