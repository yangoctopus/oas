package com.yzy.oas.web.action;

import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.ProcessService;
import com.yzy.oas.vo.ProcessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

@Controller
@Scope("prototype")
public class ProcessAction extends BaseAction implements ModelDriven<ProcessVo>{
    @Autowired
    private ProcessService processService;
    private ProcessVo processVo=new ProcessVo();

    @Override
    public ProcessVo getModel() {
        return processVo;
    }

    /*处理加载流程定义列表的请求*/
    public String loadProcessList(){
        req.put("plist",processService.loadProcessList());
        return "processList";
    }

    /*处理打开流程部署ui的请求*/

    public String loadDeployUI(){
        return "loadUI";
    }

    /*处理流程部署的请求*/
    public String deployment(){
        try{
            ZipInputStream zip=new ZipInputStream(new FileInputStream(
                    processVo.getZip()
            ));
            processService.saveProcessDefine(zip);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "loadProcess";
    }

    /**
     * 处理加载流程定义列表的请求
     * **/
    public String loadAppUI(){

        req.put("plist",processService.loadProcessList());
        return "appUI";
    }


}
