package com.test;

import com.auto.Builder.*;
import com.auto.business.Po;

public class Test {
	
	
	public void userRegBuilder(){
		Po o = new Po("UserInvite","用户注册邀请","domain");
		o.add("Integer", "id", "id");
		o.add("String", "email", "邮箱");
		o.add("String", "code", "验证码");
		o.add("String", "memeberType", "会员类型");
		o.add("String", "admin", "邀请发送者类型");
		o.add("String", "userId", "发送人id");
		o.add("String", "userName", "发送人name");
		
		Builder cls = new ListJspBuilder();
		// cls.po = o;
		try {
			cls.printFile(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		Po o = new Po("Test", "用户", "domain");
		o.add("Integer", "id", "1");
		o.add("String", "name", "2");
		o.add("String", "email", "3");
		o.add("String", "fined", "4");
		o.add("String", "st", "5");
		o.add("String", "sr", "6");
		o.add("String", "sg", "7");

		Builder cls = new SearchListJspBuilder();
		// cls.po = o;
		try {
			cls.printFile(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
