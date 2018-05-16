package com.yzy.oas.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yzy.oas.dao.KnowLedgeTreeDao;
import com.yzy.oas.dao.KnowLedgeVersonDao;
import com.yzy.oas.pojo.KnowLedgeTree;
import com.yzy.oas.pojo.KnowLedgeVersion;
import com.yzy.oas.service.KnowLedgeTreeService;
import com.yzy.oas.vo.KnowLedgeTreeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowLedgeTreeServiceImpl implements KnowLedgeTreeService {

	@Autowired
	private KnowLedgeTreeDao knowLedgeTreeDao;
	@Autowired
    private KnowLedgeVersonDao knowLedgeVersonDao;
	@Override
	public List<KnowLedgeTreeVo> loadKnowLedgeTreeListService() {
		// TODO Auto-generated method stub
		
		List<KnowLedgeTree> ktList
			= knowLedgeTreeDao.loadKnowLedgeTreeList();
		
		List<KnowLedgeTreeVo> ktvoList=new ArrayList<KnowLedgeTreeVo>();
		
		for(KnowLedgeTree kt:ktList){
			//创建Vo对象
			KnowLedgeTreeVo ktvo=new KnowLedgeTreeVo();
			BeanUtils.copyProperties(kt, ktvo);
			
			ktvoList.add(ktvo);
		}
		
		return ktvoList;
	}
	@Override
	public void addKnowLedgeTreeService(KnowLedgeTreeVo ktvo) {
		
		KnowLedgeTree ktree=new KnowLedgeTree();
		BeanUtils.copyProperties(ktvo, ktree);
		// TODO Auto-generated method stub
		knowLedgeTreeDao.addKnowLedgeTree(ktree);
		
		//将持久态对象的ktid，封装到ktvo对象
		ktvo.setKtid(ktree.getKtid());
	}
	@Override
	public void deleteKnowLedgeTreeService(KnowLedgeTreeVo ktvo) {
		// TODO Auto-generated method stub
        List<KnowLedgeVersion> list=knowLedgeVersonDao.loadKnowLedgeVersonDao(ktvo.getKtid());
        if(list.size()>0){
            knowLedgeVersonDao.delKverByKtid(ktvo.getKtid());
        }

		KnowLedgeTree ktree=new KnowLedgeTree();
		ktree.setKtid(ktvo.getKtid());
		
		knowLedgeTreeDao.deleteKnowLedgeTree(ktree);
	}

}
