package com.fcw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.fcw.service.AdminManager;
import com.fcw.service.HotWordsManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.SlideManager;
import com.fcw.service.TenderManager;

public class SysConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("=======================sdfsdf");
		
		ServletContext content = arg0.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(content);
		
		AdminManager adminManager = (AdminManager)ctx.getBean("adminManager");
		
		ResourceChannelManager resourceChannelManager = (ResourceChannelManager)ctx.getBean("resourceChannelManager");
		ResourceManager resourceManager = (ResourceManager)ctx.getBean("resourceManager");
		TenderManager tenderManager = (TenderManager)ctx.getBean("tenderManager");
		SlideManager slidemgr = (SlideManager)ctx.getBean("slideManager");
		NewsManager newsmgr = (NewsManager)ctx.getBean("newsManager");
		HotWordsManager hotmgr = (HotWordsManager)ctx.getBean("hotWordsManager");
		InformationManager infomgr = (InformationManager)ctx.getBean("informationManager");
		InforChannelManager infoChannelmgr = (InforChannelManager)ctx.getBean("inforChannelManager");
//		SlideManager;HotWordsManager,InformationManager
		
//		List lst = newsmgr.findTopNews(10);
//		tenderManager
		DefaultCache dfCache = DefaultCache.getInstance();
		dfCache.setResourceChannelManager(resourceChannelManager);
		dfCache.setResourceManager(resourceManager);
		dfCache.setTenderManager(tenderManager);
		dfCache.setSlideManager(slidemgr);
		dfCache.setNewsManager(newsmgr);
		dfCache.setHotWordsManager(hotmgr);
		dfCache.setInformationManager(infomgr);
		
		dfCache.reflush();
		
		//网页头部缓存
		TopCache topCache = TopCache.getInstance();
		topCache.setResourceChannelManager(resourceChannelManager);
		topCache.setResourceManager(resourceManager);
		topCache.setHotWordsManager(hotmgr);
		topCache.reflush();
		
		ResourceCache resourceCahce = ResourceCache.getInstance();
		resourceCahce.setResourceChannelManager(resourceChannelManager);
		resourceCahce.setResourceManager(resourceManager);
		resourceCahce.reflush();
		
		//资料相关cache
		InforCache infoCahce = InforCache.getInstance();
		infoCahce.setInforChannelManager(infoChannelmgr);
		infoCahce.setInformationManager(infomgr);
		infoCahce.reflush();

	}

}
