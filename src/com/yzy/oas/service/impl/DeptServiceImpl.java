package com.yzy.oas.service.impl;

import com.yzy.oas.dao.DeptDao;
import com.yzy.oas.pojo.Dept;
import com.yzy.oas.service.DeptService;
import com.yzy.oas.vo.DeptVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public List<DeptVo> loadDeptList() {
        List<Dept> dlist = deptDao.loadDeptList();
        List<DeptVo> dvolist=new ArrayList<>();
        for(Dept dept:dlist){
            DeptVo deptVo=new DeptVo();
            BeanUtils.copyProperties(dept,deptVo);
            dvolist.add(deptVo);
        }
        return dvolist;
    }

    @Override
    public void saveDept(DeptVo deptVo) {
        Dept dept=new Dept();
        BeanUtils.copyProperties(deptVo,dept);
        deptDao.saveDept(dept);

    }

    @Override
    public Dept loadSingleDept(DeptVo deptVo) {
        Dept dept=new Dept();
        BeanUtils.copyProperties(deptVo,dept);
        return  deptDao.loadSingleDept(dept);
    }

    @Override
    public void updateDept(DeptVo deptVo) {
        Dept dept=new Dept();
        BeanUtils.copyProperties(deptVo,dept);
        deptDao.updateDept(dept);
    }

    @Override
    public void delDept(DeptVo deptVo) {
        Dept dept=new Dept();
        BeanUtils.copyProperties(deptVo,dept);
        deptDao.delDept(dept);
    }
}
