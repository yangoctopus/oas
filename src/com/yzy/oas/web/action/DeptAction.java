package com.yzy.oas.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.pojo.Dept;
import com.yzy.oas.service.DeptService;
import com.yzy.oas.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class DeptAction extends BaseAction implements ModelDriven<DeptVo>{
    @Autowired
    private DeptService deptService;

    private DeptVo deptVo=new DeptVo();
    @Override
    public DeptVo getModel() {
        return deptVo;
    }

    public String loadDeptList(){
        List<DeptVo> dvolist= deptService.loadDeptList();
        req.put("dvolist",dvolist);
        return "deptList";
    }

    public String addDeptUI(){
        return "deptUI";
    }

    public String addDept(){
        deptService.saveDept(deptVo);
        return "add";
    }

    public String delDept(){
        deptService.delDept(deptVo);
        return "del";
    }

    public String toUpdateDept(){
        Dept dept=deptService.loadSingleDept(deptVo);
        ActionContext.getContext().getValueStack().push(dept);
        return "toUpdateDept";
    }

    public String updateDept(){
        deptService.updateDept(deptVo);
        return NONE;
    }
}
