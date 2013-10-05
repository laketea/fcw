/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.RewardDao;
import com.fcw.domain.Reward;
import com.fcw.service.RewardManager;


public class RewardManagerImpl implements RewardManager {
	
	
	private RewardDao rewardDao;
	
	public void setRewardDao(RewardDao rewardDao){
		this.rewardDao = rewardDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Reward reward) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		reward.setPbTime(create_date);
		rewardDao.save(reward);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		rewardDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Reward get(Integer id){
		return rewardDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Reward reward) {
		// TODO Auto-generated method stub
		rewardDao.update(reward);
	}
	
	/*
	 * top
	 */
	public List findTopReward(Integer topNum) {
		return rewardDao.findTopResult("from Reward  order by id desc", topNum);
	}



	/* 
	 * 查询所有
	 */
	public List<Reward> findAll() {
		return  rewardDao.findByHql("from Reward");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Reward user, int pageNo, int pageSize) {
		String hql = " from Reward where 1=1 ";
		if (user != null) {
			if (user.getUserId()!=null&&user.getUserId()!=0) {
				hql += " and userId =" + user.getUserId();
			}
		}
		hql +=" order by id desc ";
		List lst = rewardDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = rewardDao.findByHql(hql);
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
		rewardDao.bulkUpdate("delete from Reward where id in( "+ids+" )");
	}

}
