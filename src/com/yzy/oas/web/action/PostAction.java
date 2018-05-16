package com.yzy.oas.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.yzy.oas.pojo.Menus;
import com.yzy.oas.pojo.Post;
import com.yzy.oas.service.PostService;
import com.yzy.oas.vo.MenusVo;
import com.yzy.oas.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class PostAction extends BaseAction implements ModelDriven<PostVo>{

	//注入service对象
	@Autowired
	private PostService postService;
	
	//创建vo对象
	private PostVo pvo = new PostVo();
	
	private InputStream inputStream;
	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	@Override
	public PostVo getModel() {
		// TODO Auto-generated method stub
		return pvo;
	}
	
	/***
	 * 处理岗位列表的查询请求
	 * **/
	public String loadPostList(){
		
		List<PostVo> pvoList=postService.loadPostListService();
		//创建pvoList保存到req中
		req.put("pvoList", pvoList); 
		return "postList"; //跳转到岗位列表页面
		
	}
	
	

	/***
	 * 跳转到添加岗位的视图页面
	 * **/
	public String addPostUI(){
		return "addPost";
	}
	
	/**
	 * 处理岗位信息的添加请求
	 * **/
	public String addPost(){
		postService.savePostService(pvo);
		return NONE;
	}

	/**
	 * 处理更新岗位信息的请求
	 * **/
	public String updatePost(){
		postService.updatePostService(pvo);
		return "loadPostList";
	}
	
	/**
	 * 处理查询某个岗位信息的请求
	 * **/
	public String loadPost(){
		PostVo vo = postService.loadPostService(pvo.getPid());
		//将回显的数据，放入对象栈
		ActionContext.getContext().getValueStack().push(vo);
		
		return "updatePost";
	}
	private List<Menus> pmlist;

    public List<Menus> getPmlist() {
        return pmlist;
    }

    public String loadPostMenus(){
        pmlist=postService.loadPostMenus(pvo);
        return "postMenus";
    }
	/***
	 * 处理角色授权请求
	 * **/
	public String postGrant(){
		try{
			postService.savePostOfMenus(pvo.getPmids());
			this.inputStream=new ByteArrayInputStream("success".getBytes());
		}catch(Exception ex){
			this.inputStream=new ByteArrayInputStream("error".getBytes());
			ex.printStackTrace();
		}
		return "ajaxResp";
	}

	public String delPost(){
        postService.delPost(pvo);
        return "loadPostList";
    }
	
}
