package com.yzy.oas.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware {

    protected Map<String,Object> req;
    protected Map<String,Object> ses;
    protected Map<String,Object> app;

    @Override
    public void setApplication(Map<String, Object> map) {
                this.app=map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
            this.req=map;
    }

    @Override
    public void setSession(Map<String, Object> map) {
            this.ses=map;
    }

    /**
     * 调用值栈对象的set方法
     */
    public void setVs(String key,Object obj){
        ActionContext.getContext().getValueStack().set(key, obj);
    }

    /**
     * 调用值栈的push方法
     * @param obj
     */
    public void pushVs(Object obj){
        ActionContext.getContext().getValueStack().push(obj);
    }
}
