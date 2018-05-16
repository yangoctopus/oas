package com.yzy.oas.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.KnowLedgeTreeService;
import com.yzy.oas.vo.KnowLedgeTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class KnowLedgeTreeAction 
	extends BaseAction 
	implements ModelDriven<KnowLedgeTreeVo> {
	
	
	@Autowired
	private KnowLedgeTreeService knowLedgeTreeService;

	//响应json数组
	private List<KnowLedgeTreeVo> ktvoList;
	
	
	private KnowLedgeTreeVo ktvo = new KnowLedgeTreeVo();
	
	public List<KnowLedgeTreeVo> getKtvoList() {
		return ktvoList;
	}

	@Override
	public KnowLedgeTreeVo getModel() {
		// TODO Auto-generated method stub
		return ktvo;
	}
	
	/**
	 * 处理加载知识树的请求
	 * **/
	public String loadKnowLedgeTreeList(){
		
		ktvoList=
			knowLedgeTreeService.loadKnowLedgeTreeListService();
		
		return "ktreeList";
	}

	/**
	 * 处理跳转到知识管理视图的请求
	 * **/
	public String loadKtreeUI(){
		return "ktree";
	}
	
	/**
	 * 处理树节点的动态添加请求
	 * **/
	public String addKtree(){
		knowLedgeTreeService.addKnowLedgeTreeService(ktvo);
		
		//将ktvo对象，转化为json的数组，进行相应
		
		this.ktvoList=new ArrayList<>();
		this.ktvoList.add(ktvo);
		
		return "ktreeObj";
	}
	
	/***
	 * 处理知识节点的删除请求
	 * **/
	public String delKtree(){
		knowLedgeTreeService.deleteKnowLedgeTreeService(ktvo);

		return null;
	}
}
