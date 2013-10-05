/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.ResourceDao;
import com.fcw.domain.Resource;
import com.fcw.service.ResourceManager;


public class ResourceManagerImpl implements ResourceManager {
	
	
	private ResourceDao resourceDao;
	
	public void setResourceDao(ResourceDao resourceDao){
		this.resourceDao = resourceDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Resource resource) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		resource.setAbout("");
		resource.setVip(0);
		resource.setStatus(0);
		String create_date = sdf.format(c.getTime());
		resource.setCreateTime(create_date);
		resourceDao.save(resource);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		resourceDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Resource get(Integer id){
		Resource resource =resourceDao.get(id);
//		Hibernate.initialize(resource.getResourceChannel());
		return resource;
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Resource resource) {
		// TODO Auto-generated method stub
		resourceDao.update(resource);
	}



	/* 
	 * 查询所有
	 */
	public List<Resource> findAll() {
		return  resourceDao.findByHql("from Resource");
	}
	
	public List<Resource> findDfAll() {
		return  resourceDao.findByHql("from Resource  where dfRecmd = 1  order by dfSortNum asc");
	}
	
//	/* 
//	 * 查询所有导航推荐的数据
//	 */
//	public List<Resource> findAll() {
//		return  resourceDao.findByHql("from Resource where  ");
//	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Resource resource, int pageNo, int pageSize) {
		String hql = " from Resource where 1=1 ";
		if (resource != null) {
			if (resource.getChannelId()!=null) {
				hql += " and channelId = "+resource.getChannelId()+" ";
			}
			if (resource.getVip()!=null&&resource.getVip()==1) {
				hql += " and vip = 1 ";
			}
			if (Utils.notNull(resource.getArea())&&!"0".equals(resource.getArea())) {
				hql += " and area = '"+resource.getArea()+"' ";
			}
			if (resource.getInChlId()!=null) {
				hql += " and channelId  in "+resource.getInChlId()+" ";
			}
			if (Utils.notNull(resource.getName())) {
				hql += " and name  like '%"+resource.getName()+"%'";
			}
		}
		hql+=" order by channelRecmd desc and channelRecmd asc";
		List lst = resourceDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = resourceDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}
	
	public List findChannelIndexRecommentTopLst(Integer channelId,Integer num){
		return resourceDao.findTopResult("from Resource where channelRecmd = 1 and channelId="+channelId+" order by channelSortNum asc", num);
	}
	
	public List findIndexRecommentTopLst(Integer num){
		return resourceDao.findTopResult("from Resource where dfRecmd = 0  order by dfSortNum asc", num);
	}
	
	/*
	 * 批量删除
	 */
	public void batchDelete(String ids){
		resourceDao.bulkUpdate("delete from Resource where id in( "+ids+" )");
	}

}
