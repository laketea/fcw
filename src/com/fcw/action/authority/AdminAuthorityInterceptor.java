package com.fcw.action.authority;

import com.opensymphony.xwork2.*;

import com.opensymphony.xwork2.interceptor.*;


public class AdminAuthorityInterceptor extends MethodFilterInterceptor  {
	public String doIntercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		
		String level = (String) ctx.getSession().get("admin");
		if (level != null && level.equals("1")) {
			return invocation.invoke();
		} else {
			return "ajaxTimeOut";
		}
	}

	
}