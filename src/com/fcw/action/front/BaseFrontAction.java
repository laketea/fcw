package com.fcw.action.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fcw.common.Utils;
import com.fcw.domain.ResourceChannel;
import com.fcw.listener.DefaultCache;
import com.fcw.listener.TopCache;
import com.opensymphony.xwork2.ActionSupport;

public class BaseFrontAction extends ActionSupport {

	public String errMsg;
	
	public TopCache topCache = TopCache.getInstance();
	
	public boolean resStatus = true;
	
	public Integer perNum = 15;
	
	public Integer pageNum = 0;
	
	private Pager pager;
	
	
	public void fetchPageNum(){
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
	}
	

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession(true);
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public String getParameter(String name) {
		return getRequest().getParameter(name);
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public void responseString(String str) {
		if(!resStatus){
			return;
		}
		if (!Utils.notNull(str)) {
			return;
		}
		HttpServletResponse response = this.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TopCache getTopCache() {
		return topCache;
	}

	public void setTopCache(TopCache topCache) {
		this.topCache = topCache;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
	
	
	

	
	
	

}

class Pager{
	
	private int offset ;
	
	public Pager(){
		
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
	
	
}


