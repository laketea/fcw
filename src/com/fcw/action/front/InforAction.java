package com.fcw.action.front;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Comment;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.Reward;
import com.fcw.listener.InforCache;
import com.fcw.service.CommentManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.RewardManager;

public class InforAction extends BaseFrontAction {

	protected InformationManager mgr;

	protected InforChannelManager channelmgr;

	protected RewardManager rewardmgr;

	private CommentManager cmgr;

	private List<Reward> rewardLst;

	private List<Information> hotLst;

	private List<Information> recentLst;

	private List<Information> recommentLst;

	private List<InforChannel> channelLst;

	private List<Information> pdRecmdLst;

	private List<Information> pdRecmdLst2;

	private InforChannel channel;

	private InforChannel pchannel;

	private List<Information> inforLst;

	private Integer channelId = 0;

	private Integer pageNum = 0;

	private Page page;

	private Integer id;
	
	private Integer pid;
	
	private String pname;

	private Information infor;

	private String keywords;

	private Integer cid;

	private Integer vip = 0;

	private InforCache cache = InforCache.getInstance();

	public void setInformationManager(InformationManager mgr) {
		this.mgr = mgr;
	}

	public void setInforChannelManager(InforChannelManager mgr) {
		this.channelmgr = mgr;
	}

	public void setRewardManager(RewardManager mgr) {
		this.rewardmgr = mgr;
	}

	public void setCommentManager(CommentManager mgr) {
		this.cmgr = mgr;
	}

	/*
	 * 下载首页
	 */
	public String index() {

		cache = InforCache.getInstance();

		rewardLst = rewardmgr.findTopReward(10);

		channelLst = cache.getFirstLevelList();

		pdRecmdLst = mgr.findZlRecmdList(10, 0);

		pdRecmdLst2 = mgr.findZlRecmdList(10, 1);
		Integer id;
		// 遍历设置分类名
		if (!Utils.listNull(recommentLst)) {
			for (Information infor : recommentLst) {
				id = infor.getChannel_id();
				infor.setChannelName(cache.getChlMap().get(id).getName());
			}
		}

		// 遍历设置分类名
		if (!Utils.listNull(rewardLst)) {
			for (Reward infor : rewardLst) {
				id = infor.getTypeId();
				if (id != null) {
					infor.setTypeName(cache.getChlMap().get(id).getName());
				}
			}
		}
		return "index";
	}

	public String show() {
		infor = mgr.get(id);
		channel = cache.getChlMap().get(infor.getChannel_id());
		pchannel = cache.getParentChannel(channel.getId());
		infor.setViewCount(infor.getViewCount() + 1);
		mgr.update(infor);
		// 评论
		Integer perNum = 10;
		Comment cmt = new Comment();
		cmt.setSourceId(id);
		cmt.setTypeId(2);
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum / perNum + 1;
		page = cmgr.findByPage(cmt, pageNum, perNum);

		return "show";

	}

	/*
	 * 下载频道页面
	 */
	public String channel() {

		// channel = channelmgr.get(channelId);
		//
		
		//
		// inforLst = channel.getInformations();
		cache = InforCache.getInstance();
		
		channelLst = cache.getFirstLevelList();

		Integer perNum = 10;
		Information information = new Information();
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum / perNum + 1;
		Integer status = 0;

		if (channelId != 0) {
			channel = channelmgr.get(channelId);
			if (channel.getStatus() == null || channel.getStatus() == 0) {
				channelLst = channel.getChildChannels();
				String ids = "(0";
				if (!Utils.listNull(channelLst)) {
					for (InforChannel chl : channelLst) {
						ids += "," + chl.getId();
					}
				}
				ids += ")";
				information.setChannelIds(ids);// 大频道
				pid = channelId ;
				pname = channel.getName();
			} else {
				status = 1;
				information.setChannel_id(channel.getId());// 小频道
				channelLst = cache.getParentChannel(channelId).getChildChannels();
				pid =  cache.getParentChannel(channelId).getId();
				pname = cache.getParentChannel(channelId).getName();
			}
		}else{
			pid = 0 ;
			pname = "全部";
		}
		information.setExamine(1);

		// 设置VIP
		if (vip != null && vip == 1) {
			information.setVip(1);
		}

		page = mgr.findByPage(information, pageNum, perNum);
		// 遍历设置频道名称
		if (!Utils.listNull(page.getList())) {
			for (Information infor : (List<Information>) page.getList()) {
				infor.setChannelName(cache.getChlMap().get(infor.getChannel_id()).getName());
			}
		}

		pchannel = cache.getParentChannel(channelId);
		
		
		
		

		return "channel";

	}

	
	
	public String search() {

		cache = InforCache.getInstance();

		channelLst = cache.getFirstLevelList();

		try {
			keywords = URLDecoder.decode(keywords, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Integer perNum = 10;
		Information information = new Information();
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum / perNum + 1;
		information.setName(keywords);
		information.setExamine(1);

		// 设置VIP
		if (vip != null && vip == 1) {
			information.setVip(1);
		}

		// 设置频道
		if (cid != null && cid != -1) {

			channel = channelmgr.get(cid);
			if (channel.getStatus() == null || channel.getStatus() == 0) {
				List<InforChannel> channelLsts = channel.getChildChannels();
				String ids = "(0";
				if (!Utils.listNull(channelLsts)) {
					for (InforChannel chl : channelLsts) {
						ids += "," + chl.getId();
					}
				}
				ids += ")";
				information.setChannelIds(ids);// 大频道
			} else {
				information.setChannel_id(channel.getId());// 小频道
			}
		}

		page = mgr.findByPage(information, pageNum, perNum);
		// 遍历设置频道名称
		if (!Utils.listNull(page.getList())) {
			for (Information infor : (List<Information>) page.getList()) {
				infor.setChannelName(cache.getChlMap().get(infor.getChannel_id()).getName());
			}
		}

		return "search";
	}

	
	
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<Information> getPdRecmdLst2() {
		return pdRecmdLst2;
	}

	public void setPdRecmdLst2(List<Information> pdRecmdLst2) {
		this.pdRecmdLst2 = pdRecmdLst2;
	}

	public InforChannel getPchannel() {
		return pchannel;
	}

	public void setPchannel(InforChannel pchannel) {
		this.pchannel = pchannel;
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

	public List<Information> getPdRecmdLst() {
		return pdRecmdLst;
	}

	public void setPdRecmdLst(List<Information> pdRecmdLst) {
		this.pdRecmdLst = pdRecmdLst;
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

	public InforChannel getChannel() {
		return channel;
	}

	public void setChannel(InforChannel channel) {
		this.channel = channel;
	}

	public List<Information> getHotLst() {
		return hotLst;
	}

	public void setHotLst(List<Information> hotLst) {
		this.hotLst = hotLst;
	}

	public List<Information> getRecentLst() {
		return recentLst;
	}

	public void setRecentLst(List<Information> recentLst) {
		this.recentLst = recentLst;
	}

	public List<Information> getRecommentLst() {
		return recommentLst;
	}

	public void setRecommentLst(List<Information> recommentLst) {
		this.recommentLst = recommentLst;
	}

	public List<InforChannel> getChannelLst() {
		return channelLst;
	}

	public void setChannelLst(List<InforChannel> channelLst) {
		this.channelLst = channelLst;
	}

	public Information getInfor() {
		return infor;
	}

	public void setInfor(Information infor) {
		this.infor = infor;
	}

}
