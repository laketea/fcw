/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.DownLoadDao;
import com.fcw.domain.DownLoad;
import com.fcw.service.DownLoadManager;


public class DownLoadManagerImpl implements DownLoadManager {
	
	
	private DownLoadDao downloadDao;
	
	public void setDownLoadDao(DownLoadDao downloadDao){
		this.downloadDao = downloadDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(DownLoad download) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		download.setDownLoadTime(create_date);
		downloadDao.save(download);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		downloadDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public DownLoad get(Integer id){
		return downloadDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(DownLoad download) {
		// TODO Auto-generated method stub
		downloadDao.update(download);
	}



	/* 
	 * 查询所有
	 */
	public List<DownLoad> findAll() {
		return  downloadDao.findByHql("from DownLoad");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(DownLoad user, int pageNo, int pageSize) {
		String hql = " from DownLoad where 1=1 ";
		if (user != null) {
			if (user.getUserId()!=null&&user.getUserId()!=0) {
				hql += " and userId ="+user.getUserId();
			}
		}
		hql += " order by id desc";
		List lst = downloadDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = downloadDao.findByHql(hql);
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
		downloadDao.bulkUpdate("delete from DownLoad where id in( "+ids+" )");
	}

}
