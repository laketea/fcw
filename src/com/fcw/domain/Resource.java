package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-01-06 15:29:55
 */
public class Resource
	implements Serializable
{
	
	private Integer id;  //id

	private String name;  //公司名称
	
	private String simpleName;  //公司简称

	private Integer channelId;  //频道ID

	private String area;  //所属地区

	private String industry;  //主营范围

	private String phone;  //公司电话

	private String tax;  //公司传真

	private String email;  //电子邮箱

	private String address;  //公司地址

	private String about;  //公司概括

	private String description;  //公司简介

	private Integer vip = 0;  //VIP

	private Integer dfRecmd = 0;  //首页推荐

	private Integer dfSortNum = 0;  //首页推荐排序

	private Integer channelRecmd = 0;  //频道推荐

	private Integer channelSortNum = 0;  //频道推荐排序

	private String createTime;  //加入时间

	private Integer status = 0;  //状态
	
	private Integer channel_id;  //频道ID
	
	private String inChlId;
	
	private String cnarea;
	
	private String photo;
	
	private String nick;
	
	private String pwd;
	
	private Integer userId;
	
	private Integer blogId;
	
	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	private ResourceChannel resourceChannel;


	public Resource(){
		
	}
	
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCnarea() {
		return cnarea;
	}

	public void setCnarea(String cnarea) {
		this.cnarea = cnarea;
	}

	public String getInChlId() {
		return inChlId;
	}

	public void setInChlId(String inChlId) {
		this.inChlId = inChlId;
	}

	public Resource(Integer channelId){
		this.channelId = channelId;
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

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Integer getDfRecmd() {
		return dfRecmd;
	}

	public void setDfRecmd(Integer dfRecmd) {
		this.dfRecmd = dfRecmd;
	}

	public Integer getDfSortNum() {
		return dfSortNum;
	}

	public void setDfSortNum(Integer dfSortNum) {
		this.dfSortNum = dfSortNum;
	}

	public Integer getChannelRecmd() {
		return channelRecmd;
	}

	public void setChannelRecmd(Integer channelRecmd) {
		this.channelRecmd = channelRecmd;
	}

	public Integer getChannelSortNum() {
		return channelSortNum;
	}

	public void setChannelSortNum(Integer channelSortNum) {
		this.channelSortNum = channelSortNum;
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

	public ResourceChannel getResourceChannel() {
		return resourceChannel;
	}

	public void setResourceChannel(ResourceChannel resourceChannel) {
		this.resourceChannel = resourceChannel;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	
	
	
	


	
}