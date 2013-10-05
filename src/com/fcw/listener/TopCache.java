package com.fcw.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Resource;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.HotWordsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;

/*
 * head数据的缓存
 */
public class TopCache {

	private static final TopCache single = new TopCache();

	public static TopCache getInstance() {
		return single;
	}

	protected HotWordsManager hotmgr;

	protected ResourceChannelManager rchannelmgr;

	protected ResourceManager resourcemgr;
	
	public void setHotWordsManager(HotWordsManager mgr) {
		this.hotmgr = mgr;
	}
	
	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.rchannelmgr = mgr;
	}

	public void setResourceManager(ResourceManager mgr) {
		this.resourcemgr = mgr;
	}
	

	private List<ResourceChannel> resourceChannelLst;//下拉导航栏的数据

	private List hotKeyWordsLst;//搜索栏下方的关键字
	
	private TopCache() {

	}

	public void reflush() {

		hotKeyWordsLst = hotmgr.findAll();

		ResourceChannel resourceChannel = new ResourceChannel();
		resourceChannel.setStatus(0);
		Page page = rchannelmgr.findByPage(resourceChannel, 0, 10);
		resourceChannelLst = page.getList();
		sortChannel();
	}

	public void sortChannel() {
		if (Utils.listNull(resourceChannelLst))
			return;
		int i = 0;

		// 保存推荐channel以及其id的map
		HashMap<Integer, ResourceChannel> rmap = new HashMap<Integer, ResourceChannel>();
		List<ResourceChannel> rcLst;
		for (ResourceChannel channel : resourceChannelLst) {
			i++;
			channel.setSn(i);
			rcLst = rchannelmgr.findAllDfstatus(channel.getId());
			channel.setDfChildChannels(rcLst);
			if (!Utils.listNull(rcLst)) {// id与cl放进map
				for (ResourceChannel cl : rcLst) {
					rmap.put(cl.getId(), cl);
				}
			}

			// 排序
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

		// 导航推荐的 资源
		List<Resource> reourceLst = resourcemgr.findDfAll();
		if (!Utils.listNull(reourceLst)) {// id与cl放进map
			for (Resource res : reourceLst) {
				if (rmap.containsKey(res.getChannel_id())) {
					ResourceChannel resChannel = rmap.get(res.getChannel_id());
					resChannel.addChildResource(res);
				}
			}
		}

	}

	public List<ResourceChannel> getResourceChannelLst() {
		return resourceChannelLst;
	}

	public void setResourceChannelLst(List<ResourceChannel> resourceChannelLst) {
		this.resourceChannelLst = resourceChannelLst;
	}

	public List getHotKeyWordsLst() {
		return hotKeyWordsLst;
	}

	public void setHotKeyWordsLst(List hotKeyWordsLst) {
		this.hotKeyWordsLst = hotKeyWordsLst;
	}
	
	

	

}
