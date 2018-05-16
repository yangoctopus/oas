package com.yzy.oas.dao.impl;

import java.util.List;

import com.yzy.oas.dao.KnowLedgeTreeDao;
import com.yzy.oas.pojo.KnowLedgeTree;
import org.springframework.stereotype.Repository;

@Repository
public class KnowLedgeTreeDaoImpl extends 
	BaseDao implements KnowLedgeTreeDao {

	@Override
	public List<KnowLedgeTree> loadKnowLedgeTreeList() {
		// TODO Auto-generated method stub
		
		return (List<KnowLedgeTree>) 
				super.getHibernateTemplate()
				.find("from KnowLedgeTree");
	}

	@Override
	public void addKnowLedgeTree(KnowLedgeTree ktree) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(ktree);
		
	}

	@Override
	public void deleteKnowLedgeTree(KnowLedgeTree ktree) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().delete(ktree);
		
	}

}
