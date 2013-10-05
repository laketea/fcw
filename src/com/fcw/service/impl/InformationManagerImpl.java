/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.dao.InformationDao;
import com.fcw.domain.Information;
import com.fcw.service.InformationManager;


public class InformationManagerImpl implements InformationManager {
	
	
	private InformationDao informationDao;
	
	public void setInformationDao(InformationDao informationDao){
		this.informationDao = informationDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Information information) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		information.setUpTime(create_date);
		informationDao.save(information);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		informationDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Information get(Integer id){
		return informationDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Information information) {
		// TODO Auto-generated method stub
		informationDao.update(information);
	}
	
	public List<Information> findRecommentList(Integer num){
		return informationDao.findTopResult("from Information where dfRecmd =2 and examine=1 order by dfSortNum asc", num);
	}
	
	public List<Information> findHotList(Integer num){
		return informationDao.findTopResult("from Information where examine=1  order by downCount desc", num);
	}
	
	public List findTopRecommendList(Integer num){
		return informationDao.findTopResult("from Information where dfRecmd =2 and examine=1 order by dfSortNum asc", num);
	}
	
	public List<Information> findRecentList(Integer num){
		return informationDao.findTopResult("from Information  where examine=1 order  by id desc", num);
	}
	
	public List<Information> findPdRecmdList(Integer num) {
		return informationDao.findTopResult("from Information  where pdRecmd=1 order  by pdSortNum asc", num);
	}
	
	public List<Information> findZlRecmdList(Integer num,Integer vip) {
		return informationDao.findTopResult("from Information  where zlDfRecmd=1 and vip = "+vip+" order  by zlDfNum desc", num);
	}




	/* 
	 * 查询所有
	 */
	public List<Information> findAll() {
		return  informationDao.findByHql("from Information");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Information user, int pageNo, int pageSize) {
		String hql = " from Information where 1=1 ";
		if (user != null) {

			if(Utils.notNull(user.getChannelIds())){
				hql += " and channel_id in " +user.getChannelIds();
				
			}
			if(user.getChannel_id()!=null&&user.getChannel_id()!=0){
				hql += " and channel_id = " +user.getChannel_id();
			}
			if (user.getExamine()==-1) {
				hql += " and examine = 0";
			}
			
			if (user.getVip()!=null&&user.getVip()!=-1) {
				hql += " and vip = "+user.getVip();
			}
			
			if (user.getExamine()==1) {
				hql += " and examine = 1";
			}
			if (user.getUserId()!=null&&user.getUserId()!=0) {
				hql += " and userid = "+user.getUserId();
			}
			if (Utils.notNull(user.getName())) {
				hql += " and ( name like  '%"+user.getName()+"%' or intro like '%"+user.getName()+"%') ";
			}
		}
		
		hql += " order by id desc";
		List lst = informationDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = informationDao.findByHql(hql);
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
		informationDao.bulkUpdate("delete from Information where id in( "+ids+" )");
	}

	


}
