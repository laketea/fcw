package com.fcw.dao;

import java.util.List;

import com.fcw.common.hibernate.GenericDao;
import com.fcw.domain.News;

/*
 *新闻dao接口
 */
public interface NewsDao extends GenericDao <News,Integer> {
	
	public List findTopResultByChannelId(Integer id,Integer topNum);

}
