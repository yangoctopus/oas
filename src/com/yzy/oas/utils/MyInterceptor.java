package com.yzy.oas.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}
	/**
	 * 完成对象Action类中处理请求的方法进行拦截
	 * ***/
	@Override
	public String intercept(ActionInvocation ai)
			throws Exception {
		Map<String,Object> session=ai.getInvocationContext().getSession();
		
		//获得用户发送请求的路径
		String path=ServletActionContext.getRequest().getServletPath();
		//不需要判断用户是否登录，就可以访问的资源
		List<String> url=new ArrayList<String>();
		url.add("/userAction_userLogin.action");
		
		
		if(url.contains(path)){
			//放行
			return ai.invoke();
		}
		
		//获得session中保存的用户信息
		Object uvo=session.get("user");
		if(uvo!=null){
			//放行
			return ai.invoke();
		}
		
		return "login";
	}

}
