package com.auto;

import com.auto.Builder.ActionBuilder;
import com.auto.Builder.Builder;
import com.auto.business.Po;

public class SzrzBuilder {
	
	
	
	
//********************************数字认证系统
	
	public void userBuilder(){		
		Po o = new Po("User","用户","domain");
		o.add("Integer", "id", "id");
		o.add("String", "nick", "昵称");	
		o.add("String", "name", "用户姓名");	
		o.add("String", "idCard", "身份证");
		o.add("String", "passward", "密码");	
		o.add("String", "email", "邮箱");
		o.add("String", "age", "年龄");	
		o.add("String", "male", "性别");	
		o.add("String", "userWork", "职业");	
		o.add("Integer", "goldCoin", "金币");
		o.add("String", "status", "状态");
		o.add("String", "regTime", "注册时间");
		o.add("Integer", "loginCount", "登录次数");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void copyRightImgBuilder(){		
		Po o = new Po("CopyRightImg","版权保护图片","domain");
		o.add("Integer", "id", "id");
		o.add("String", "imgName", "图像名称");
		o.add("String", "oglPath", "原始图片id");	
		o.add("String", "path", "新图片id");	
		o.add("String", "typeId", "类型Id");	
		o.add("String", "startDate", "开始时间");
		o.add("String", "endDate", "结束时间");	
		o.add("String", "validDate", "有效期");	
		o.add("String", "userId", "用户Id");	
		o.add("String", "userName", "用户名");
		o.add("String", "userIdCard", "用户身份证");
		o.add("String", "spendCoin", "话费金币");
		o.add("String", "copyRightTime", "认证时间");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
		
	}
	
	public void antiImgBuilder(){		
		Po o = new Po("AntiImg","防伪认证图片","domain");
		o.add("Integer", "id", "id");
		o.add("String", "imgName", "图像名称");
		o.add("String", "oglPath", "原始图片id");	
		o.add("String", "path", "新图片id");	
		o.add("String", "typeId", "类型Id");	
		o.add("String", "startDate", "开始时间");
		o.add("String", "endDate", "结束时间");	
		o.add("String", "validDate", "有效期");
		o.add("String", "shootPlace", "拍摄地点");	
		o.add("String", "shootTime", "拍摄时间");	
		o.add("String", "userId", "用户Id");	
		o.add("String", "userName", "用户名");
		o.add("String", "userIdCard", "用户身份证");
		o.add("Integer", "valueCoin", "售价");
		o.add("Integer", "spendCoin", "话费金额");
		o.add("String", "antiTime", "认证时间");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void purImgBuilder(){		
		Po o = new Po("PurImg","防伪认证图片","domain");
		o.add("Integer", "id", "id");
		o.add("String", "imgName", "图像名称");
		o.add("String", "oglPath", "原始图片id");	
		o.add("String", "path", "新图片id");	
		o.add("String", "typeId", "类型Id");	
		o.add("String", "typeName", "类型名称");	
		o.add("String", "purUserId", "购买人Id");	
		o.add("String", "purUserName", "购买人names");
		o.add("String", "purUserIdCard", "购买人用户身份证");
		o.add("String", "purTime", "购买人用户身份证");
		o.add("String", "imgId", "图片id");
		//原始信息
		o.add("Integer", "valueCoin", "售价");
		o.add("String", "antiTime", "认证时间");	
		o.add("String", "startDate", "开始时间");
		o.add("String", "endDate", "结束时间");	
		o.add("String", "validDate", "有效期");
		o.add("String", "shootPlace", "拍摄地点");	
		o.add("String", "shootTime", "拍摄时间");	
		o.add("String", "userId", "用户Id");	
		o.add("String", "userName", "用户名");
		o.add("String", "userIdCard", "用户身份证");
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void ImgTypeBuilder(){		
		Po o = new Po("ImgType","图片类型","domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "类型名称");
		o.add("String", "imgCount", "拥有图片总数");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void NewsTypeBuilder(){		
		Po o = new Po("NewsType","新闻类型","domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "新闻类型");
		o.add("String", "newsCount", "拥有新闻总数");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void NewsBuilder(){		
		Po o = new Po("News","新闻","domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "标题");
		o.add("String", "content", "内容");
		o.add("String", "typeId", "类型Id");	
		o.add("String", "typeName", "类型");	
		o.add("String", "viewCount", "浏览次数");	
		o.add("String", "publishTime", "发布时间");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void GuestBookTypeBuilder(){		
		Po o = new Po("GuestBookType","留言类型","domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "留言类型");
		o.add("String", "gbCount", "拥有留言总数");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void GuestBookBuilder(){		
		Po o = new Po("GuestBook","留言","domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "标题");
		o.add("String", "content", "内容");
		o.add("String", "typeId", "类型Id");	
		o.add("String", "typeName", "类型");	
		o.add("String", "userId", "用户id");	
		o.add("String", "userName", "用户名");	
		o.add("String", "userNick", "昵称");	
		o.add("String", "replyContent", "回复");	
		o.add("String", "replyTime", "回复时间");	
		o.add("String", "guestBookTime", "留言时间");	
		o.add("String", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	public void ptString(Po o){
		
		String struts="<action name=\""+o.getFirstLowClassName()+"\"\n";
		struts+= "class=\"com.szrz.action."+o.getClassName()+"Action\">\n";
		struts+="\t<result name=\"list\">/admin/"+o.getClassName().toLowerCase()+"/list.jsp</result>\n";
		struts+="\t<result name=\"edit\">/admin/"+o.getClassName().toLowerCase()+"/edit.jsp</result>\n";
		struts+="</action> ";
		
		String application ="<bean id=\""+o.getFirstLowClassName()+"Manager\"\n";
		application +="\tclass=\"com.szrz.service.impl."+o.getClassName()+"ManagerImpl\"\n";
		application +="\tparent=\""+o.getFirstLowClassName()+"Template\"/>";
		
		String str ="<bean id=\""+o.getFirstLowClassName()+"Dao\" class=\"com.szrz.dao.impl."+o.getClassName()+"DaoHibernate\" parent=\"daoTemplate\"/>";
		
		System.out.println("struts.xml-----------/////////////////////");
		System.out.println(struts);
		
		System.out.println("daoContext.xml-----------/////////////////////");
		System.out.println(str);
		
		System.out.println("application.xml-----------/////////////////////");
		System.out.println(application);
		
		
		String zz="<bean id=\""+o.getFirstLowClassName()+"Template\" abstract=\"true\" lazy-init=\"true\" p:"+o.getFirstLowClassName()+"Dao-ref=\""+o.getFirstLowClassName()+"Dao\" />";
		System.out.println("xxx.xml-----------/////////////////////");
		System.out.println(zz);
	}
	
	
	
	
	public static void main(String[] args){
		
		SzrzBuilder builder = new SzrzBuilder();
//		builder.GuestBookBuilder();
	}

}
