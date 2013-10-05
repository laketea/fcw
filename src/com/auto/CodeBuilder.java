package com.auto;

import com.auto.Builder.ActionBuilder;
import com.auto.Builder.Builder;
import com.auto.business.Po;

public class CodeBuilder {
	
	public void userRegBuilder(){
		Po o = new Po("UserInvite","用户注册邀请","domain");
		o.add("Integer", "id", "id");
		o.add("String", "email", "邮箱");
		o.add("String", "code", "验证码");
		o.add("String", "memeberType", "会员类型");
		o.add("String", "admin", "邀请发送者类型");
		o.add("String", "userId", "发送人id");
		o.add("String", "userName", "发送人name");
		o.add("String", "inviteTime", "发送时间");
		
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		
	}
	
	public void userInfoBuilder(){
		Po o = new Po("UserInfo","用户信息","domain");
		o.add("Integer", "id", "id");
		o.add("String", "nick", "昵称");
		o.add("String", "email", "邮箱");
		o.add("String", "headId", "头像图片id");
		o.add("String", "phone", "电话");
		o.add("String", "male", "性别");
		o.add("String", "university", "大学");
		o.add("String", "company", "公司");
		o.add("String", "address", "住址");
		o.add("String", "qq", "qq号码");
		o.add("String", "micblog", "sina微博");
		o.add("String", "regTime", "注册时间");
		o.add("String", "status", "状态");
		
		
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		
	}
	
	public void angleInfoBuilder(){
		Po o = new Po("AngleInfo","天使信息","domain");
		o.add("Integer", "id", "id");
		o.add("String", "nick", "昵称");
		o.add("String", "email", "邮箱");
		o.add("String", "headId", "头像图片id");
		o.add("String", "phone", "电话");
		o.add("String", "male", "性别");
		o.add("String", "university", "大学");
		o.add("String", "company", "公司");
		o.add("String", "address", "住址");
		o.add("String", "qq", "qq号码");
		o.add("String", "micblog", "sina微博");
		o.add("String", "regTime", "注册时间");
		o.add("String", "status", "状态");
		o.add("String", "warnCount", "警告次数");
		
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		
	}
	
	public void loginInfoBuilder(){
		Po o = new Po("LoginInfo","登录信息","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "用户id");
		o.add("String", "nick", "用户名称");
		o.add("String", "email", "邮箱");
		o.add("String", "phone", "电话");
		o.add("String", "password", "密码");
		o.add("String", "lastLogin", "最近登录");
		o.add("String", "loginCount", "登录次数");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void albumBuilder(){
		Po o = new Po("Album","相册","domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "相册溟");
		o.add("String", "descript", "相册描述");
		o.add("Integer", "abCount", "访问数");
		o.add("String", "createTime", "创建时间");
		o.add("String", "userId", "用户id");
		o.add("String", "userName", "用户名");
		o.add("String", "status", "是否愿望相册");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	
	
	public void photoBuilder(){
		Po o = new Po("Photo","相册","domain");
		o.add("Integer", "id", "id");
		o.add("String", "imgPath", "照片路径");
		o.add("String", "name", "照片名");
		o.add("String", "descript", "照片描述");	
		o.add("String", "userId", "用户id");
		o.add("String", "userName", "用户名");	
		o.add("String", "albumId", "相册id");
		o.add("String", "albumName", "相册名");
		o.add("Integer", "phCount", "访问数");
		o.add("String", "createTime", "创建时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void ablumCommentBuilder(){
		Po o = new Po("AblumComment","相册以及照片评论","domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "评论名称");
		o.add("String", "content", "评论内容");
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户name");
		o.add("String", "commentTime", "评论时间");	
		o.add("String", "beId", "相册id");
		o.add("String", "beName", "相册名");
		o.add("String", "status", "是否相册");
		o.add("String", "beUserId", "用户id");
		o.add("String", "beUserName", "用户name");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setEditAddBuilderLst();
		cls.produceFiles();
	}
	
	public void ablumVisitBuilder(){
		Po o = new Po("AblumVisit","照片访客","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户name");
		o.add("String", "visitTime", "访问时间");	
		o.add("String", "beId", "相册id");
		o.add("String", "beName", "相册名");
		o.add("String", "status", "是否相册");
		o.add("String", "beUserId", "用户id");
		o.add("String", "beUserName", "用户name");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void friendBuilder(){
		Po o = new Po("Friend","好友","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户名");
		o.add("String", "beUserId", "被邀请id");
		o.add("String", "beUserName", "被邀请用户");
		o.add("String", "status", "是否通过");
		o.add("String", "apTime", "时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void blackBuilder(){
		Po o = new Po("Black","黑名单","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户名");
		o.add("String", "beUserId", "黑名单用户id");
		o.add("String", "beUserName", "黑名单用户名");
		o.add("String", "blackTime", "时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void attentBuilder(){
		Po o = new Po("Attent","关注","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户名");
		o.add("String", "beUserId", "被关注用户id");
		o.add("String", "beUserName", "被关注用户名");
		o.add("String", "attentTime", "时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void messageBuilder(){
		Po o = new Po("Message","消息","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "发送者id");	
		o.add("String", "userName", "发送者名");
		o.add("String", "beUserId", "用户id");
		o.add("String", "beUserName", "用户名");
		o.add("String", "title", "标题");
		o.add("String", "content", "内容");
		o.add("String", "status", "状态");
		o.add("String", "msgTime", "发送时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public void letterBuilder(){
		Po o = new Po("Letter","私信","domain");
		o.add("Integer", "id", "id");
		o.add("String", "userId", "发送者id");	
		o.add("String", "userName", "发送人");
		o.add("String", "beUserId", "接受人id");
		o.add("String", "beUserName", "接受人");
		o.add("String", "title", "标题");
		o.add("String", "content", "内容");
		o.add("String", "status", "状态");
		o.add("String", "ltrTime", "发送时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
	}
	
	public static void main(String[] args){
		
//		CodeBuilder builder = new CodeBuilder();
//		builder.letterBuilder();
	}

}
