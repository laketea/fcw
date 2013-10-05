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
import com.fcw.dao.InforChannelDao;
import com.fcw.domain.InforChannel;
import com.fcw.domain.ResourceChannel;
import com.fcw.service.InforChannelManager;


public class InforChannelManagerImpl implements InforChannelManager {
	
	
	private InforChannelDao inforchannelDao;
	
	public void setInforChannelDao(InforChannelDao inforchannelDao){
		this.inforchannelDao = inforchannelDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(InforChannel inforchannel) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		inforchannel.setCreateTime(create_date);
		inforchannelDao.save(inforchannel);
	}
	
	public HashMap<Integer, InforChannel> findAllMap() {
		HashMap<Integer, InforChannel> map = new HashMap<Integer, InforChannel>();
		List<InforChannel> lst = findAll();
		if (!Utils.listNull(lst)) {
			for (InforChannel cnl : lst) {
				map.put(cnl.getId(), cnl);
			}
		}
		return map;
	}


	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		inforchannelDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public InforChannel get(Integer id){
		return inforchannelDao._get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(InforChannel inforchannel) {
		// TODO Auto-generated method stub
		inforchannelDao.update(inforchannel);
	}



	/* 
	 * 查询所有
	 */
	public List<InforChannel> findAll() {
		return  inforchannelDao.findByHql("from InforChannel");
	}
	
	public List<InforChannel> findFirstLevelChannel(){
		return  inforchannelDao.findByHql("from InforChannel where status=0 order by sortNum asc");
	}
	
	/*
	 * 分页查询
	 */
	public Page findByPage(InforChannel channel, int pageNo, int pageSize) {
		String hql = " from InforChannel where 1=1";
		if (channel != null) {
			if (channel.getStatus()!=null) {
				hql += " and status = " + channel.getStatus() + "";
			}
			
		}
		hql+=" order by sortNum asc ";
		List lst = inforchannelDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = inforchannelDao.findByHql(hql);
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
	public void batchDelete(String ids){
		inforchannelDao.bulkUpdate("delete from InforChannel where id in( "+ids+" )");
	}

}
