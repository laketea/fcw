package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-04-22 00:38:05
 */
public class Friend
	implements Serializable
{
	
	private Integer id;  //id

	private Integer fromId;  //发送人ID

	private String fromName;  //发送人名称

	private String content;  //内容

	private Integer toId;  //接收人ID

	private Integer toName;  //接收人名称

	private String sendTime;  //发送时间

	private Integer status;  //状态  1---未批准， 2 拒绝， 3---成功
	
	private Integer own;


	public Friend(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public Integer getOwn() {
		return own;
	}

	public void setOwn(Integer own) {
		this.own = own;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Integer getToName() {
		return toName;
	}

	public void setToName(Integer toName) {
		this.toName = toName;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	
}