package com.yzy.oas.web.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.ProcessService;
import com.yzy.oas.vo.TaskVo;
import com.yzy.oas.vo.UserVo;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller
@Scope("prototype")
public class TaskAction 
	extends BaseAction 
	implements ModelDriven<TaskVo> {

	@Autowired
	private ProcessService processService;
	
	private TaskVo tvo=new TaskVo(); 
	@Override
	public TaskVo getModel() {
		// TODO Auto-generated method stub
		return tvo;
	}
	
	/**
	 * 处理加载待办任务的请求
	 * **//*
	public String loadTaskList(){
		String username=((UserVo)ses.get("user")).getUsername();
		req.put("tlist", processService.loadUserTask(username));
		return "taskList";
	}
	
	*//**
	 * 处理打开任务审批UI的请求
	 * **//*
	public String compTask(){
		Map<String,List<HistoricVariableInstance>>
			map=processService.loadTaskVar(tvo);
		
		req.put("hvList", map.get("hvList"));
		req.put("hvList2", map.get("hvList2"));
		
		
		return "taskComp";
	}
	
	*//**
	 * 处理完成待办任务请求的方法
	 * **//*
	public String finishTask(){
		String username=((UserVo)sin.get("user")).getUsername();
		tvo.setUsername(username);
		processService.saveCompleteTask(tvo);
		
		return "loadTaskList";
	}
*/

}
