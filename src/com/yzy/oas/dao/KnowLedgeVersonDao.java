package com.yzy.oas.dao;

import com.yzy.oas.pojo.KnowLedgeVersion;
import com.yzy.oas.vo.KnowLedgeVersionVo;

import java.util.List;


public interface KnowLedgeVersonDao {
	
	/**
	 * 查询某个节点，对应的知识版本列表
	 * **/
	public List<KnowLedgeVersion>
		loadKnowLedgeVersonDao(Integer ktid);

    void saveKversion(KnowLedgeVersion kv);

    Integer loadMaxVersion(Integer ktid);
    public KnowLedgeVersion loadKnowLedgeVersion(Integer kvid);

    void delKversion(KnowLedgeVersion kv);

    void delKverByKtid(Integer ktid);
}
