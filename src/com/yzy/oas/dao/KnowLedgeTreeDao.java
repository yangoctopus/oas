package com.yzy.oas.dao;

import com.yzy.oas.pojo.KnowLedgeTree;

import java.util.List;


public interface KnowLedgeTreeDao {
	
	/**
	 * 加载所有知识节点
	 * **/
	public List<KnowLedgeTree> loadKnowLedgeTreeList();
	
	
	/**
	 * 添加知识节点
	 * **/
	public void addKnowLedgeTree(KnowLedgeTree ktree);

	/**
	 * 删除知识节点
	 * **/
	public void deleteKnowLedgeTree(KnowLedgeTree ktree);
	
}
