package com.fcw.action.front;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.domain.Information;
import com.fcw.domain.News;
import com.fcw.domain.NewsChannel;
import com.fcw.service.CommentManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsChannelManager;
import com.fcw.service.NewsManager;

public class NewsChannelAction extends BaseFrontAction {

	private NewsChannelManager chlmgr;
	
	private InformationManager informgr ;

	private NewsManager mgr;
	
	private CommentManager cmgr;

	private List lastTopNews;
	
	private List hotInforList ;

	private Page page;
	
	private News news;
	
	private String keywords;
	
	private int numPerPage = 25;
	private int totalCount = 0;
	
	private Integer pageNum = 0;
	
	public void setInformationManager(InformationManager mgr) {
		this.informgr = mgr;
	}

	public void setNewsManager(NewsManager mgr) {
		this.mgr = mgr;
	}

	public void setNewsChannelManager(NewsChannelManager mgr) {
		this.chlmgr = mgr;
	}
	
	public void setCommentManager(CommentManager mgr) {
		this.cmgr = mgr;
	}

	private Integer id;

	private NewsChannel channel;

	public String channel() {
		Integer perNum = 15;
		News news = new News();
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		channel = chlmgr.get(id);
		lastTopNews = mgr.findHotNews(10, 0);
		
		news.setChannelId(channel.getId());
		page = mgr.findByPage(news, pageNum, perNum);
		return "channel";
	}
	
	public String search()  {
		
		Integer perNum = 15;
		News news = new News();
		keywords =this.getParameter("keywords");
		try {
			keywords = URLDecoder.decode(keywords,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		news.setTitle(keywords);
		
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		lastTopNews = mgr.findHotNews(10, 0);
		
		page = mgr.findByPage(news, pageNum, perNum);
		return "search";
	}
	
	
	public String show(){
		news = mgr.get(id);
		Integer chlId = news.getChannelId();
		channel = chlmgr.get(chlId);
		lastTopNews = mgr.findHotNews(10, 0);
		hotInforList = informgr.findHotList(10);
		news.setVisitCount(news.getVisitCount()+1);
		mgr.update(news);
		
		
		//评论
		Integer perNum = 15;
		Comment cmt = new Comment();
		cmt.setSourceId(id);
		cmt.setTypeId(1);
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		page = cmgr.findByPage(cmt, pageNum, perNum);
		return "show";
	}
	
	
	
	
	public List getHotInforList() {
		return hotInforList;
	}

	public void setHotInforList(List hotInforList) {
		this.hotInforList = hotInforList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
	
	

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public NewsChannel getChannel() {
		return channel;
	}

	public void setChannel(NewsChannel channel) {
		this.channel = channel;
	}

	public List getLastTopNews() {
		return lastTopNews;
	}

	public void setLastTopNews(List lastTopNews) {
		this.lastTopNews = lastTopNews;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
