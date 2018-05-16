package com.yzy.oas.vo;

import com.yzy.oas.pojo.User;

public class UserVo extends User{
    //接受部门的id
    private Integer did;

    //接受到客户端提交的岗位的id的集合
    private Integer[] pid;

    //响应用户对应的所有岗位的名字
    private String pnames;


    public Integer[] getPid() {
        return pid;
    }

    public void setPid(Integer[] pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getPnames() {
        return pnames;
    }

    public void setPnames(String pnames) {
        this.pnames = pnames;
    }

}
