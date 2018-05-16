package com.yzy.oas.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.DeptService;
import com.yzy.oas.service.PostService;
import com.yzy.oas.service.UserService;
import com.yzy.oas.vo.DeptVo;
import com.yzy.oas.vo.PostVo;
import com.yzy.oas.vo.UserVo;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<UserVo> {
    @Autowired
            private UserService userService;
    @Autowired
            private DeptService deptService;
    @Autowired
            private PostService postService;
    UserVo userVo=new UserVo();
    @Override
    public UserVo getModel() {
        return userVo;
    }

    public String loadUserList(){
        List<UserVo> uvolist=userService.loadUserList();
        req.put("uvolist",uvolist);
        return "uvolist";
    }

    public String addUserUI(){
        List<DeptVo> dlist=deptService.loadDeptList();
        List<PostVo> plist=postService.loadPostListService();
        req.put("dlist",dlist);
        req.put("plist",plist);
        return "userUI";
    }

    public String saveUser(){
        userService.saveUser(userVo);
        return NONE;
    }

    public String delUser(){
        userService.delUser(userVo);
        return "delUser";
    }

    public String updateUserUI(){
        List<DeptVo> dlist=deptService.loadDeptList();
        List<PostVo> plist=postService.loadPostListService();
        req.put("dlist",dlist);
        req.put("plist",plist);
        UserVo uvo=userService.updateUserUI(userVo.getUid());
        ActionContext.getContext().getValueStack().push(uvo);
        return "updateUserUI";

    }

    public String updateUser(){
        userService.updateUser(userVo);
        return NONE;
    }

    /**
     * 处理用户登录请求
     * **/
    public String userLogin(){
        UserVo vo = userService.loadUserLogin(userVo);
        if(vo!=null){
            ses.put("user",vo);
            return "loadMain";
        }
        return this.LOGIN;
    }
}
