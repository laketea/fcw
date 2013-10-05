/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.FriendDao;
import com.fcw.domain.Friend;
import com.fcw.domain.Record;
import com.fcw.service.FriendManager;


public class FriendManagerImpl implements FriendManager {
	
	
	private FriendDao friendDao;
	
	public void setFriendDao(FriendDao friendDao){
		this.friendDao = friendDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Friend friend) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		friend.setSendTime(create_date);
		friendDao.save(friend);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		friendDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Friend get(Integer id){
		return friendDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		friendDao.update(friend);
	}

	public List<Friend> findTopList(Integer id,Integer num){
		return friendDao.findTopResult("from Friend where toId = "+id+" and status=3 order by id desc", num);
	}

	/* 
	 * 查询所有
	 */
	public List<Friend> findAll() {
		return  friendDao.findByHql("from Friend");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Friend user, int pageNo, int pageSize) {
		String hql = " from Friend where 1=1 ";
		if (user != null) {
			
			if (user.getOwn()!=null&&user.getOwn()!=0) {
				hql += " and fromId = " + user.getOwn();
			}
			
			if (user.getToId()!=null&&user.getToId()!=0) {
				hql += " and toId = " + user.getToId();
			}
			
			if (user.getStatus()!=null&&user.getStatus()!=0) {
				hql += " and status = " + user.getStatus();
			}
		}
		hql += "   order by id desc";
		List lst = friendDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = friendDao.findByHql(hql);
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
		friendDao.bulkUpdate("delete from Friend where id in( "+ids+" )");
	}

}
