package com.yzy.oas.dao.impl;

import java.util.List;

import com.yzy.oas.dao.DeptDao;
import com.yzy.oas.pojo.Dept;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDaoImpl extends BaseDao implements DeptDao {

	@Override
	public List<Dept> loadDeptList() {
		// TODO Auto-generated method stub
		
		List<Dept> list=(List<Dept>) super.getHibernateTemplate().find("from Dept"); 
		
		return list;
	}

    @Override
    public void saveDept(Dept dept) {
        super.getHibernateTemplate().save(dept);
    }

    @Override
    public Dept loadSingleDept(Dept dept) {
        return super.getHibernateTemplate().get(Dept.class,dept.getDid());
    }

    @Override
    public void updateDept(Dept dept) {
	    super.getHibernateTemplate().update(dept);

    }

    @Override
    public void delDept(Dept dept) {
	    super.getHibernateTemplate().delete(dept);

    }

}
