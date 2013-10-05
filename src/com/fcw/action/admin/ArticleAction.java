
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Article;
import com.fcw.service.ArticleManager;


public class ArticleAction extends BaseAction {
	
	protected ArticleManager mgr;
	
	public List<Article> articleLst ;
	
	public Article article;
	
	public Integer id;
	
	public String ids;

	public void setArticleManager(ArticleManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 文章列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getArticle(),pageNum, getNumPerPage());
		List<Article> ss =(List<Article>)page.getList();
		setArticleLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除文章
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加文章
	 */
	public String add(){
		mgr.add(getArticle());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑文章
	 */
	public String edit(){
		 article = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改文章
	 */
	public String update(){
		Article adm = mgr.get(getId());
		article.setId(getId());
		//article.setCreateDate(article.getCreateDate());
		mgr.update(article);
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


	public List<Article> getArticleLst() {
		return articleLst;
	}
	
	


	public void setArticleLst(List<Article> articleLst) {
		this.articleLst = articleLst;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
