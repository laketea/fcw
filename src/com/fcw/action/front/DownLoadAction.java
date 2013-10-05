package com.fcw.action.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.Reward;
import com.fcw.domain.Users;
import com.fcw.listener.InforCache;
import com.fcw.service.CommentManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.RewardManager;
import com.fcw.service.UserInfoManager;
import com.opensymphony.xwork2.Action;

public class DownLoadAction extends BaseFrontAction {

	protected InformationManager mgr;

	private CommentManager cmgr;
	
	private UserInfoManager inmgr;

	private Integer id;

	private Information info;

	private Integer status = 0;

	private String fileName;
	private String filePath;

	public void setInformationManager(InformationManager mgr) {
		this.mgr = mgr;
	}

	public void setCommentManager(CommentManager mgr) {
		this.cmgr = mgr;
	}
	
	public void setUserInfoManager(UserInfoManager mgr) {
		this.inmgr = mgr;
	}
	
	

	public void checkup() {
		String id = this.getParameter("id");
		Object obj = this.getSession().getAttribute("user");
		if (obj == null) {
			responseString("1");// 未登录
			status = 1;
			return;
		}
		info = mgr.get(Integer.valueOf(id));
		Users user = (Users) obj;
		if (info.getVip() != null && info.getVip() == 1) {// 如果是VIP资料
			if (user.getVip() == 0) {
				responseString("2");// 仅VIP可下载
				status = 2;
				return;
			}
		} else {
			Integer score = user.getUserInfo().getScore();
			if (score == null || score < info.getCoin()) {
				responseString("3");// 积分不够
				status = 3;
				return;
			}
		}
		responseString("0");//
	}

	public String info() {
		checkup();
		if (status > 0) {
			return Action.ERROR;
		}

		Object obj = this.getSession().getAttribute("user");
		Users user = (Users) obj;
		if (info.getVip() != null && info.getVip() == 0) {
			user.getUserInfo().setScore(user.getUserInfo().getScore() - info.getCoin());
			inmgr.update(user.getUserInfo());
		}
		
		//待处理， 上传者的积分要增加
//		Users author = 

		info.setDownCount(info.getDownCount()+1);
		
		
		String path =info.getFilePath();
		File file =new File(ServletActionContext.getRequest().getRealPath("/temp"+File.separator+path));
		
		filePath = file.getPath();
		fileName = file.getName();

		
		return Action.SUCCESS; 

	}

	public InputStream getInputStream() throws Exception {
		fileName = new String(fileName.getBytes(), "ISO8859-1");
		return new FileInputStream(filePath);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}

}
