package com.yzy.oas.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.ProcessService;
import com.yzy.oas.vo.LeaveVo;
import com.yzy.oas.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class LeaveAction 
	extends BaseAction 
	implements ModelDriven<LeaveVo> {

	@Autowired
	private ProcessService processManager;
	
	private LeaveVo lvo = new LeaveVo();
	
	
	@Override
	public LeaveVo getModel() {
		// TODO Auto-generated method stub
		return lvo;
	}
	
	/**
	 * 发起请假流程
	 * **/
	public String saveLeave(){
		
		UserVo uvo=(UserVo) ses.get("user");
		
		lvo.setUsername(uvo.getUsername());
		
		processManager.saveProcessInstance(lvo);
		
		
		return null;
	}

}
