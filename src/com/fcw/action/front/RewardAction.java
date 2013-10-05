package com.fcw.action.front;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.Reward;
import com.fcw.domain.RewardReply;
import com.fcw.domain.Users;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.RewardManager;
import com.fcw.service.RewardReplyManager;

public class RewardAction extends BaseFrontAction {
	
	protected RewardManager rewardmgr;
	
	protected RewardReplyManager replymgr;
	
	private List<Reward> rewardLst;	
	

	private Integer channelId;

	private Integer pageNum = 0;

	private Page page;
	
	private Integer id;
	
	private Reward reward;
	
	

	public void setRewardManager(RewardManager mgr) {
		this.rewardmgr = mgr;
	}
	
	public void setRewardReplyManager(RewardReplyManager mgr) {
		this.replymgr = mgr;
	}


	/*
	 * 悬赏首页
	 */
	public String index() {
		Integer perNum = 10;
		Reward reward = new Reward();
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		page = rewardmgr.findByPage(reward, pageNum, perNum);
		return "index";
	}
	
	
	
	public String show(){
		reward = rewardmgr.get(id);
		
		Integer perNum = 10;
		RewardReply reply = new RewardReply();
		reply.setRewardId(id);
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		page = replymgr.findByPage(reply, pageNum, perNum);
		return "show";
	}
	
	public String reply(){
		String id = this.getParameter("sourceId");
		String content = this.getParameter("content");
		String url = this.getParameter("url");
		
		Object  obj = this.getSession().getAttribute("user");
		if(obj ==null){
			responseString("0");
			return "";
		}
		Users user = (Users)obj;
		RewardReply reply  = new RewardReply();
		
		reply.setRewardId(Integer.valueOf(id));
		reply.setContent(content);
		reply.setUrl(url);
		reply.setUserId(user.getId());
		reply.setUserName(user.getNick());
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		reply.setPbTime(create_date);
		
		replymgr.add(reply);
		
		return "show";
	}


	public Reward getReward() {
		return reward;
	}


	public void setReward(Reward reward) {
		this.reward = reward;
	}


	public List<Reward> getRewardLst() {
		return rewardLst;
	}

	public void setRewardLst(List<Reward> rewardLst) {
		this.rewardLst = rewardLst;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	
	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	

}
