package com.yzy.oas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yzy.oas.dao.KnowLedgeVersonDao;
import com.yzy.oas.pojo.KnowLedgeTree;
import com.yzy.oas.pojo.KnowLedgeVersion;
import com.yzy.oas.service.KnowLedgeVersonService;
import com.yzy.oas.vo.KnowLedgeVersionVo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowLedgeVersonServiceImpl implements KnowLedgeVersonService {

	@Autowired
	private KnowLedgeVersonDao knowLedgeVersonDao;
	@Override
	public List<KnowLedgeVersionVo> loadKnowLedgeVersonService(Integer ktid) {
		// TODO Auto-generated method stub
		List<KnowLedgeVersionVo> kvvoList=new ArrayList<KnowLedgeVersionVo>();
		
		List<KnowLedgeVersion> kvList=knowLedgeVersonDao.loadKnowLedgeVersonDao(ktid);
		
		for(KnowLedgeVersion kv:kvList){
			
			KnowLedgeVersionVo kvvo = new KnowLedgeVersionVo();
			BeanUtils.copyProperties(kv,kvvo);
			
			kvvoList.add(kvvo);
		}
		return kvvoList;
	}

    @Override
    public KnowLedgeVersionVo loadKnowLedgeVersionService(Integer kvid) {
        // TODO Auto-generated method stub
        KnowLedgeVersion kv=knowLedgeVersonDao.loadKnowLedgeVersion(kvid);

        KnowLedgeVersionVo kvvo = new KnowLedgeVersionVo();

        BeanUtils.copyProperties(kv, kvvo);
        return kvvo;
    }

    @Override
    public void delKversion(KnowLedgeVersionVo kvvo) {
	    KnowLedgeVersion kv=new KnowLedgeVersion();
	    BeanUtils.copyProperties(kvvo,kv);
       knowLedgeVersonDao.delKversion(kv);
    }

    @Override
    public synchronized void saveKversion(KnowLedgeVersionVo kvvo) {
        KnowLedgeVersion kver=new KnowLedgeVersion();
        BeanUtils.copyProperties(kvvo, kver);

        //建立知识版本和节点之间的关系
        KnowLedgeTree ktree=new KnowLedgeTree();
        ktree.setKtid(kvvo.getKtid());
        kver.setKtree(ktree);

        Integer maxVersion=knowLedgeVersonDao
                .loadMaxVersion(kvvo.getKtid());
        if(maxVersion==null){
            maxVersion=0;
        }

        kver.setVernum(maxVersion+1);
        kver.setVerdate(DateFormatUtils.format(new Date(),"yyyy-MM-dd"));

        knowLedgeVersonDao.saveKversion(kver);

    }

}
