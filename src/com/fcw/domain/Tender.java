package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-01-06 17:02:22
 */
public class Tender
	implements Serializable
{
	
	private Integer id;  //id

	private Integer authorId;  //发布者ID

	private String authorName;  //发布者名称

	private String tenderNum;  //招标编号

	private String name;  //招标项目名称

	private String company;  //招标公司

	private String tenderType;  //招标类别
	
	private String content;

	private String contact;  //联系人

	private String phone;  //联系电话

	private String pbTime;  //发布时间

	private String dffDate;  //有效日期

	private String endTime;  //截至时间

	private Integer winnerId;  //中标用户ID

	private String winnerName;  //中标用户

	private Integer dfRecmd;  //首页推荐

	private Integer dfSortNum;  //首页推荐排序

	private Integer status;  //状态
	
	private Integer viewCount = 0;//浏览次数
	
	private Integer overdue= 0;
	
	private Integer vip = 0;// 是否仅VIP可见


	public Tender(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	public Integer getOverdue() {
		return overdue;
	}

	public void setOverdue(Integer overdue) {
		this.overdue = overdue;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTenderNum() {
		return tenderNum;
	}

	public void setTenderNum(String tenderNum) {
		this.tenderNum = tenderNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPbTime() {
		return pbTime;
	}

	public void setPbTime(String pbTime) {
		this.pbTime = pbTime;
	}

	public String getDffDate() {
		return dffDate;
	}

	public void setDffDate(String dffDate) {
		this.dffDate = dffDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	


	
}