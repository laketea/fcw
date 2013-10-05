package com.fcw.action.front;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Adv;
import com.fcw.domain.Information;
import com.fcw.domain.News;
import com.fcw.domain.Resource;
import com.fcw.domain.ResourceChannel;
import com.fcw.domain.Tender;
import com.fcw.service.AdvManager;
import com.fcw.service.HotWordsManager;
import com.fcw.service.InformationManager;
import com.fcw.service.NewsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.RewardManager;
import com.fcw.service.SlideManager;
import com.fcw.service.TenderManager;

public class DefaultAction extends BaseFrontAction {
	

	protected SlideManager slidemgr;

	protected NewsManager newsmgr;

	protected HotWordsManager hotmgr;

	protected ResourceChannelManager rchannelmgr;
	
	protected ResourceManager resourcemgr;
	
	protected TenderManager tendermgr;
	
	protected InformationManager informgr;
	
	protected RewardManager rewardmgr;
	
	protected AdvManager advmgr;
	
	private Integer isDefault = 1;

	public void setSlideManager(SlideManager mgr) {
		this.slidemgr = mgr;
	}

	public void setNewsManager(NewsManager mgr) {
		this.newsmgr = mgr;
	}

	public void setHotWordsManager(HotWordsManager mgr) {
		this.hotmgr = mgr;
	}

	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.rchannelmgr = mgr;
	}
	
	public void setResourceManager(ResourceManager mgr) {
		this.resourcemgr = mgr;
	}
	
	public void setTenderManager(TenderManager mgr) {
		this.tendermgr = mgr;
	}
	
	public void setInformationManager(InformationManager mgr) {
		this.informgr = mgr;
	}
	
	public void setRewardManager(RewardManager mgr) {
		this.rewardmgr = mgr;
	}
	
	public void setAdvManager(AdvManager mgr) {
		this.advmgr = mgr;
	}

	private List frTopNewsLst;//第一个栏目头条
	
	private List frTop2NewsLst;//第一个栏目头条2

	private List frDftNewsLst;//第一个栏目 首页推荐

	
	//业界快递部分
	private List sdTopNewsLst;//第二部分头条

	private List sdTop2NewsLst;//第二部分头条图文
	
	private List sdDftNewsLst;//第二部分推荐
	
	private List sdHotNewsLst;//热门
	
	//招标信息
	private Tender topTender;
	
	private List lateTenderList;
	
	private List hotTenderList;
	
	
	//资料
	private Information infor;
	
	private List dfInforList;
	
	private List hotInforList;
	
	
	
	private List sdPhotoNewsLst;

	private List hotKeyWordsLst;
	
	private News sdTopNews;
	
	private List slideLst;
	
	private List rewardLst;
	
	private Adv topAdv;
	
	private Adv topAdv2;

	private List<ResourceChannel> resourceChannelLst;

	public String index() {
		//首页幻灯片
		slideLst =slidemgr.findSlideByTypeId(1, 5);
		
		frTopNewsLst = newsmgr.findDftTopNews(2, 0);
		frTop2NewsLst = newsmgr.findDftTop2News(4, 0);
		List<News> frLst = newsmgr.findDftNews(32, 1);
		
		//业界快递部分
		sdTopNewsLst = newsmgr.findDftTopNews(1, 4);
		if(!Utils.listNull(sdTopNewsLst)){
			sdTopNews = (News)sdTopNewsLst.get(0);
		}
		
		sdTop2NewsLst = newsmgr.findDftTop2News(2, 4);
		sdDftNewsLst = newsmgr.findDftNews(2, 4);
		sdHotNewsLst = newsmgr.findTopNewsByChannelId(4, 6);
		
		formatDate(sdHotNewsLst);//转换时间隔世
		
		sdPhotoNewsLst = newsmgr.findPhotoNews(18, 4);
		hotKeyWordsLst = hotmgr.findAll();

		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setStatus(0);
		Page page = rchannelmgr.findByPage(resourceChannel, 0, 10);
		resourceChannelLst = page.getList();
		
		sortChannel();
		frDftNewsLst =new ArrayList<List<News>>(18);
//		resourceChannelLst = this.getNavResourceChannelLst();
		initDftNewsLst(frLst,frDftNewsLst);
		
		//商务合作部分
		List topTenderLst= tendermgr.getDfRecommendList(1);
		topTender = Utils.listNull(topTenderLst)?null:(Tender)topTenderLst.get(0);
		lateTenderList = tendermgr.getNewestList(8);
		hotTenderList = tendermgr.getHotList(10);
		
		//商务合作部分
		List topInfoLst= informgr.findTopRecommendList(1);
		infor = Utils.listNull(topInfoLst)?null:(Information)topInfoLst.get(0);
		dfInforList = informgr.findRecommentList(8);
		hotInforList = informgr.findHotList(10);
		
		rewardLst = rewardmgr.findTopReward(4);
		
		List lst =advmgr.findAdvByType(1);
		if(!Utils.listNull(lst)){
			topAdv= (Adv)(lst.get(0));
		}
		
		 lst =advmgr.findAdvByType(3);
		if(!Utils.listNull(lst)){
			topAdv2= (Adv)(lst.get(0));
		}
		

		return "index";
	}
	
	//首页推荐的新闻列表处理，方便前台按行取出，根据dfnum设置对应的行号
	public void initDftNewsLst(List<News> frLst,List destLst){
		for(int i=0;i<16;i++){
			destLst.add(new ArrayList<News>());
		}
		if(Utils.listNull(frLst)){
			return;
		}
		for(News news:frLst){
			Integer num = news.getDftNum();
			if(num/160>1)//如果行号大于15则不处理
				continue;
			//首页推荐规则 0-1 第一行， 10-11第二行以此类推
			((List<News>)destLst.get(num/10)).add(news);
		}
	}

	public void sortChannel() {
		if (Utils.listNull(resourceChannelLst))
			return;
		int i=0;
		
		//保存推荐channel以及其id的map
		HashMap<Integer,ResourceChannel> rmap = new HashMap<Integer,ResourceChannel>();
		List<ResourceChannel> rcLst;
		for (ResourceChannel channel : resourceChannelLst) {
			i++;
			channel.setSn(i);
			rcLst= rchannelmgr.findAllDfstatus(channel.getId());
			channel.setDfChildChannels(rcLst);
			if (!Utils.listNull(rcLst)) {//id与cl放进map
				for(ResourceChannel cl:rcLst){
				rmap.put(cl.getId(), cl);
				}
			}
			
			//排序
			List<ResourceChannel> tmpLst = channel.getChildChannels();
			if (!Utils.listNull(tmpLst)) {
				Collections.sort(tmpLst, new Comparator<ResourceChannel>() {
					public int compare(ResourceChannel o1, ResourceChannel o2) {
						int result = o1.getSortNum() - o2.getSortNum();
						if (result == 0) {
							result = o1.getName().compareTo(o2.getName());
						}
						return result;
					}
				});
			}
		}
		
		//导航推荐的 资源
		List<Resource> reourceLst= resourcemgr.findDfAll();
		if (!Utils.listNull(reourceLst)) {//id与cl放进map
			for(Resource res:reourceLst){
				if(rmap.containsKey(res.getChannel_id())){
					ResourceChannel resChannel = rmap.get(res.getChannel_id());
					resChannel.addChildResource(res);
				}
			}
		}
		
	}
	
	
	
	public Adv getTopAdv() {
		return topAdv;
	}

	public void setTopAdv(Adv topAdv) {
		this.topAdv = topAdv;
	}

	public List getSlideLst() {
		return slideLst;
	}

	public void setSlideLst(List slideLst) {
		this.slideLst = slideLst;
	}

	//转换时间隔世
	public void formatDate(List lst){
		if(Utils.listNull(lst)){
			return;
		}
		for(Iterator it= lst.iterator();it.hasNext();){
			News news = (News)it.next();
			news.setPbTime(Utils.dateFormat(news.getPbTime()));
		}
	}
	
	
	
	
	public Adv getTopAdv2() {
		return topAdv2;
	}

	public void setTopAdv2(Adv topAdv2) {
		this.topAdv2 = topAdv2;
	}

	public List getRewardLst() {
		return rewardLst;
	}

	public void setRewardLst(List rewardLst) {
		this.rewardLst = rewardLst;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public List getFrTopNewsLst() {
		return frTopNewsLst;
	}

	public void setFrTopNewsLst(List frTopNewsLst) {
		this.frTopNewsLst = frTopNewsLst;
	}

	public List getFrDftNewsLst() {
		return frDftNewsLst;
	}

	public void setFrDftNewsLst(List frDftNewsLst) {
		this.frDftNewsLst = frDftNewsLst;
	}

	public List getSdTopNewsLst() {
		return sdTopNewsLst;
	}

	public void setSdTopNewsLst(List sdTopNewsLst) {
		this.sdTopNewsLst = sdTopNewsLst;
	}

	
	
	public List getSdHotNewsLst() {
		return sdHotNewsLst;
	}

	public void setSdHotNewsLst(List sdHotNewsLst) {
		this.sdHotNewsLst = sdHotNewsLst;
	}

	public List getFrTop2NewsLst() {
		return frTop2NewsLst;
	}

	public void setFrTop2NewsLst(List frTop2NewsLst) {
		this.frTop2NewsLst = frTop2NewsLst;
	}

	public List getSdPhotoNewsLst() {
		return sdPhotoNewsLst;
	}

	public void setSdPhotoNewsLst(List sdPhotoNewsLst) {
		this.sdPhotoNewsLst = sdPhotoNewsLst;
	}

	public List getHotKeyWordsLst() {
		return hotKeyWordsLst;
	}

	public void setHotKeyWordsLst(List hotKeyWordsLst) {
		this.hotKeyWordsLst = hotKeyWordsLst;
	}

	public List getResourceChannelLst() {
		return resourceChannelLst;
	}

	public void setResourceChannelLst(List resourceChannelLst) {
		this.resourceChannelLst = resourceChannelLst;
	}

	public List getSdTop2NewsLst() {
		return sdTop2NewsLst;
	}

	public void setSdTop2NewsLst(List sdTop2NewsLst) {
		this.sdTop2NewsLst = sdTop2NewsLst;
	}

	public List getSdDftNewsLst() {
		return sdDftNewsLst;
	}

	public void setSdDftNewsLst(List sdDftNewsLst) {
		this.sdDftNewsLst = sdDftNewsLst;
	}

	public News getSdTopNews() {
		return sdTopNews;
	}

	public void setSdTopNews(News sdTopNews) {
		this.sdTopNews = sdTopNews;
	}

	public Tender getTopTender() {
		return topTender;
	}

	public void setTopTender(Tender topTender) {
		this.topTender = topTender;
	}

	public List getLateTenderList() {
		return lateTenderList;
	}

	public void setLateTenderList(List lateTenderList) {
		this.lateTenderList = lateTenderList;
	}

	public List getHotTenderList() {
		return hotTenderList;
	}

	public void setHotTenderList(List hotTenderList) {
		this.hotTenderList = hotTenderList;
	}

	public Information getInfor() {
		return infor;
	}

	public void setInfor(Information infor) {
		this.infor = infor;
	}

	public List getDfInforList() {
		return dfInforList;
	}

	public void setDfInforList(List lastInforList) {
		this.dfInforList = lastInforList;
	}

	public List getHotInforList() {
		return hotInforList;
	}

	public void setHotInforList(List hotInforList) {
		this.hotInforList = hotInforList;
	}
	
	
	
	
	
	
	
	

}
