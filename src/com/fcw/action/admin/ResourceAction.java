package com.fcw.action.admin;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Resource;
import com.fcw.domain.ResourceChannel;
import com.fcw.domain.UserInfo;
import com.fcw.domain.Users;
import com.fcw.service.ResourceChannelManager;
import com.fcw.service.ResourceManager;
import com.fcw.service.UserInfoManager;
import com.fcw.service.UsersManager;

public class ResourceAction extends BaseAction {

	protected ResourceManager mgr;

	protected ResourceChannelManager channelmgr;

	protected UsersManager umgr;

	protected UserInfoManager infomgr;

	public List<Resource> resourceLst;

	public Resource resource;

	public List<ResourceChannel> firstLevelChannelLst;

	public Integer id;

	public String ids;

	// 地区
	private String[] areaLst = WebSite.areaLst;

	public void setResourceManager(ResourceManager mgr) {
		this.mgr = mgr;
	}

	public void setResourceChannelManager(ResourceChannelManager mgr) {
		this.channelmgr = mgr;
	}

	public void setUsersManager(UsersManager mgr) {
		this.umgr = mgr;
	}

	public void setUserInfoManager(UserInfoManager mgr) {
		this.infomgr = mgr;
	}

	/*
	 * 房产资源列表
	 */
	public String list() {
		HashMap<Integer, ResourceChannel> map = channelmgr.findAllMap();
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getResource(), pageNum, getNumPerPage());
		List<Resource> ss = (List<Resource>) page.getList();
		setResourceLst(ss);
		if (!Utils.listNull(ss)) {
			for (Resource resource : ss) {
				if (map.containsKey(resource.getChannel_id())) {
					resource.setResourceChannel(map.get(resource.getChannel_id()));
				}
			}
		}
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}

	/*
	 * 删除房产资源
	 */
	public String delete() {
		resource = mgr.get(getId());
		if (resource.getUserId() != null && resource.getUserId() != 0) {
			umgr.delete(resource.getUserId());
		}
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}

	public String add() {
		firstLevelChannelLst = channelmgr.findFirstLevelChannel();
		return "add";
	}

	/*
	 * 添加房产资源
	 */
	public String save() {
		resource.setResourceChannel(channelmgr.get(resource.getChannelId()));
		resource.setChannel_id(resource.getChannelId());
		Users user = new Users();
		user.setNick(resource.getNick());
		user.setUserGroup(1);
		user.setPassword(resource.getPwd());
		user.setStatus(WebSite.USER_VERITY);

		UserInfo userInfo = new UserInfo();
		userInfo.setCompanyId(0);
		userInfo.setCompanyName(resource.getName());

		user.setUserInfo(userInfo);
		userInfo.setUsers(user);

		umgr.add(user);
		infomgr.add(userInfo);

		mgr.add(resource);

		userInfo.setCompanyId(resource.getId());
		infomgr.update(userInfo);

		return ajaxForwardSuccess("操作成功!");
	}

	/*
	 * 编辑房产资源
	 */
	public String edit() {
		firstLevelChannelLst = channelmgr.findFirstLevelChannel();
		resource = mgr.get(getId());
		resource.setResourceChannel(channelmgr.get(resource.getChannel_id()));
		return "edit";
	}

	/*
	 * 修改房产资源
	 */
	public String update() {
		Resource adm = mgr.get(getId());
		resource.setId(getId());
		resource.setChannel_id(resource.getChannelId());
		resource.setResourceChannel(channelmgr.get(resource.getChannelId()));
		resource.setCreateTime(adm.getCreateTime());
		mgr.update(resource);
		return ajaxForwardSuccess("修改成功!");
	}

	/*
	 * 批量删除
	 */
	public String batch() {
		mgr.batchDelete(ids);
		return ajaxForwardSuccess("操作成功!");
	}

	public String[] getAreaLst() {
		return areaLst;
	}

	public void setAreaLst(String[] areaLst) {
		this.areaLst = areaLst;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Resource> getResourceLst() {
		return resourceLst;
	}

	public void setResourceLst(List<Resource> resourceLst) {
		this.resourceLst = resourceLst;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
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
