package com.fcw.action.admin;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.ResourceChannelManager;

public class ResourceChannelAction extends BaseAction {

	protected ResourceChannelManager mgr;

	public List<ResourceChannel> resourceChannelLst;

	public ResourceChannel resourceChannel;
	
	public List<ResourceChannel> firstLevelChannelLst ;

	public Integer id;

	public String ids;

	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.mgr = mgr;
	}

	/*
	 * 房产资源频道列表
	 */
	public String list() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		resourceChannel = resourceChannel==null?new ResourceChannel():resourceChannel;
		resourceChannel.setStatus(0);
		Page page = mgr.findByPage(getResourceChannel(), pageNum,
				getNumPerPage());
		List<ResourceChannel> ss = (List<ResourceChannel>) page.getList();
		setResourceChannelLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}

	/*
	 * 删除房产资源频道
	 */
	public String delete() {
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	public String add(){
		firstLevelChannelLst = mgr.findFirstLevelChannel();
		return "add";
	}

	/*
	 * 添加房产资源频道
	 */
	public String save() {
		if(resourceChannel!=null){
			if(resourceChannel.getParentId()>0){
				resourceChannel.setParentChannel(mgr.get(getResourceChannel().getParentId()));
				resourceChannel.setStatus(1);
			}else{
				resourceChannel.setStatus(0);
			}
			if(resourceChannel.getSortNum()==null){
				resourceChannel.setSortNum(0);
			}
			mgr.add(resourceChannel);
		}
		return ajaxForwardSuccess("操作成功!");
	}
	

	/*
	 * 编辑房产资源频道
	 */
	public String edit() {
		resourceChannel = mgr.get(getId());
		return "edit";
	}

	/*
	 * 修改房产资源频道
	 */
	public String update() {
		ResourceChannel adm = mgr.get(getId());
		adm.setName(resourceChannel.getName());
		adm.setSortNum(resourceChannel.getSortNum());
		adm.setDhstatus(resourceChannel.getDhstatus());
		adm.setDfstatus(resourceChannel.getDfstatus());
		adm.setDfTitle(resourceChannel.getDfTitle());//Url
		adm.setDfTitleUrl(resourceChannel.getDfTitleUrl());
		adm.setDfFirstLine(resourceChannel.getDfFirstLine());
		adm.setDfFirstLineUrl(resourceChannel.getDfFirstLineUrl());
		adm.setDfSecondLine(resourceChannel.getDfSecondLine());
		adm.setDfSecondLineUrl(resourceChannel.getDfSecondLineUrl());
		adm.setDfPhoto(resourceChannel.getDfPhoto());
		adm.setDfPhotoUrl(resourceChannel.getDfPhotoUrl());
		mgr.update(adm);
		return ajaxForwardSuccess("修改成功!");
	}

	/*
	 * 批量删除
	 */
	public String batch() {
		mgr.batchDelete(ids);
		return ajaxForwardSuccess("操作成功!");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ResourceChannel> getResourceChannelLst() {
		return resourceChannelLst;
	}

	public void setResourceChannelLst(List<ResourceChannel> resourceChannelLst) {
		this.resourceChannelLst = resourceChannelLst;
	}

	public ResourceChannel getResourceChannel() {
		return resourceChannel;
	}

	public void setResourceChannel(ResourceChannel resourceChannel) {
		this.resourceChannel = resourceChannel;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<ResourceChannel> getFirstLevelChannelLst() {
		return firstLevelChannelLst;
	}

	public void setFirstLevelChannelLst(List<ResourceChannel> firstLevelChannelLst) {
		this.firstLevelChannelLst = firstLevelChannelLst;
	}
	
	

}
