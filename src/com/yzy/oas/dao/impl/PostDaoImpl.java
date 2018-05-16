package com.yzy.oas.dao.impl;

import java.util.List;

import com.yzy.oas.dao.PostDao;

import com.yzy.oas.pojo.Menus;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.vo.PostVo;
import org.springframework.stereotype.Repository;

@Repository
public class PostDaoImpl extends BaseDao implements PostDao {

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(post);
	}

	@Override
	public List<Post> loadPostList() {
		// TODO Auto-generated method stub
		return (List<Post>) super.getHibernateTemplate().find("from Post");
	}

	@Override
	public Post loadPost(Integer pid) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().get(Post.class, pid);
	}

	@Override
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(post);

	}

    @Override
    public List<Menus> loadPostMenus(Post post) {
        String hql="from Menus m inner join m.pts mp where mp.pid=?";

        return (List<Menus>) super.getHibernateTemplate().find(hql,post.getPid());
    }

    @Override
    public void delPost(Post post) {
        super.getHibernateTemplate().delete(post);
    }


}
