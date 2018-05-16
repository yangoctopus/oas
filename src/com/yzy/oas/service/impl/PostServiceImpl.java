package com.yzy.oas.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yzy.oas.dao.MenusDao;
import com.yzy.oas.dao.PostDao;
import com.yzy.oas.pojo.Menus;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.service.PostService;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

	//注入dao对象
	@Autowired
	private PostDao postDao;

	@Override
	public void savePostService(PostVo pvo) {
		// TODO Auto-generated method stub
		
		//创建pojo对象
		Post post = new Post();
		BeanUtils.copyProperties(pvo, post);
		postDao.addPost(post);
	}

	@Override
	public List<PostVo> loadPostListService() {
		// TODO Auto-generated method stub
		//接收到pojo的集合
		List<Post> plist = postDao.loadPostList();
		
		//创建List<PostVo>对象
		List<PostVo> pvoList = new ArrayList<PostVo>();
		
		//将plist 转化 pvoList
		for(Post p:plist){
			//创建vo对象
			PostVo pvo = new PostVo();
			BeanUtils.copyProperties(p, pvo);
			
			pvoList.add(pvo);
		}
		return pvoList;
	}

	@Override
	public PostVo loadPostService(Integer pid) {
		// TODO Auto-generated method stub
		Post post = postDao.loadPost(pid);
		
		PostVo pvo = new PostVo();
		
		BeanUtils.copyProperties(post, pvo);
		
		return pvo;
	}

	@Override
	public void updatePostService(PostVo pvo) {
		// TODO Auto-generated method stub
		//创建pojo对象
		Post post = new Post();
		//将vo转化为pojo
		BeanUtils.copyProperties(pvo, post);
		postDao.updatePost(post);

	}

	@Override
	public void savePostOfMenus(String pmids) {
		//StreamResult
		// TODO Auto-generated method stub
		String[] ids=pmids.split(",");
		
		//获得岗位id
		Integer pid=Integer.parseInt(ids[0]);
		//获得岗位对象:post是一个持久态对象
		Post post=postDao.loadPost(pid);
		
		//删除post原来的资源
		post.getMns().clear();
		
		for(int x=1;x<ids.length;x++){
			//创建Menus对象
			Menus menus=new Menus();
			//建立岗位和资源的关系,中间表添加记录
			menus.setMid(Integer.parseInt(ids[x]));
			post.getMns().add(menus);
		}
		
	}

    @Override
    public List<Menus> loadPostMenus(PostVo pvo) {
	    Post post=new Post();
	    BeanUtils.copyProperties(pvo,post);
        return postDao.loadPostMenus(post);
    }

    @Override
    public void delPost(PostVo pvo) {
	    Post post=new Post();
	    BeanUtils.copyProperties(pvo,post);
        postDao.delPost(post);
    }



}
