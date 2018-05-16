package com.yzy.oas.service;

import com.yzy.oas.vo.LeaveVo;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;
import java.util.zip.ZipInputStream;

public interface ProcessService {

    /**
     * 查询流程列表
     * **/
    public List<ProcessDefinition> loadProcessList();
    /***
     * 部署流程
     * **/
    public void saveProcessDefine(ZipInputStream zip);


    /**
     * 发起申请
     * **/
    public void saveProcessInstance(LeaveVo lvo);


}
