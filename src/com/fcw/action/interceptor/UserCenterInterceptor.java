package com.fcw.action.interceptor;

import java.util.Map;

import com.fcw.domain.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



/*
 * 用户中心检查用户是否登陆的拦截器
 */
public class UserCenterInterceptor extends AbstractInterceptor {
    public static final String NOTLOGIN = "usercenter_not_login";
 
    public String intercept(ActionInvocation actionInvocation) throws Exception {
 
//        Object action = actionInvocation.getAction();
        ActionContext ctx = ActionContext.getContext();
		Object obj =  ctx.getSession().get("user");
        if (obj==null||!(obj instanceof Users)) {//没有登录
        	return NOTLOGIN;
        } else {        	
             return actionInvocation.invoke();           
        }
    }
}
