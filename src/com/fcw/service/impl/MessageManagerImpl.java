/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.MessageDao;
import com.fcw.domain.Message;
import com.fcw.service.MessageManager;


public class MessageManagerImpl implements MessageManager {
	
	
	private MessageDao messageDao;
	
	public void setMessageDao(MessageDao messageDao){
		this.messageDao = messageDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Message message) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		message.setSendTime(create_date);
		messageDao.save(message);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		messageDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Message get(Integer id){
		return messageDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Message message) {
		// TODO Auto-generated method stub
		messageDao.update(message);
	}



	/* 
	 * 查询所有
	 */
	public List<Message> findAll() {
		return  messageDao.findByHql("from Message");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Message user, int pageNo, int pageSize) {
		String hql = " from Message where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		hql += " order by id desc";
		List lst = messageDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = messageDao.findByHql(hql);
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
		messageDao.bulkUpdate("delete from Message where id in( "+ids+" )");
	}

}
