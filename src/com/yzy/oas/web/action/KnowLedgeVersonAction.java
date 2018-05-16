package com.yzy.oas.web.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.yzy.oas.service.KnowLedgeVersonService;
import com.yzy.oas.vo.KnowLedgeVersionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class KnowLedgeVersonAction 
	extends BaseAction 
	implements ModelDriven<KnowLedgeVersionVo> {

	@Autowired
	private KnowLedgeVersonService knowLedgeVersonService;
	
	private List<KnowLedgeVersionVo>  kvvoList;
	
	private KnowLedgeVersionVo kvvo=new KnowLedgeVersionVo();
	@Override
	public KnowLedgeVersionVo getModel() {
		// TODO Auto-generated method stub
		return kvvo;
	}
	
	
	public List<KnowLedgeVersionVo> getKvvoList() {
		return kvvoList;
	}


	/***
	 * 处理加载版本列表的请求
	 * **/
	public String loadKversion(){
		this.kvvoList=knowLedgeVersonService
				.loadKnowLedgeVersonService(kvvo.getKtid());
		
		return "kversList";
	}

    /***
     * 处理查询某个版本的请求
     * **/
    public String loadKnowLedgeVersion(){

        this.kvvoList=new ArrayList<>();

        this.kvvoList.add(knowLedgeVersonService
                .loadKnowLedgeVersionService(kvvo.getKvid()));

        return "kversObj";

    }

	public String saveKversion(){
	    knowLedgeVersonService.saveKversion(kvvo);
	    return NONE;
    }

    public String delKversion(){
        knowLedgeVersonService.delKversion(kvvo);
        return NONE;
    }

}
