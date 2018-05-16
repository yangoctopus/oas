package com.yzy.oas.service;

import com.yzy.oas.vo.KnowLedgeVersionVo;

import java.util.List;


public interface KnowLedgeVersonService {
	
	/**
	 * 查询某个节点，对应的知识版本列表
	 * **/
	public List<KnowLedgeVersionVo>
		loadKnowLedgeVersonService(Integer ktid);

    void saveKversion(KnowLedgeVersionVo kvvo);
    /***
     * 查询某个版本信息
     * **/
    public KnowLedgeVersionVo
    loadKnowLedgeVersionService(Integer kvid);

    void delKversion(KnowLedgeVersionVo kvvo);
}
