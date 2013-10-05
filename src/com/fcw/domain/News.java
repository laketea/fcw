package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2012-11-21 22:30:12
 */
public class News
	implements Serializable
{
	
	private Integer id;  //id

	private String title;  //标题
	
	private String simpleTitle;

	private String description;  //描述

	private String content;  //内容

	private String author;  //发布者

	private String pbTime;  //发布时间

	private Integer upCount;  //顶

	private Integer downCount;  //踩

	private Integer visitCount;  //访问量

	private Integer channelId;  //频道ID

	private String channelName;  //频道名称

	private Integer status;  //状态
	
	private Integer dftStatus=0;
	
	private Integer dftNum=0;
	
	private Integer topStatus = 0;
	
	private Integer topNum=0;
	
	private Integer topsStatus =0;//头条2
	
	private Integer topsNum=0;//头条2
	
	private Integer zxTopStatus = 0;//资讯频道 首先显示
	
	private Integer zxTopNum = 0;
	
	private Integer hasPhoto;

	private String photo;
	
	private String url;
	
	private Integer newsSource = 0;
	
	private String siteName ;
	
	private String siteUrl;
	
	private Integer cond = 0;
	
	private Integer fromUrl = 0;

	public News(){
		
	}
	
	
	
	
	
	public Integer getZxTopStatus() {
		return zxTopStatus;
	}





	public Integer getFromUrl() {
		return fromUrl;
	}





	public void setFromUrl(Integer fromUrl) {
		this.fromUrl = fromUrl;
	}





	public void setZxTopStatus(Integer zxTopStatus) {
		this.zxTopStatus = zxTopStatus;
	}





	public Integer getZxTopNum() {
		return zxTopNum;
	}





	public void setZxTopNum(Integer zxTopNum) {
		this.zxTopNum = zxTopNum;
	}





	public Integer getNewsSource() {
		return newsSource;
	}



	public void setNewsSource(Integer newsSource) {
		this.newsSource = newsSource;
	}



	public String getSiteName() {
		return siteName;
	}



	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}



	public String getSiteUrl() {
		return siteUrl;
	}



	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSimpleTitle() {
		return simpleTitle;
	}

	public void setSimpleTitle(String simpleTitle) {
		this.simpleTitle = simpleTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPbTime() {
		return pbTime;
	}

	public void setPbTime(String pbTime) {
		this.pbTime = pbTime;
	}

	public Integer getUpCount() {
		return upCount;
	}

	public void setUpCount(Integer upCount) {
		this.upCount = upCount;
	}

	public Integer getDownCount() {
		return downCount;
	}

	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}

	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDftStatus() {
		return dftStatus;
	}

	public void setDftStatus(Integer dftStatus) {
		this.dftStatus = dftStatus;
	}

	public Integer getDftNum() {
		return dftNum;
	}

	public void setDftNum(Integer dftNum) {
		this.dftNum = dftNum;
	}

	public Integer getTopStatus() {
		return topStatus;
	}

	public void setTopStatus(Integer topStatus) {
		this.topStatus = topStatus;
	}

	public Integer getTopNum() {
		return topNum;
	}

	public void setTopNum(Integer topNum) {
		this.topNum = topNum;
	}

	public Integer getHasPhoto() {
		return hasPhoto;
	}

	public void setHasPhoto(Integer hasPhoto) {
		this.hasPhoto = hasPhoto;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getTopsStatus() {
		return topsStatus;
	}

	public void setTopsStatus(Integer topsStatus) {
		this.topsStatus = topsStatus;
	}

	public Integer getTopsNum() {
		return topsNum;
	}

	public void setTopsNum(Integer topsNum) {
		this.topsNum = topsNum;
	}

	public Integer getCond() {
		return cond;
	}

	public void setCond(Integer cond) {
		this.cond = cond;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	
	
	
	
	
	


	
}