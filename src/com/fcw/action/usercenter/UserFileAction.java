package com.fcw.action.usercenter;

import java.util.List;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.domain.DownLoad;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.News;
import com.fcw.domain.Reward;
import com.fcw.domain.Users;
import com.fcw.listener.InforCache;
import com.fcw.service.CommentManager;
import com.fcw.service.DownLoadManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.RewardManager;

public class UserFileAction extends BaseFrontAction {

	protected InformationManager mgr;
	
	protected InforChannelManager channelmgr;

	protected DownLoadManager dmgr;
	
	protected RewardManager rmgr;

	private List<Information> inforLst;
	
	private List<InforChannel> chlList;

	private Integer channelId;

	private Page page;

	private Integer id;

	private Information info;

	private String keywords;
	
	private String exam;
	
	private Reward reward;

	private InforCache cache = InforCache.getInstance();

	public void setInformationManager(InformationManager mgr) {
		this.mgr = mgr;
	}

	public void setDownLoadManager(DownLoadManager mgr) {
		this.dmgr = mgr;
	}
	
	public void setRewardManager(RewardManager mgr) {
		this.rmgr = mgr;
	}
	
	public void setInforChannelManager(InforChannelManager mgr) {
		this.channelmgr = mgr;
	}

	/*
	 * 下载首页
	 */
	public String list() {
		
		exam = this.getParameter("exam");
		Users user = (Users) getSession().getAttribute("user");
		Information info = new Information();
		fetchPageNum();
		info.setUserId(user.getId());
		info.setExamine(Integer.valueOf(exam));
		page = mgr.findByPage(info, pageNum, perNum);
		setInfoListChannelName();
		return "userfile";
	}
	
	public String rewardlist(){
		Users user = (Users) getSession().getAttribute("user");
		Reward reward = new Reward();
		fetchPageNum();
		reward.setUserId(user.getId());
		page = rmgr.findByPage(reward, pageNum, perNum);
		return "reward-list";
	}
	
	public String reward(){
		chlList = cache.getChlList();
		return "publish-reward";
	}
	
	public String publishReward(){
		Users user = (Users) getSession().getAttribute("user");
		reward.setUserId(user.getId());
		reward.setUserName(user.getNick());
		reward.setRpCount(0);
		reward.setViewCount(0);
		
		InforChannel chl = channelmgr.get(info.getChannelId());
		reward.setTypeName(chl.getName());
		rmgr.add(reward);
				
		return "sucessed";
	}

	// 遍历设置频道名称
	public void setInfoListChannelName() {
		
		if (!Utils.listNull(page.getList())) {
			for (Information infor : (List<Information>) page.getList()) {
				infor.setChannelName(cache.getChlMap().get(infor.getChannel_id()).getName());
			}
		}

	}
	
	
	public String download() {
		
		Users user = (Users) getSession().getAttribute("user");
		DownLoad entity = new DownLoad();
		fetchPageNum();
		entity.setUserId(user.getId());
		page = dmgr.findByPage(entity, pageNum, perNum);
		
		return "download";
	}
	
	public String upload(){
		chlList = cache.getChlList();
		return "upload";
	}

	
	public List<InforChannel> getChlList() {
		return chlList;
	}

	public void setChlList(List<InforChannel> chlList) {
		this.chlList = chlList;
	}
	
	

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public void setInfo(Information info) {
		this.info = info;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public List<Information> getInforLst() {
		return inforLst;
	}

	public void setInforLst(List<Information> inforLst) {
		this.inforLst = inforLst;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Information getInfo() {
		return info;
	}

	public void setInfor(Information info) {
		this.info = info;
	}

}
