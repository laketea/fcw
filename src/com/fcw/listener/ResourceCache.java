package com.fcw.listener;

import java.util.HashMap;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.HotWordsManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;

public class ResourceCache {

	private static final ResourceCache single = new ResourceCache();

	public static ResourceCache getInstance() {
		return single;
	}

	public ResourceCache() {

	}

	protected ResourceChannelManager rchannelmgr;

	protected ResourceManager resourcemgr;

	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.rchannelmgr = mgr;
	}

	public void setResourceManager(ResourceManager mgr) {
		this.resourcemgr = mgr;
	}

	private List<ResourceChannel> chlList;

	private HashMap<Integer, ResourceChannel> chlMap;

	private HashMap<Integer, ResourceChannel> relMap;// 关系表

	public void reflush() {

		chlList = rchannelmgr.findAll();
		chlMap = rchannelmgr.findAllMap();
		relMap = new HashMap<Integer, ResourceChannel>();
		if (!Utils.listNull(chlList)) {
			for (ResourceChannel chl : chlList) {
				if (Utils.listNull(chl.getChildChannels())) {
					continue;
				} else {
					for (ResourceChannel child : chl.getChildChannels()) {
						relMap.put(child.getId(), chl);
					}
				}
			}
		}
		System.out.println("///资源缓冲加载完毕");
	};

	public ResourceChannel getParentChannel(Integer id) {
		return relMap.containsKey(id) ? relMap.get(id) : null;
	}

	public List<ResourceChannel> getChlList() {
		return chlList;
	}

	public void setChlList(List<ResourceChannel> chlList) {
		this.chlList = chlList;
	}

	public HashMap<Integer, ResourceChannel> getChlMap() {
		return chlMap;
	}

	public void setChlMap(HashMap<Integer, ResourceChannel> chlMap) {
		this.chlMap = chlMap;
	}

	public HashMap<Integer, ResourceChannel> getRelMap() {
		return relMap;
	}

	public void setRelMap(HashMap<Integer, ResourceChannel> relMap) {
		this.relMap = relMap;
	}
	
	

}
