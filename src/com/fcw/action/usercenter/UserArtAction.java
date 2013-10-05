package com.fcw.action.usercenter;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Article;
import com.fcw.domain.Record;
import com.fcw.domain.Users;
import com.fcw.service.ArtCatalogManager;
import com.fcw.service.ArticleManager;
import com.fcw.service.BlogInfoManager;

public class UserArtAction extends BaseFrontAction {
	
	protected ArticleManager mgr;
	
	protected ArtCatalogManager cmgr;
	
	private Integer id;
	
	private Page page;
	
	private Article art;
	
	private Integer flag = 0;
	
	public void setArtCatalogManager(ArtCatalogManager mgr) {
		this.cmgr = mgr;
	}
	
	public void setArticleManager(ArticleManager mgr) {
		this.mgr = mgr;
	}
	
	
	public String my(){
		fetchPageNum();
		Object obj =  getSession().getAttribute("user");
		Users user = (Users)obj;
		id = user.getBlogInfo().getId();
		art = new Article();
		art.setBlogId(id);
		
		page = mgr.findByPage(art, pageNum, perNum);
		return "my";
	}
	
	public String others(){
		
		fetchPageNum();
		Object obj =  getSession().getAttribute("user");
		Users user = (Users)obj;
		id = user.getBlogInfo().getId();
		art = new Article();
		
		if(flag == 0){
			page = mgr.findFriendsArtPage(id, pageNum, perNum);
		}else{
			page = mgr.findByPage(art, pageNum, perNum);
		}
		
		return "others";
	}
	
	public String publish(){
		
		
		return "publish";
	}
	
	public String save(){
		
		Object obj =  getSession().getAttribute("user");
		Users user = (Users)obj;
		art.setBlogId(user.getBlogInfo().getId());
		art.setBlogName(user.getBlogInfo().getUserName());
		art.setCatalogName("测试分类");
		mgr.add(art);
		
		return "sucessed";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
	
	
	

}
