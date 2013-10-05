/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.HotWordsDao;
import com.fcw.domain.HotWords;
import com.fcw.service.HotWordsManager;


public class HotWordsManagerImpl implements HotWordsManager {
	
	
	private HotWordsDao hotwordsDao;
	
	public void setHotWordsDao(HotWordsDao hotwordsDao){
		this.hotwordsDao = hotwordsDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(HotWords hotwords) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		hotwords.setCreateTime(create_date);
		hotwordsDao.save(hotwords);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		hotwordsDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public HotWords get(Integer id){
		return hotwordsDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(HotWords hotwords) {
		// TODO Auto-generated method stub
		hotwordsDao.update(hotwords);
	}



	/* 
	 * 查询所有
	 */
	public List<HotWords> findAll() {
		return  hotwordsDao.findByHql("from HotWords order by sortNum asc");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(HotWords user, int pageNo, int pageSize) {
		String hql = " from HotWords where 1=1 order by sortNum asc ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		List lst = hotwordsDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = hotwordsDao.findByHql(hql);
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
		hotwordsDao.bulkUpdate("delete from HotWords where id in( "+ids+" )");
	}

}
