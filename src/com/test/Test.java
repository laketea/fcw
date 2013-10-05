package com.test;

import com.auto.Builder.*;
import com.auto.business.Po;

public class Test {
	
	
	public void userRegBuilder(){
		Po o = new Po("UserInvite","�û�ע������","domain");
		o.add("Integer", "id", "id");
		o.add("String", "email", "����");
		o.add("String", "code", "��֤��");
		o.add("String", "memeberType", "��Ա����");
		o.add("String", "admin", "���뷢��������");
		o.add("String", "userId", "������id");
		o.add("String", "userName", "������name");
		
		Builder cls = new ListJspBuilder();
		// cls.po = o;
		try {
			cls.printFile(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		Po o = new Po("Test", "�û�", "domain");
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
