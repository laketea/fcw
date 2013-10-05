/**
 * 
 */ 
package com.fcw.service.impl; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.dao.ArtCatalogDao;
import com.fcw.domain.ArtCatalog;
import com.fcw.service.ArtCatalogManager;


public class ArtCatalogManagerImpl implements ArtCatalogManager {
	
	
	private ArtCatalogDao artcatalogDao;
	
	public void setArtCatalogDao(ArtCatalogDao artcatalogDao){
		this.artcatalogDao = artcatalogDao;
	}
	
	/*
	 * 添加管
	 * 
	 */
	public void add(ArtCatalog artcatalog) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = sdf.format(c.getTime());
		artcatalog.setCreateTime(create_date);
		artcatalogDao.save(artcatalog);
	}

	/*
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		artcatalogDao.deleteByKey(id);
	}
	
	/* 
	 * 根据id获取实例
	 */
	public ArtCatalog get(Integer id){
		return artcatalogDao.get(id);
	}

	/* 
	 * 修改
	 */
	@Override
	public void update(ArtCatalog artcatalog) {
		// TODO Auto-generated method stub
		artcatalogDao.update(artcatalog);
	}



	/* 
	 * 查询所有
	 */
	public List<ArtCatalog> findAll() {
		return  artcatalogDao.findByHql("from ArtCatalog");
	}
	
	public List<ArtCatalog> findByBlog(Integer id){
		return  artcatalogDao.findByHql("from ArtCatalog where blogId = "+id);
	}
	/*
	 * 分页查询
	 */
	public Page findByPage(ArtCatalog user, int pageNo, int pageSize) {
		String hql = " from ArtCatalog where 1=1 ";
		//if (user != null) {
		//	if (Utils.notNull(user.getEmail())) {
		//		hql += " and email like '%" + user.getEmail() + "%'";
		//	}
		//	if (Utils.notNull(user.getMemeberType())) {
		//		hql += " and memeberType = '" + user.getMemeberType() + "'";
		//	}
		//}
		
		hql += " order by id desc";
		List lst = artcatalogDao.findByPageHql(hql, pageNo, pageSize);
		List allLst = artcatalogDao.findByHql(hql);
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
		artcatalogDao.bulkUpdate("delete from ArtCatalog where id in( "+ids+" )");
	}

}
