package com.fcw.listener;

import java.util.HashMap;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.domain.InforChannel;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.HotWordsManager;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;

public class InforCache {

	private static final InforCache single = new InforCache();

	public static InforCache getInstance() {
		return single;
	}

	public InforCache() {

	}

	protected InforChannelManager rchannelmgr;

	protected InformationManager informgr;

	public void setInforChannelManager(InforChannelManager mgr) {
		this.rchannelmgr = mgr;
	}

	public void setInformationManager(InformationManager mgr) {
		this.informgr = mgr;
	}

	private List<InforChannel> chlList;
	
	private List<InforChannel> firstLevelList;

	private HashMap<Integer, InforChannel> chlMap;

	private HashMap<Integer, InforChannel> relMap;// 关系表

	public void reflush() {

		chlList = rchannelmgr.findAll();
		chlMap = rchannelmgr.findAllMap();
		firstLevelList = rchannelmgr.findFirstLevelChannel();
		relMap = new HashMap<Integer, InforChannel>();
		if (!Utils.listNull(chlList)) {
			for (InforChannel chl : chlList) {
				if (Utils.listNull(chl.getChildChannels())) {
					continue;
				} else {
					for (InforChannel child : chl.getChildChannels()) {
						relMap.put(child.getId(), chl);
					}
				}
			}
		}
		System.out.println("///资源缓冲加载完毕");
	};

	public InforChannel getParentChannel(Integer id) {
		return relMap.containsKey(id) ? relMap.get(id) : null;
	}

	public List<InforChannel> getChlList() {
		return chlList;
	}

	public void setChlList(List<InforChannel> chlList) {
		this.chlList = chlList;
	}

	public HashMap<Integer, InforChannel> getChlMap() {
		return chlMap;
	}

	public void setChlMap(HashMap<Integer, InforChannel> chlMap) {
		this.chlMap = chlMap;
	}

	public HashMap<Integer, InforChannel> getRelMap() {
		return relMap;
	}

	public void setRelMap(HashMap<Integer, InforChannel> relMap) {
		this.relMap = relMap;
	}

	public List<InforChannel> getFirstLevelList() {
		return firstLevelList;
	}

	public void setFirstLevelList(List<InforChannel> firstLevelList) {
		this.firstLevelList = firstLevelList;
	}
	
	
	

}
