package com.fcw.action.front;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.fcw.common.ActionMsg;
import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.domain.Comment;
import com.fcw.domain.Information;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.service.CommentManager;
import com.fcw.service.DownLoadManager;
import com.fcw.service.InformationManager;
import com.fcw.service.UsersManager;


public class CommentAction extends BaseFrontAction {
	
	

	protected CommentManager mgr;
	
	protected DownLoadManager dmgr;
	
	protected InformationManager imgr;
	
	private Users user;
	
	

	public void setCommentManager(CommentManager mgr) {
		this.mgr = mgr;
	}	
	
	public void setDownLoadManager(DownLoadManager mgr) {
		this.dmgr = mgr;
	}	
	
	public void setInformationManager(InformationManager mgr) {
		this.imgr = mgr;
	}	
	
	
	public void comment(){
		Comment cmt = new Comment();
		String sourceId = this.getParameter("sourceId");
		String typeId = this.getParameter("typeId");
		String content = this.getParameter("content");
		String score = this.getParameter("score");
		
//		try {
//			content = URLDecoder.decode(content,"utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		cmt.setSourceId(Integer.valueOf(sourceId));
		cmt.setTypeId(Integer.valueOf(typeId));
		cmt.setContent(content);
		Object  obj = this.getSession().getAttribute("user");
		if(obj ==null){
			responseString("0");
			return ;
		}
		Users user = (Users)obj;
		
		
		//如果是资料处理
		if(cmt.getTypeId()==2){
			// 暂时没有做下载次数跟评论次数的判断
			Information info = imgr.get(cmt.getSourceId());
			info.setGradeCount(info.getGradeCount()==null?0:info.getGradeCount()+1);
			info.setScore(info.getScore()==null?0:info.getScore()+Integer.valueOf(score));
			info.setAveScore(info.getScore()/info.getGradeCount());
			imgr.update(info);
		}
		cmt.setUserId(user.getId());
		cmt.setUserName(user.getNick());
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		cmt.setPbTime(create_date);
		
		mgr.add(cmt);
		responseString("1");
	}
	
	
	
	
	
	

	

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
	

	
	
	
	

}
