/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.RecordDao;
import com.fcw.domain.Record;
import com.fcw.service.RecordManager;


public class RecordManagerImpl implements RecordManager {
	
	
	private RecordDao recordDao;
	
	public void setRecordDao(RecordDao recordDao){
		this.recordDao = recordDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(Record record) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		record.setPbTime(create_date);
		recordDao.save(record);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		recordDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public Record get(Integer id){
		return recordDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(Record record) {
		// TODO Auto-generated method stub
		recordDao.update(record);
	}

	
	public List<Record> findTopList(Integer id,Integer num){
		return recordDao.findTopResult("from Record where blogId = "+id+" order by id desc", num);
	}


	/* 
	 * 查询所有
	 */
	public List<Record> findAll() {
		return  recordDao.findByHql("from Record");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(Record user, int pageNo, int pageSize) {
		String hql = " from Record where 1=1 ";
		if (user != null) {
			
			if (user.getBlogId()!=null&&user.getBlogId()!=0) {
				hql += " and blogId = " + user.getBlogId() ;
			}
		}
		hql += " order by id desc";
		List lst = recordDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = recordDao.findByHql(hql);
		int totalRecords = allLst.size();
		Page page = new Page(lst);
		page.setTotalRecords(totalRecords);
		page.setPageSize(pageSize);
		page.setCurPageNumber(pageNo);
		return page;
	}
	
	public Page findFriendsRecordPage(Integer id, int pageNo, int pageSize) {
		String hql = "select rd from Record as rd, Friend as fr where ( rd.blogId = fr.fromId and fr.toId = "+id+" ) or " +
				"(  rd.blogId = fr.toId and fr.fromId = "+id+" )";
		hql += " order by rd.id desc";
		List lst = recordDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = recordDao.findByHql(hql);
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
		recordDao.bulkUpdate("delete from Record where id in( "+ids+" )");
	}

}
