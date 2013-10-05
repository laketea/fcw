package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-01-06 20:57:02
 */
public class InforChannel
	implements Serializable
{
	
	private Integer id;  //id

	private String name;  //分类名称

	private Integer channelCount;  //子频道数量

	private Integer sortNum;  //排列序号

	private Integer parentId;  //父频道ID

	private String createTime;  //创建时间

	private Integer status;  //状态
	
	private InforChannel parentChannel;

	private List<InforChannel> cc;
	
	private List<Information> informations;
	
	private List<InforChannel> childChannels;
	


	public InforChannel(){
		
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

	public InforChannel getParentChannel() {
		return parentChannel;
	}

	public void setParentChannel(InforChannel parentChannel) {
		this.parentChannel = parentChannel;
	}

	public List<InforChannel> getChildChannels() {
		return childChannels;
	}

	public void setChildChannels(List<InforChannel> childChannels) {
		this.childChannels = childChannels;
	}

	public List<Information> getInformations() {
		return informations;
	}

	public void setInformations(List<Information> informations) {
		this.informations = informations;
	}
	
	
	
	


	
}