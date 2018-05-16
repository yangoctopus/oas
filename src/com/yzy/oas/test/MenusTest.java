package com.yzy.oas.test;


import com.yzy.oas.pojo.Menus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class MenusTest {
	@Test
	public void addMenus(){
		ApplicationContext appicationContext = new ClassPathXmlApplicationContext("application_dao.xml");
		SessionFactory sessionFactory = (SessionFactory)appicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Menus Menusitem1 = new Menus();
		Menusitem1.setMid(1);
		Menusitem1.setIcon("style/images/MenuIcon/FUNC20082.gif");
		Menusitem1.setMname("办公自动化");
		Menusitem1.setPid(0);
		//Menusitem1.setChecked(0);
		Menusitem1.setIsParent(1);
		
		Menus Menus2 = new Menus();
		Menus2.setMid(2);
		Menus2.setIcon("style/images/MenuIcon/FUNC20001.gif");
		Menus2.setMname("个人办公");
		//Menus2.setChecked(0);
		Menus2.setPid(1);
		Menus2.setIsParent(1);
		
		Menus Menus21 = new Menus();
		Menus21.setMid(21);
		Menus21.setIcon("style/images/MenuIcon/FUNC20054.gif");
		Menus21.setMname("个人考勤");
		//Menus21.setChecked(0);
		Menus21.setPid(2);
		Menus21.setIsParent(0);
		
		
		Menus Menus22 = new Menus();
		Menus22.setMid(22);
		Menus22.setIcon("style/images/MenuIcon/FUNC23700.gif");
		Menus22.setMname("日程安排");
		//Menus22.setChecked(0);
		Menus22.setPid(2);
		Menus22.setIsParent(0);
		
		Menus Menus23 = new Menus();
		Menus23.setMid(23);
		Menus23.setIcon("style/images/MenuIcon/FUNC20069.gif");
		Menus23.setMname("工作计划");
		//Menus23.setChecked(0);
		Menus23.setPid(2);
		Menus23.setIsParent(0);
		
		Menus Menus24 = new Menus();
		Menus24.setMid(24);
		Menus24.setIcon("style/images/MenuIcon/FUNC20056.gif");
		Menus24.setMname("工作日记");
		//Menus24.setChecked(0);
		Menus24.setPid(2);
		Menus24.setIsParent(0);
		
		Menus Menus25 = new Menus();
		Menus25.setMid(25);
		Menus25.setIcon("style/images/MenuIcon/time_date.gif");
		Menus25.setMname("通讯录");
		//Menus25.setChecked(0);
		Menus25.setPid(2);
		Menus25.setIsParent(0);
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		Menus Menus3 = new Menus();
		Menus3.setMid(3);
		///Menus3.setChecked(0);
		Menus3.setIsParent(1);
		Menus3.setPid(1);
		Menus3.setMname("审批流转");
		Menus3.setIcon("style/images/MenuIcon/FUNC20057.gif");
		
		Menus Menus31 = new Menus();
		Menus31.setMid(31);
		//Menus31.setChecked(0);
		Menus31.setIsParent(0);
		Menus31.setPid(3);
		Menus31.setMname("审批流程管理");
		Menus31.setIcon("style/images/MenuIcon/manager.gif");
		
		Menus Menus32 = new Menus();
		Menus32.setMid(32);
		//Menus32.setChecked(0);
		Menus32.setIsParent(0);
		Menus32.setPid(3);
		Menus32.setMname("表单模板管理");
		Menus32.setIcon("style/images/MenuIcon/formmode.gif");
		
		Menus Menus33 = new Menus();
		Menus33.setMid(33);
		Menus33.setIsParent(0);
		//Menus33.setChecked(0);
		Menus33.setPid(3);
		Menus33.setMname("发起申请");
		Menus33.setIcon("style/images/MenuIcon/FUNC241000.gif");
		
		Menus Menus34 = new Menus();
		Menus34.setMid(34);
		Menus34.setIsParent(0);
		//Menus34.setChecked(0);
		Menus34.setPid(3);
		Menus34.setMname("审批申请");
		Menus34.setIcon("style/images/MenuIcon/FUNC20029.gif");
		
		Menus Menus35 = new Menus();
		Menus35.setMid(35);
		Menus35.setIsParent(0);
		//Menus35.setChecked(0);
		Menus35.setPid(3);
		Menus35.setMname("状态查询");
		Menus35.setIcon("style/images/MenuIcon/FUNC20029.gif");
/************************************************************************************/
		/*
		 * 知识管理
		 */
		Menus Menus4 = new Menus();
		Menus4.setMid(4);
		Menus4.setIsParent(0);
		//Menus4.setChecked(0);
		Menus4.setPid(1);
		Menus4.setMname("知识管理");
		Menus4.setIcon("style/images/MenuIcon/FUNC20056.gif");
/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Menus Menus5 = new Menus();
		Menus5.setMid(5);
		Menus5.setIsParent(1);
		//Menus5.setChecked(0);
		Menus5.setPid(1);
		Menus5.setMname("管理行政");
		Menus5.setIcon("style/images/MenuIcon/manager.gif");
		
		Menus Menus51 = new Menus();
		Menus51.setMid(51);
		Menus51.setIsParent(0);
		//Menus51.setChecked(0);
		Menus51.setPid(5);
		Menus51.setMname("考勤管理");
		Menus51.setIcon("style/images/MenuIcon/FUNC20070.gif");
		
		Menus Menus52 = new Menus();
		Menus52.setMid(52);
		Menus52.setIsParent(0);
		//Menus52.setChecked(0);
		Menus52.setPid(5);
		Menus52.setMname("会议管理");
		Menus52.setIcon("style/images/MenuIcon/FUNC20064.gif");
		
		Menus Menus53 = new Menus();
		Menus53.setMid(53);
		Menus53.setIsParent(0);
		//Menus53.setChecked(0);
		Menus53.setPid(5);
		Menus53.setMname("车辆管理");
		Menus53.setIcon("style/images/MenuIcon/radio_bue.gif");
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		Menus Menus6 = new Menus();
		Menus6.setMid(6);
		Menus6.setIsParent(1);
		//Menus6.setChecked(0);
		Menus6.setPid(1);
		Menus6.setMname("人力资源");
		Menus6.setIcon("style/images/MenuIcon/FUNC20001.gif");
		
		Menus Menus61 = new Menus();
		Menus61.setMid(61);
		Menus61.setIsParent(0);
		//Menus61.setChecked(0);
		Menus61.setPid(6);
		Menus61.setMname("档案管理");
		Menus61.setIcon("style/images/MenuIcon/FUNC20076.gif");
		
		Menus Menus62 = new Menus();
		Menus62.setMid(62);
		Menus62.setIsParent(0);
		//Menus62.setChecked(0);
		Menus62.setPid(6);
		Menus62.setMname("培训记录");
		Menus62.setIcon("style/images/MenuIcon/FUNC55000.gif");
		
		Menus Menus63 = new Menus();
		Menus63.setMid(63);
		Menus63.setIsParent(0);
		//Menus63.setChecked(0);
		Menus63.setPid(6);
		Menus63.setMname("奖赏记录");
		Menus63.setIcon("style/images/MenuIcon/FUNC55000.gif");
		
		Menus Menus64 = new Menus();
		Menus64.setMid(64);
		Menus64.setIsParent(0);
		//Menus64.setChecked(0);
		Menus64.setPid(6);
		Menus64.setMname("职位变更");
		Menus64.setIcon("style/images/MenuIcon/FUNC55000.gif");
		
		Menus Menus65 = new Menus();
		Menus65.setMid(65);
		Menus65.setIsParent(0);
		//Menus65.setChecked(0);
		Menus65.setPid(6);
		Menus65.setMname("人事合同");
		Menus65.setIcon("style/images/MenuIcon/FUNC55000.gif");
		
		Menus Menus66 = new Menus();
		Menus66.setMid(66);
		Menus66.setIsParent(0);
		//Menus66.setChecked(0);
		Menus66.setPid(6);
		Menus66.setMname("薪酬制度");
		Menus66.setIcon("style/images/MenuIcon/FUNC20001.gif");
/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Menus Menus7 = new Menus();
		Menus7.setMid(7);
		Menus7.setIsParent(0);
		//Menus7.setChecked(0);
		Menus7.setPid(1);
		Menus7.setMname("电子邮件");
		Menus7.setIcon("style/images/MenuIcon/em.gif");

/*******************************************************************/
		/*
		 * 实用工具
		 * 	车票预定
		 * 	GIS查询
		 * 	邮政编码
		 */
		Menus Menus8 = new Menus();
		Menus8.setMid(8);
		Menus8.setIsParent(1);
		//Menus8.setChecked(0);
		Menus8.setPid(1);
		Menus8.setMname("实用工具");
		Menus8.setIcon("style/images/MenuIcon/FUNC20076.gif");
		Menus Menus81 = new Menus();
		Menus81.setMid(81);
		Menus81.setIsParent(0);
		//Menus81.setChecked(0);
		Menus81.setPid(8);
		Menus81.setMname("车票预定");
		Menus81.setIcon("style/images/MenuIcon/FUNC220000.gif");
		Menus Menus82 = new Menus();
		Menus82.setMid(82);
		Menus82.setIsParent(0);
		//Menus82.setChecked(0);
		Menus82.setPid(8);
		Menus82.setMname("GIS查询");
		Menus82.setIcon("style/images/MenuIcon/search.gif");
		Menus Menus83 = new Menus();
		Menus83.setMid(83);
		Menus83.setIsParent(0);
		//Menus83.setChecked(0);
		Menus83.setPid(8);
		Menus83.setMname("邮政编码");
		Menus83.setIcon("style/images/MenuIcon/FUNC249000.gif");
/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		Menus Menus9 = new Menus();
		Menus9.setMid(9);
		Menus9.setIsParent(1);
		//Menus9.setChecked(0);
		Menus9.setPid(1);
		Menus9.setMname("个人设置");
		Menus9.setIcon("style/images/MenuIcon/FUNC20001.gif");
		Menus Menus91 = new Menus();
		Menus91.setMid(91);
		Menus91.setIsParent(0);
		//Menus91.setChecked(0);
		Menus91.setPid(9);
		Menus91.setMname("个人信息");
		Menus91.setIcon("style/images/MenuIcon/FUNC20001.gif");
		Menus Menus92 = new Menus();
		Menus92.setMid(92);
		Menus92.setIsParent(0);
		//Menus92.setChecked(0);
		Menus92.setPid(9);
		Menus92.setMname("密码修改");
		Menus92.setIcon("style/images/MenuIcon/FUNC241000.gif");
/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		Menus Menus10 = new Menus();
		Menus10.setMid(10);
		Menus10.setIsParent(1);
		//Menus10.setChecked(0);
		Menus10.setPid(1);
		Menus10.setMname("系统管理");
		Menus10.setIcon("style/images/MenuIcon/system.gif");
		Menus Menus101 = new Menus();
		Menus101.setMid(101);
		Menus101.setIsParent(0);
		//Menus101.setChecked(0);
		Menus101.setPid(10);
		Menus101.setMname("岗位管理");
		Menus101.setIcon("style/images/MenuIcon/FUNC20001.gif");
		Menus Menus102 = new Menus();
		Menus102.setMid(102);
		Menus102.setIsParent(0);
		//Menus102.setChecked(0);
		Menus102.setPid(10);
		Menus102.setMname("部门管理");
		Menus102.setIcon("style/images/MenuIcon/department.gif");
		Menus Menus103 = new Menus();
		Menus103.setMid(103);
		Menus103.setIsParent(0);
		//Menus103.setChecked(0);
		Menus103.setPid(10);
		Menus103.setMname("用户管理");
		Menus103.setIcon("style/images/MenuIcon/FUNC20001.gif");
/**********************************************************************/
		/* * {
		 * 	1,1
		 * 	2,5
		 * 	3,5
		 * 	4,1
		 * 	5,3
		 * 	6,6
		 * 	7,1
		 * 	8,3
		 * 	9,2
		 * 	10,3
		 * }*/

		session.save(Menusitem1);
		
		session.save(Menus2);
		session.save(Menus21);
		session.save(Menus22);
		session.save(Menus23);
		session.save(Menus24);
		session.save(Menus25);
		
		
		session.save(Menus3);
		session.save(Menus31);
		session.save(Menus32);
		session.save(Menus33);
		session.save(Menus34);
		session.save(Menus35);
		
		session.save(Menus4);
		
		session.save(Menus5);
		session.save(Menus51);
		session.save(Menus52);
		session.save(Menus53);
		
		session.save(Menus6);
		
		session.save(Menus61);
		session.save(Menus62);
		session.save(Menus63);
		session.save(Menus64);
		session.save(Menus65);
		session.save(Menus66);
		
		session.save(Menus7);
		
		session.save(Menus8);
		session.save(Menus81);
		session.save(Menus82);
		session.save(Menus83);
		
		session.save(Menus9);
		session.save(Menus91);
		session.save(Menus92);
		
		session.save(Menus10);
		session.save(Menus101);
		session.save(Menus102);
		session.save(Menus103);
		transaction.commit();
		session.close();
	}
}
