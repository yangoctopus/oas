package com.yzy.oas.dao.impl;

import java.util.List;

import com.yzy.oas.dao.KnowLedgeVersonDao;
import com.yzy.oas.pojo.KnowLedgeVersion;
import com.yzy.oas.vo.KnowLedgeVersionVo;
import org.springframework.stereotype.Repository;

@Repository
public class KnowLedgeVersonDaoImpl extends BaseDao implements KnowLedgeVersonDao {

	@Override
	public List<KnowLedgeVersion> loadKnowLedgeVersonDao(Integer ktid) {
		// TODO Auto-generated method stub
		return (List<KnowLedgeVersion>) 
				super.getHibernateTemplate()
				.find("from KnowLedgeVersion "
				+ "kv where kv.ktree.ktid=?",ktid);
	}

    @Override
    public void saveKversion(KnowLedgeVersion kv) {
        super.getHibernateTemplate().save(kv);
    }

    @Override
    public Integer loadMaxVersion(Integer ktid) {
        String hql="select max(vernum) from KnowLedgeVersion "
                + " kv where kv.ktree.ktid=?";
        return (Integer) super.getHibernateTemplate()
                .find(hql, ktid).get(0);

    }


    @Override
    public KnowLedgeVersion loadKnowLedgeVersion(Integer kvid) {
        // TODO Auto-generated method stub
        return super.getHibernateTemplate()
                .get(KnowLedgeVersion.class, kvid);
    }

    @Override
    public void delKversion(KnowLedgeVersion kv) {
        super.getHibernateTemplate().delete(kv);
    }

    @Override
    public void delKverByKtid(Integer ktid) {
        super.getHibernateTemplate().delete("from KnowLedgeVersion where ktid=?",ktid);
    }

}
