package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fcw.common.Utils;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-01-06 13:33:44
 */
public class ResourceChannel
	implements Serializable
{
	
	private Integer id;  //id

	private String name;  //频道名称

	private Integer channelCount = 0;  //子频道数量

	private Integer sortNum = 0;  //排列序号

	private Integer parentId;  //父频道ID

	private String createTime;  //创建时间
	
	private Integer dhstatus;
	
	private Integer dfstatus;
	
	private String dfTitle;
	
	private String dfTitleUrl;
	
	private String dfFirstLine;
	
	private String dfFirstLineUrl;
	
	private String dfSecondLine;
	
	private String dfSecondLineUrl;
	
	private String dfPhoto;
	
	private String dfPhotoUrl;

	private Integer status = 0;  //状态
	
	private Integer sn;
	
	private ResourceChannel parentChannel;

	private List<ResourceChannel> childChannels;
	
	private List<ResourceChannel> dfChildChannels;
	
	private List<Resource> resources;
	
	private List<Resource> dfresource;
	
	private Integer searchCount = 0;

	public ResourceChannel(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	
	
	public String getDfTitleUrl() {
		return dfTitleUrl;
	}

	public void setDfTitleUrl(String dfTitleUrl) {
		this.dfTitleUrl = dfTitleUrl;
	}

	public String getDfFirstLineUrl() {
		return dfFirstLineUrl;
	}

	public void setDfFirstLineUrl(String dfFirstLineUrl) {
		this.dfFirstLineUrl = dfFirstLineUrl;
	}

	public String getDfSecondLineUrl() {
		return dfSecondLineUrl;
	}

	public void setDfSecondLineUrl(String dfSecondLineUrl) {
		this.dfSecondLineUrl = dfSecondLineUrl;
	}

	public String getDfPhotoUrl() {
		return dfPhotoUrl;
	}

	public void setDfPhotoUrl(String dfPhotoUrl) {
		this.dfPhotoUrl = dfPhotoUrl;
	}

	public Integer getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChannelCount() {
		return channelCount;
	}

	public void setChannelCount(Integer channelCount) {
		this.channelCount = channelCount;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

	public String getDfTitle() {
		return dfTitle;
	}

	public void setDfTitle(String dfTitle) {
		this.dfTitle = dfTitle;
	}

	public String getDfFirstLine() {
		return dfFirstLine;
	}

	public void setDfFirstLine(String dfFirstLine) {
		this.dfFirstLine = dfFirstLine;
	}

	public String getDfSecondLine() {
		return dfSecondLine;
	}

	public void setDfSecondLine(String dfSecondLine) {
		this.dfSecondLine = dfSecondLine;
	}

	public String getDfPhoto() {
		return dfPhoto;
	}

	public void setDfPhoto(String dfPhoto) {
		this.dfPhoto = dfPhoto;
	}

	public ResourceChannel getParentChannel() {
		return parentChannel;
	}

	public void setParentChannel(ResourceChannel parentChannel) {
		this.parentChannel = parentChannel;
	}

	public List<ResourceChannel> getChildChannels() {
		return childChannels;
	}

	public void setChildChannels(List<ResourceChannel> childChannels) {
		this.childChannels = childChannels;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Integer getDhstatus() {
		return dhstatus;
	}

	public void setDhstatus(Integer dhstatus) {
		this.dhstatus = dhstatus;
	}

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public Integer getDfstatus() {
		return dfstatus;
	}

	public void setDfstatus(Integer dfstatus) {
		this.dfstatus = dfstatus;
	}

	public List<ResourceChannel> getDfChildChannels() {
		return dfChildChannels;
	}

	public void setDfChildChannels(List<ResourceChannel> dfChildChannels) {
		this.dfChildChannels = dfChildChannels;
	}
	
	public void addChildResource(Resource res){
		if(Utils.listNull(dfresource)){
			dfresource = new ArrayList<Resource>();
		}
		dfresource.add(res);
	}

	public List<Resource> getDfresource() {
		return dfresource;
	}

	public void setDfresource(List<Resource> dfresource) {
		this.dfresource = dfresource;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}