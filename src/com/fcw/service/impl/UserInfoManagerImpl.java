/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.UserInfoDao;
import com.fcw.domain.UserInfo;
import com.fcw.service.UserInfoManager;


public class UserInfoManagerImpl implements UserInfoManager {
	
	
	private UserInfoDao userinfoDao;
	
	public void setUserInfoDao(UserInfoDao userinfoDao){
		this.userinfoDao = userinfoDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(UserInfo userinfo) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		userinfo.setLastUpdateTime(create_date);
		userinfoDao.save(userinfo);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		userinfoDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public UserInfo get(Integer id){
		return userinfoDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(UserInfo userinfo) {
		// TODO Auto-generated method stub
		userinfoDao.update(userinfo);
	}

	public List findCompanyVipUser(Integer id ) {
		return userinfoDao.findByHql("from UserInfo where companyId="+id+" order by id desc");
	}


	/* 
	 * 查询所有
	 */
	public List<UserInfo> findAll() {
		return  userinfoDao.findByHql("from UserInfo");
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(UserInfo user, int pageNo, int pageSize) {
		String hql = " from UserInfo where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		List lst = userinfoDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = userinfoDao.findByHql(hql);
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
		userinfoDao.bulkUpdate("delete from UserInfo where id in( "+ids+" )");
	}

}
