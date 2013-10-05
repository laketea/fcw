package com.fcw.action.front;

import java.util.ArrayList;
import java.util.List;

import com.fcw.common.ActionMsg;
import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.domain.Adv;
import com.fcw.domain.News;
import com.fcw.domain.NewsChannel;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.service.AdvManager;
import com.fcw.service.NewsChannelManager;
import com.fcw.service.NewsManager;
import com.fcw.service.SlideManager;
import com.fcw.service.UserInfoManager;
import com.fcw.service.UsersManager;

public class NewsAction extends BaseFrontAction {

	protected SlideManager slidemgr;
	
	protected NewsManager mgr;

	protected NewsChannelManager channelmgr;
	
	protected AdvManager advmgr;

	private News news;

	private NewsChannel channel;

	private List channelLst;

	private List newsLst;
	
	private List topRwLst;
	
	private News dctopNews;
	
	private List dcTop2Lst;
	
	private List dcLastLst;
	
	private List hotLst;
	
	private List hdbbLst;
	
	private News jltopNews;
	
	private List jlLastLst;
	
	private News yjtopNews;
	
	private List yjLastLst;
	
	private List photoNewsLst;
	
	private List shxkNewsLst;
	
	private Adv topAdv;
	
	private List slideLst;
	
	public void setSlideManager(SlideManager mgr) {
		this.slidemgr = mgr;
	}

	public void setNewsManager(NewsManager mgr) {
		this.mgr = mgr;
	}

	public void setNewsChannelManager(NewsChannelManager mgr) {
		this.channelmgr = mgr;
	}
	
	public void setAdvManager(AdvManager mgr){
		this.advmgr = mgr;
	}
	
	

	public String index() {
		//首页幻灯片
		slideLst =slidemgr.findSlideByTypeId(2, 5);
		
		channelLst =channelmgr.getDefaultChannelLst();
		newsLst = mgr.findTopNews(20);
		//软文
		topRwLst = mgr.findTopNewsByChannelId(WebSite.NEWS_RWLJ, 8);
		
		//地产新闻头条
		List tmpLst = mgr.findDftTopNews(1, WebSite.NEWS_DCXW);
		dctopNews =Utils.listNull(tmpLst)?null:(News)tmpLst.get(0);
		dcTop2Lst = mgr.findDftTop2News(4, WebSite.NEWS_DCXW);//地产头条2
		dcLastLst = mgr.findTopNewsByChannelId(WebSite.NEWS_DCXW,9);//地产最新
		
		//热点排行
		hotLst = mgr.findHotNews(11, 0);
		hdbbLst= mgr.findTopNewsByChannelId2(WebSite.NEWS_HDBB, 9);
		List tmpjlLst = mgr.findDftTopNews(1, WebSite.NEWS_JLHD);
		jltopNews =Utils.listNull(tmpjlLst)?null:(News)tmpjlLst.get(0);
		jlLastLst = mgr.findTopNewsByChannelId2(WebSite.NEWS_JLHD,9);//
		
		//业界
		List tmpyjLst = mgr.findDftTopNews(1, WebSite.NEWS_YJKD);
		yjtopNews =Utils.listNull(tmpyjLst)?null:(News)tmpyjLst.get(0);
		yjLastLst = mgr.findTopNewsByChannelId2(WebSite.NEWS_YJKD,9);//
		photoNewsLst = mgr.findPhotoNews(20, 0);
		shxkNewsLst = mgr.findTopNewsByChannelId(WebSite.NEWS_SHXK,9);//
		
		List lst = advmgr.findAdvByType(2);
		if(!Utils.listNull(lst)){
			topAdv= (Adv)(lst.get(0));
		}
		
		
		
		Utils.listInit(channelLst);
		Utils.listInit(newsLst);
		return "index";
	}
	
	
	
	

	
	
	
	
	public List getSlideLst() {
		return slideLst;
	}

	public void setSlideLst(List slideLst) {
		this.slideLst = slideLst;
	}

	public Adv getTopAdv() {
		return topAdv;
	}

	public void setTopAdv(Adv topAdv) {
		this.topAdv = topAdv;
	}

	public List getShxkNewsLst() {
		return shxkNewsLst;
	}

	public void setShxkNewsLst(List shxkNewsLst) {
		this.shxkNewsLst = shxkNewsLst;
	}

	public List getPhotoNewsLst() {
		return photoNewsLst;
	}

	public void setPhotoNewsLst(List photoNewsLst) {
		this.photoNewsLst = photoNewsLst;
	}

	public News getYjtopNews() {
		return yjtopNews;
	}

	public void setYjtopNews(News yjtopNews) {
		this.yjtopNews = yjtopNews;
	}

	public List getYjLastLst() {
		return yjLastLst;
	}

	public void setYjLastLst(List yjLastLst) {
		this.yjLastLst = yjLastLst;
	}

	public News getDctopNews() {
		return dctopNews;
	}

	public void setDctopNews(News dctopNews) {
		this.dctopNews = dctopNews;
	}

	public List getDcTop2Lst() {
		return dcTop2Lst;
	}

	public void setDcTop2Lst(List dcTop2Lst) {
		this.dcTop2Lst = dcTop2Lst;
	}

	public List getDcLastLst() {
		return dcLastLst;
	}
	
	

	public List getHdbbLst() {
		return hdbbLst;
	}

	public void setHdbbLst(List hdbbLst) {
		this.hdbbLst = hdbbLst;
	}

	public News getJltopNews() {
		return jltopNews;
	}

	public void setJltopNews(News jltopNews) {
		this.jltopNews = jltopNews;
	}

	public List getJlLastLst() {
		return jlLastLst;
	}

	public void setJlLastLst(List jlLastLst) {
		this.jlLastLst = jlLastLst;
	}

	public void setDcLastLst(List dcLastLst) {
		this.dcLastLst = dcLastLst;
	}

	public List getTopRwLst() {
		return topRwLst;
	}

	public void setTopRwLst(List topRwLst) {
		this.topRwLst = topRwLst;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public NewsChannel getChannel() {
		return channel;
	}

	public void setChannel(NewsChannel channel) {
		this.channel = channel;
	}

	public List getChannelLst() {
		return channelLst==null?new ArrayList():channelLst;
	}

	public void setChannelLst(List channelLst) {
		this.channelLst = channelLst;
	}

	public List getNewsLst() {
		return newsLst==null?new ArrayList():newsLst;
	}

	public void setNewsLst(List newsLst) {
		this.newsLst = newsLst;
	}

	public List getHotLst() {
		return hotLst;
	}

	public void setHotLst(List hotLst) {
		this.hotLst = hotLst;
	}
	
	
	
	

}
