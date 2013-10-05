package com.fcw.action.admin;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.WebCfg;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.DownLoad;
import com.fcw.service.DownLoadManager;


public class WebCfgAction extends BaseAction {
	
	private WebCfg[] cfgLst;	

	
	public String show(){
		cfgLst = WebCfg.CFGLST;
		return "show";	
	}
	
	public String save(){
		for(WebCfg cfg:WebCfg.CFGLST){
			cfg.setValue(getParameter(cfg.getName()));
		}
		return ajaxForwardSuccess("操作成功!");
	}

	public WebCfg[] getCfgLst() {
		return cfgLst;
	}

	public void setCfgLst(WebCfg[] cfgLst) {
		this.cfgLst = cfgLst;
	}
	
	

}