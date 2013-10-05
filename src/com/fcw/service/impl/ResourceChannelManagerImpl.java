/**
 * 
 */
package com.fcw.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.ResourceChannelDao;
import com.fcw.domain.InforChannel;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.ResourceChannelManager;

public class ResourceChannelManagerImpl implements ResourceChannelManager {

	private ResourceChannelDao resourcechannelDao;

	public void setResourceChannelDao(ResourceChannelDao resourcechannelDao) {
		this.resourcechannelDao = resourcechannelDao;
	}

	/*
	 * 添加管
	 */
	public void add(ResourceChannel resourcechannel) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		resourcechannel.setCreateTime(create_date);
		resourcechannelDao.save(resourcechannel);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		resourcechannelDao.deleteByKey(id);
	}

	/*
	 * 根据id获取实例
	 */
	public ResourceChannel get(Integer id) {
		return resourcechannelDao.get(id);
	}

	/*
	 * 修改
	 */
	@Override
	public void update(ResourceChannel resourcechannel) {
		// TODO Auto-generated method stub
		resourcechannelDao.update(resourcechannel);
	}

	/*
	 * 查询所有
	 */
	public List<ResourceChannel> findAll() {
		return resourcechannelDao.findByHql("from ResourceChannel");
	}
	
	/*
	 * 查询所有推荐
	 */
	public List<ResourceChannel> findAllDfstatus(Integer id) {
		return resourcechannelDao.findByHql("from ResourceChannel where dfstatus=1 and parentId="+id);
	}


	public HashMap<Integer, ResourceChannel> findAllMap() {
		HashMap<Integer, ResourceChannel> map = new HashMap<Integer, ResourceChannel>();
		List<ResourceChannel> lst = findAll();
		if (!Utils.listNull(lst)) {
			for (ResourceChannel cnl : lst) {
				map.put(cnl.getId(), cnl);
			}
		}
		return map;
	}

	public List<ResourceChannel> findFirstLevelChannel() {
		return resourcechannelDao.findByHql("from ResourceChannel where status=0 order by sortNum asc");
	}
	
	

	/*
	 * 分页查询
	 */
	public Page findByPage(ResourceChannel channel, int pageNo, int pageSize) {
		String hql = " from ResourceChannel where 1=1 ";
		if (channel != null) {
			if (channel.getStatus() != null) {
				hql += " and status = " + channel.getStatus() + "";
			}

		}
		hql += " order by sortNum asc ";
		List lst = resourcechannelDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = resourcechannelDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}

	/*
	 * 批量删除
	 */
	public void batchDelete(String ids) {
		resourcechannelDao.bulkUpdate("delete from ResourceChannel where id in( " + ids + " )");
	}

}
