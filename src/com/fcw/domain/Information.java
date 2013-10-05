package com.fcw.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Author zhangwei 
 * @Email  laketea@163.com 
 * @Time   2013-01-06 21:39:43
 */
public class Information
	implements Serializable
{
	
	private Integer id;  //id

	private Integer channelId;  //分类ID

	private String channelName;  //分类名称

	private Integer userId;  //上传者ID

	private String userName;  //上传用户

	private String name;  //资料名称

	private String area;  //地区

	private String year;  //年份

	private String intro;  //简介

	private String filePath;  //文件路径

	private String fileSize;  //文件大小

	private String fileType;  //文件后缀

	private String upTime;  //上传时间

	private Integer vip;  //vip

	private Integer coin;  //资源币

	private Integer gradeCount;  //评价总数

	private Integer score;  //总评分

	private Integer aveScore = 0;  //评分

	private Integer examine = 0;  //是否审核

	private Integer admin;  //是否管理员上传

	private Integer dfRecmd;  //是否推荐  0-否 1-头条推荐 2-首页推荐
	
	private Integer zlDfRecmd = 0;// 资料中心首页推荐
	
	private Integer zlDfNum = 0;// 资料中心首页推荐排序
	
	private Integer pdRecmd = 0;
	
	private Integer pdSortNum = 0;

	private Integer dfSortNum;  //推荐排序
	
	private Integer viewCount = 0;
	
	private String channelIds ;
	
	

	private Integer status;  //状态
	
	private InforChannel inforChannel;
	
	private Integer channel_id;
	
	private Integer downCount = 0;
	
	private UserInfo userInfo;


	public Information(){
		
	}
	
	
	
	public Integer getZlDfRecmd() {
		return zlDfRecmd;
	}



	public void setZlDfRecmd(Integer zlDfRecmd) {
		this.zlDfRecmd = zlDfRecmd;
	}



	public Integer getZlDfNum() {
		return zlDfNum;
	}



	public void setZlDfNum(Integer zlDfNum) {
		this.zlDfNum = zlDfNum;
	}



	public String getChannelIds() {
		return channelIds;
	}



	public void setChannelIds(String channelIds) {
		this.channelIds = channelIds;
	}



	public Integer getViewCount() {
		return viewCount;
	}



	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Integer getPdRecmd() {
		return pdRecmd;
	}

	public void setPdRecmd(Integer pdRecmd) {
		this.pdRecmd = pdRecmd;
	}

	public Integer getPdSortNum() {
		return pdSortNum;
	}

	public void setPdSortNum(Integer pdSortNum) {
		this.pdSortNum = pdSortNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public Integer getGradeCount() {
		return gradeCount;
	}

	public void setGradeCount(Integer gradeCount) {
		this.gradeCount = gradeCount;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	

	public Integer getDownCount() {
		return downCount;
	}

	public void setDownCount(Integer downCount) {
		this.downCount = downCount;
	}

	public Integer getAveScore() {
		return aveScore;
	}

	public void setAveScore(Integer aveScore) {
		this.aveScore = aveScore;
	}

	public Integer getExamine() {
		return examine;
	}

	public void setExamine(Integer examine) {
		this.examine = examine;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
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

	public InforChannel getInforChannel() {
		return inforChannel;
	}

	public void setInforChannel(InforChannel inforChannel) {
		this.inforChannel = inforChannel;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}
	
	
}