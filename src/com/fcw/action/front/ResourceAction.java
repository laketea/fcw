package com.fcw.action.front;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.News;
import com.fcw.domain.Resource;
import com.fcw.domain.ResourceChannel;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.listener.ResourceCache;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.SlideManager;
import com.fcw.service.UserInfoManager;

public class ResourceAction extends BaseFrontAction {

	protected ResourceManager mgr;

	protected ResourceChannelManager channelmgr;
	
	protected UserInfoManager tgmgr;
	
	

	protected SlideManager slidemgr;

	private List<ResourceChannel> channelLst;

	private ResourceChannel channel;

	private ResourceChannel topChannel;

	private Resource resource;

	private Integer channelId;

	private Integer topChlId;

	private Integer id;

	private Integer pageNum = 0;
	private Integer numPerPage = 10;

	private String keywords;

	private Page resPage;

	private String areacmp;

	private String regcmp;

	private String vipcmp;

	private List slideLst;
	
	List<UserInfo> userList;

	// 地区
	private String[] areaLst = WebSite.areaLst;

	public void setResourceManager(ResourceManager mgr) {
		this.mgr = mgr;
	}

	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.channelmgr = mgr;
	}

	public void setSlideManager(SlideManager mgr) {
		this.slidemgr = mgr;
	}
	
	public void setUserInfoManager(UserInfoManager mgr) {
		this.tgmgr = mgr;
	}

	/*
	 * 资源首页
	 */
	public String index() {

		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setStatus(0);
		Page page = channelmgr.findByPage(resourceChannel, 1, 10);
		channelLst = page.getList();

		if (!Utils.listNull(channelLst)) {
			for (ResourceChannel chl : channelLst) {
				if (chl != null && !Utils.listNull(chl.getChildChannels())) {
					for (ResourceChannel cl : chl.getChildChannels()) {
						cl.setResources(mgr.findChannelIndexRecommentTopLst(cl.getId(), 5));
					}
				}
			}
		}
		return "index";
	}

	/*
	 * 资源子频道页面
	 */
	public String channel() {

		// 首页幻灯片
		slideLst = slidemgr.findSlideByTypeId(3, 5);
		areacmp = getParameter("areacmp");
		vipcmp = getParameter("vipcmp");
		regcmp = getParameter("regcmp");
		try {
			topChlId = Integer.parseInt(getParameter("topChlId"));
			topChannel = channelmgr.get(topChlId);
		} catch (Exception e) {

		}
		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setStatus(0);
		Page page = channelmgr.findByPage(resourceChannel, 1, 10);
		channelLst = page.getList();

		channel = channelmgr.get(channelId);
		List<ResourceChannel> childLst = channel.getChildChannels();
		
		//设置ids 也就是当选择大类时，列出所有小类的数据
		String ids = "( ";
		if (topChlId != null && topChlId != 0) {
			ids += (topChlId + "");
		} else {
			if (!Utils.listNull(childLst)) {
				for (ResourceChannel rchl : childLst) {
					ids += rchl.getId() + ",";
				}
				ids += " 0 ";
			} else {
				ids += channel.getId();
			}
		}
		ids += " )";

		Resource res = new Resource();
		res.setArea(areacmp);
		if (Utils.notNull(vipcmp) && "1".equals(vipcmp)) {
			res.setVip(1);
		}
		res.setInChlId(ids);
		Integer perNum = 10;
		try {
			pageNum = Integer.parseInt(getParameter("pager.offset"));
		} catch (Exception e) {
		}
		pageNum = pageNum/perNum+1;
		resPage = mgr.findByPage(res, pageNum, perNum);
		return "channel";
	}

	public String search() {
		
		try {
			keywords = URLDecoder.decode(keywords,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 首页幻灯片
		slideLst = slidemgr.findSlideByTypeId(3, 5);
		areacmp = getParameter("areacmp");
		vipcmp = getParameter("vipcmp");
		regcmp = getParameter("regcmp");
		// 所有频道列表
		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setStatus(0);
		Page page = channelmgr.findByPage(resourceChannel, 1, 10);
		channelLst = page.getList();

		// 初始化chl对应的map
		HashMap<Integer, ResourceChannel> map = new HashMap<Integer, ResourceChannel>();
		if (channelLst != null) {
			for (ResourceChannel chl : (List<ResourceChannel>) channelLst) {
				map.put(chl.getId(), chl);
				if (!Utils.listNull(chl.getChildChannels())) {
					for (ResourceChannel rchl : chl.getChildChannels()) {
						map.put(rchl.getId(), rchl);
					}
				}
			}
		}

		// 将含有数据的chl的search值+1
		Resource resource = new Resource();
		resource.setName(keywords);
		resource.setArea(areacmp);
		if (Utils.notNull(vipcmp) && "1".equals(vipcmp)) {
			resource.setVip(1);
		}
		resPage = mgr.findByPage(resource, 1, 10);
		List<Resource> resLst = resPage.getList();
		if (!Utils.listNull(resLst)) {
			for (Resource res : resLst) {
				if (map.containsKey(res.getChannel_id())) {
					ResourceChannel rsChl = map.get(res.getChannel_id());
					rsChl.setSearchCount(rsChl.getSearchCount() + 1);
				}

			}

		}

		// 将小的数据统计到大类上
		if (channelLst != null) {
			for (ResourceChannel chl : (List<ResourceChannel>) channelLst) {
				int a = 0;
				if (!Utils.listNull(chl.getChildChannels())) {
					for (ResourceChannel rchl : chl.getChildChannels()) {
						a = a + rchl.getSearchCount();
					}
				}
				chl.setSearchCount(a);
			}
		}

		return "search";
	}

	/*
	 * 显示详细
	 */
	public String show() {
		resource = mgr.get(id);
		try{
		resource.setCnarea(WebSite.areaLst[Integer.valueOf(resource.getArea())-1]);
		}catch(Exception e){
			
		}
		channel =resource.getResourceChannel();
		topChannel =ResourceCache.getInstance().getParentChannel(channel.getId());
		
		List<UserInfo> userList = tgmgr.findCompanyVipUser(id);
		
		//筛选出VIP用户
		if(!Utils.listNull(userList)){
			for(int i= userList.size()-1;i>=0;i--){
				UserInfo uinfo = userList.get(i);
				if(uinfo.getUsers().getVip()!=1||uinfo.getUsers().getUserGroup()!=0){
					userList.remove(i);
				}
			}
		}
		
		
		
		
		
		return "show";
	}

	
	
	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public String getAreacmp() {
		return areacmp;
	}

	public void setAreacmp(String areacmp) {
		this.areacmp = areacmp;
	}

	public String getRegcmp() {
		return regcmp;
	}

	public void setRegcmp(String regcmp) {
		this.regcmp = regcmp;
	}

	public String getVipcmp() {
		return vipcmp;
	}

	public void setVipcmp(String vipcmp) {
		this.vipcmp = vipcmp;
	}

	public String[] getAreaLst() {
		return areaLst;
	}

	public void setAreaLst(String[] areaLst) {
		this.areaLst = areaLst;
	}

	public List getSlideLst() {
		return slideLst;
	}

	public void setSlideLst(List slideLst) {
		this.slideLst = slideLst;
	}

	public ResourceChannel getTopChannel() {
		return topChannel;
	}

	public void setTopChannel(ResourceChannel topChannel) {
		this.topChannel = topChannel;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getTopChlId() {
		return topChlId;
	}

	public void setTopChlId(Integer topChlId) {
		this.topChlId = topChlId;
	}

	public ResourceChannel getChannel() {
		return channel;
	}

	public void setChannel(ResourceChannel channel) {
		this.channel = channel;
	}

	public Integer getId() {
		return id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ResourceChannel> getChannelLst() {
		return channelLst;
	}

	public void setChannelLst(List<ResourceChannel> channelLst) {
		this.channelLst = channelLst;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Page getResPage() {
		return resPage;
	}

	public void setResPage(Page resPage) {
		this.resPage = resPage;
	}

}
