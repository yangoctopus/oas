package com.yzy.oas.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class MainAction extends BaseAction {

    public String loadIndex(){
        return "index";
    }

    public String loadBottom(){
        return "bottom";
    }

    public String loadLeft(){
        return "left";
    }

    public String loadRight(){
        return "right";
    }

    public String loadTop(){
        return "top";
    }

}
