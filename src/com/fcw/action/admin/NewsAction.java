package com.fcw.action.admin;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.News;
import com.fcw.domain.NewsChannel;
import com.fcw.service.NewsChannelManager;
import com.fcw.service.NewsManager;

public class NewsAction extends BaseAction {

	protected NewsManager mgr;
	protected NewsChannelManager channelmgr;

	public List<News> newsLst;

	public List<NewsChannel> channelLst;

	public News news = new News();

	public Integer id;

	public Integer chlId = 0;

	public String operType = "";

	public String ids;

	public void setNewsManager(NewsManager mgr) {
		this.mgr = mgr;
	}

	public void setNewsChannelManager(NewsChannelManager mgr) {
		this.channelmgr = mgr;
	}

	/*
	 * 新闻列表
	 */
	public String list() {
		baseList();
		return "list";
	}

	// 地产新闻
	public String dcxwlist() {
		getNews().setChannelId(WebSite.NEWS_DCXW);
		baseList();
		return "dcxwlist";
	}

	// 软文链接
	public String rwljlist() {
		getNews().setChannelId(WebSite.NEWS_RWLJ);
		baseList();
		return "rwljlist";
	}

	// 业界快递
	public String yjkdlist() {
		getNews().setChannelId(WebSite.NEWS_YJKD);
		baseList();
		return "yjkdlist";
	}

	// 交流互动
	public String jlhdlist() {
		getNews().setChannelId(WebSite.NEWS_JLHD);
		baseList();
		return "jlhdlist";
	}

	// 生活闲侃
	public String shxklist() {
		getNews().setChannelId(WebSite.NEWS_SHXK);
		baseList();
		return "shxklist";
	}

	// 图文新闻
	public String photolist() {
		getNews().setHasPhoto(1);
		baseList();
		return "photolist";
	}

	// 活动播报
	public String hdbblist() {
		getNews().setChannelId(WebSite.NEWS_HDBB);
		baseList();
		return "hdbblist";
	}

	public void baseList() {
		int pageNum = this.getPageNum() >= 1 ? this.getPageNum() : 1;
		Page page = mgr.findByPage(getNews(), pageNum, getNumPerPage());
		List<News> ss = (List<News>) page.getList();
		setNewsLst(ss);
		this.setTotalCount(page.getTotalRecords());
	}

	/*
	 * 删除新闻
	 */
	public String delete() {
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}

	/*
	 * 添加新闻
	 */
	public String add() {
		implChannelId();
		channelLst = channelmgr.findAll();
		return "add" + operType;
	}

	private void implChannelId() {
		switch (chlId) {
		case 1:
			chlId = WebSite.NEWS_DCXW;
			break;
		case 2:
			chlId = WebSite.NEWS_YJKD;
			break;
		case 3:
			chlId = WebSite.NEWS_RWLJ;
			break;
		case 4:
			chlId = WebSite.NEWS_JLHD;
			break;
		case 5:
			chlId = WebSite.NEWS_SHXK;
			break;
		case 6:
			chlId = WebSite.NEWS_HDBB;
			break;
		}

	}

	/*
	 * 保存新闻
	 */
	public String save() {
		NewsChannel channel = channelmgr.get(news.getChannelId());
		news.setChannelName(channel.getName());
		mgr.add(news);
		return ajaxForwardSuccess("操作成功!");
	}

	/*
	 * 编辑新闻
	 */
	public String edit() {
		channelLst = channelmgr.findAll();
		news = mgr.get(getId());
		if("4".equals(operType)){// 如果是交流互动等特殊板块
			if(news.getFromUrl()==null||news.getFromUrl()==0){
				operType = "";
			}else{
				operType = "3";
			}
		}
		return "edit" + operType;
	}

	/*
	 * 修改新闻
	 */
	public String update() {
		news.setId(getId());
		NewsChannel channel = channelmgr.get(news.getChannelId());
		news.setChannelName(channel.getName());
		mgr.update(news);
		return ajaxForwardSuccess("修改成功!");
	}

	/*
	 * 批量删除
	 */
	public String batch() {
		mgr.batchDelete(ids);
		return ajaxForwardSuccess("操作成功!");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<News> getNewsLst() {
		return newsLst;
	}

	public void setNewsLst(List<News> newsLst) {
		this.newsLst = newsLst;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<NewsChannel> getChannelLst() {
		return channelLst;
	}

	public void setChannelLst(List<NewsChannel> channelLst) {
		this.channelLst = channelLst;
	}

	public Integer getChlId() {
		return chlId;
	}

	public void setChlId(Integer chlId) {
		this.chlId = chlId;
	}

}
