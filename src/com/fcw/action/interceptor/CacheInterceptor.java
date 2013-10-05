package com.fcw.action.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CacheInterceptor extends MethodFilterInterceptor {
	
	public String doIntercept(ActionInvocation invocation) throws Exception {
		// 创建ActionContext实例
		Object action =  invocation.getAction();
		
		
		return invocation.invoke();
		
	}

}
