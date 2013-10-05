package com.fcw.action.blog;

import java.util.List;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Article;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Friend;
import com.fcw.service.ArtCatalogManager;
import com.fcw.service.ArticleManager;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.FriendManager;

public class ArtAction extends BaseFrontAction {
	
	protected ArticleManager mgr;
	
	protected ArtCatalogManager cmgr;
	
	protected BlogInfoManager bmgr;
	
	private List cataList;
	
	private Page page;
	
	private Integer id;
	
	private Integer aid;
	
	private Integer cataId;
	
	private BlogInfo blog;
	
	private Article art;
	
	public void setArtCatalogManager(ArtCatalogManager mgr) {
		this.cmgr = mgr;
	}
	
	public void setArticleManager(ArticleManager mgr) {
		this.mgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	
	public String index(){
		
		cataList = cmgr.findByBlog(id);
		blog = bmgr.get(id);
		Article art = new Article();
		
		fetchPageNum();
		art.setBlogId(id);
		art.setCatalogId(cataId==null?0:cataId);
		
		page = mgr.findByPage(art, pageNum, perNum);
		
		return "index";
		
	}
	
	public String show(){
		
		
		art = mgr.get(id);
		blog = bmgr.get(art.getBlogId());
		art.setView_count(art.getView_count()+1);
		mgr.update(art);
		
		return "show";
	}
	
	

	
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public BlogInfo getBlog() {
		return blog;
	}

	public void setBlog(BlogInfo blog) {
		this.blog = blog;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}

	public List getCataList() {
		return cataList;
	}

	public void setCataList(List cataList) {
		this.cataList = cataList;
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

	public Integer getCataId() {
		return cataId;
	}

	public void setCataId(Integer cataId) {
		this.cataId = cataId;
	}
	
	
	
	
	
	
	
	
	

}
