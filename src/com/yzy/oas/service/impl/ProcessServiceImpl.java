package com.yzy.oas.service.impl;

import com.yzy.oas.service.ProcessService;
import com.yzy.oas.vo.LeaveVo;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService histroyService;
    /*查询流程列表*/
    @Override
    public List<ProcessDefinition> loadProcessList() {
        return repositoryService.createProcessDefinitionQuery().latestVersion().list();
    }

    /*部署流程*/
    @Override
    public void saveProcessDefine(ZipInputStream zip) {
        repositoryService.createDeployment().name("请假流程").addZipInputStream(zip).deploy();

    }

    @Override
    public void saveProcessInstance(LeaveVo lvo) {
        // TODO Auto-generated method stub
        String processDefinitionId=lvo.getPdid();

        //获得审批人的数组
        String[] apper=lvo.getApper();

        //创建Map对象,任务变量，保存的是任务执行
        Map<String,Object> variables=new HashMap<String,Object>();
        variables.put("apper",lvo.getUsername()); //申请者
        variables.put("teamer", apper[0]);
        variables.put("manager", apper[1]);


        ProcessInstance pi=
                runtimeService.startProcessInstanceById(processDefinitionId,
                        variables);

        //获得流程实例id
        String processInstanceId=pi.getId();

        //查询当前流程实例，管理的流程任务
        List<Task> task=taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(lvo.getUsername())
                .list();
        //完成申请者的任务，当前登录用户的任务，发起请假申请

        //获得任务ID
        String taskId=task.get(0).getId();



        //设置任务变量
        taskService.setVariable(taskId, "请假开始日期", lvo.getStart());
        taskService.setVariable(taskId, "请假结束日期", lvo.getEnd());
        taskService.setVariable(taskId, "请假原因", lvo.getDesces());


        taskService.complete(taskId);



    }

}
