
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.NewsChannel;
import com.fcw.service.NewsChannelManager;


public class NewsChannelAction extends BaseAction {
	
	protected NewsChannelManager mgr;
	
	public List<NewsChannel> newsChannelLst ;
	
	public NewsChannel newsChannel;
	
	public Integer id;
	
	public String ids;

	public void setNewsChannelManager(NewsChannelManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 新闻频道列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getNewsChannel(),pageNum, getNumPerPage());
		List<NewsChannel> ss =(List<NewsChannel>)page.getList();
		setNewsChannelLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除新闻频道
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加新闻频道
	 */
	public String add(){
		mgr.add(getNewsChannel());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑新闻频道
	 */
	public String edit(){
		 newsChannel = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改新闻频道
	 */
	public String update(){
		NewsChannel adm = mgr.get(getId());
		newsChannel.setId(getId());
		//newsChannel.setCreateDate(newsChannel.getCreateDate());
		mgr.update(newsChannel);
		return ajaxForwardSuccess("修改成功!");
	}
	
	/*
	 * 批量删除
	 */
	public String batch(){
		 mgr.batchDelete(ids);	
		return ajaxForwardSuccess("操作成功!");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public List<NewsChannel> getNewsChannelLst() {
		return newsChannelLst;
	}
	
	


	public void setNewsChannelLst(List<NewsChannel> newsChannelLst) {
		this.newsChannelLst = newsChannelLst;
	}

	public NewsChannel getNewsChannel() {
		return newsChannel;
	}

	public void setNewsChannel(NewsChannel newsChannel) {
		this.newsChannel = newsChannel;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
