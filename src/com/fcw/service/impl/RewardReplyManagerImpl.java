/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.RewardReplyDao;
import com.fcw.domain.RewardReply;
import com.fcw.service.RewardReplyManager;


public class RewardReplyManagerImpl implements RewardReplyManager {
	
	
	private RewardReplyDao rewardreplyDao;
	
	public void setRewardReplyDao(RewardReplyDao rewardreplyDao){
		this.rewardreplyDao = rewardreplyDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(RewardReply rewardreply) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		rewardreply.setPbTime(create_date);
		rewardreplyDao.save(rewardreply);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		rewardreplyDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public RewardReply get(Integer id){
		return rewardreplyDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(RewardReply rewardreply) {
		// TODO Auto-generated method stub
		rewardreplyDao.update(rewardreply);
	}



	/* 
	 * 查询所有
	 */
	public List<RewardReply> findAll() {
		return  rewardreplyDao.findByHql("from RewardReply");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(RewardReply user, int pageNo, int pageSize) {
		String hql = " from RewardReply where 1=1 ";
		if (user != null) {
			if (user.getRewardId()!=null&&user.getRewardId()!=0) {
				hql += " and rewardId = " + user.getRewardId() + "";
			}
		}
		
		hql += " order by id desc";
		List lst = rewardreplyDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = rewardreplyDao.findByHql(hql);
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
		rewardreplyDao.bulkUpdate("delete from RewardReply where id in( "+ids+" )");
	}

}
