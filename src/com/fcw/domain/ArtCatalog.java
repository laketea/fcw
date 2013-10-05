package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-22 00:08:02
 */
public class ArtCatalog
	implements Serializable
{
	
	private Integer id;  //id

	private Integer blogId;  //博客ID

	private String catalogName;  //分类名称

	private String createTime;  //创建时间

	private Integer articles_count;  //文章数量

	private Integer status;  //状态
	
	


	public ArtCatalog(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getArticles_count() {
		return articles_count;
	}

	public void setArticles_count(Integer articles_count) {
		this.articles_count = articles_count;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}