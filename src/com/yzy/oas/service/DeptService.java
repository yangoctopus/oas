package com.yzy.oas.service;

import com.yzy.oas.pojo.Dept;
import com.yzy.oas.vo.DeptVo;

import java.util.List;

public interface DeptService {
    /***
     * 查询所有部门信息
     * **/
    public List<DeptVo> loadDeptList();

    /*
     * 添加部门
     * */
    public void saveDept(DeptVo deptVo);

    /*查询单个部门
     * */
    public Dept loadSingleDept(DeptVo deptVo);

    /*
     * 修改部门
     * */
    public void updateDept(DeptVo deptVo);

    /*删除部门*/
    public void delDept(DeptVo deptVo);
}
