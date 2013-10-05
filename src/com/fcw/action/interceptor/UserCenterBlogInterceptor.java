package com.fcw.action.interceptor;

import com.fcw.domain.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
 * 用户中心博客部分检查用户是否开通博客的拦截器
 */
public class UserCenterBlogInterceptor extends AbstractInterceptor {

	public static final String BLOG_NOT_INIT = "usercenter_blog_not_init";

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		// Object action = actionInvocation.getAction();
		ActionContext ctx = ActionContext.getContext();
		Users user = (Users) ctx.getSession().get("user");

		if (user.getBlog() != null && user.getBlog() != 0) {
			return actionInvocation.invoke();
		} else {// 博客没有开通
			return BLOG_NOT_INIT;
		}
	}

}
