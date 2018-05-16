package com.yzy.oas.dao.impl;

import java.util.List;

import com.yzy.oas.dao.UserDao;
import com.yzy.oas.pojo.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(user);
	}

	@Override
	public List<User> loadUserList() {
		// TODO Auto-generated method stub
		String hql="select new User(u.uid,u.username,u.phone,p.dname,up.pname) "
				+ " from User u left join u.dept p inner join u.psts up"
				+ " order by u.uid ";
		return (List<User>) super.getHibernateTemplate().find(hql);
	}

    @Override
    public void delUser(User user) {
        this.getHibernateTemplate().delete(user);
    }

    @Override
    public User findSingleUser(Integer uid) {
        return super.getHibernateTemplate().get(User.class,uid);
    }

    @Override
    public void updateUser(User user) {
        super.getHibernateTemplate().update(user);
    }

    @Override
    public List<User> loadUserByUname(String username) {
        String hql="from User u where u.username=?";
        return (List<User>) super.getHibernateTemplate().find(hql,username);
    }

}
