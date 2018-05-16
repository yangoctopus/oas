package com.yzy.oas.service;

import com.yzy.oas.vo.KnowLedgeTreeVo;

import java.util.List;


public interface KnowLedgeTreeService {
	
	/**
	 * 加载所有知识节点
	 * **/
	public List<KnowLedgeTreeVo> loadKnowLedgeTreeListService();

	/**
	 * 添加知识节点
	 * **/
	public void addKnowLedgeTreeService(KnowLedgeTreeVo ktvo);
	
	/**
	 * 删除知识节点
	 * **/
	public void deleteKnowLedgeTreeService(KnowLedgeTreeVo ktvo);

}
