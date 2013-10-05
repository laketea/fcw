package com.fcw.listener;

import com.fcw.service.HotWordsManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.SlideManager;
import com.fcw.service.TenderManager;

public class SysCache {
	
	private SlideManager slidemgr;

	private NewsManager newsmgr;

	private HotWordsManager hotmgr;

	private ResourceChannelManager rchannelmgr;
	
	private ResourceManager resourcemgr;
	
	private TenderManager tendermgr;
	
	private InformationManager informgr;
	
	
	public SysCache(ResourceChannelManager rchannelmgr,ResourceManager resourcemgr,SlideManager slidemgr,NewsManager newsmgr
			,HotWordsManager hotmgr,TenderManager tendermgr,InformationManager informgr
			){
		this.rchannelmgr = rchannelmgr;
		this.resourcemgr = resourcemgr;
		this.slidemgr = slidemgr;
		this.newsmgr = newsmgr;
		this.hotmgr = hotmgr;
		this.informgr = informgr;
		this.tendermgr = tendermgr;
		
		
		
		
		DefaultCache dfCache = DefaultCache.getInstance();
		dfCache.setResourceChannelManager(rchannelmgr);
		dfCache.setResourceManager(resourcemgr);
		dfCache.reflush();
		
		
		
	}
	
	
	

}
