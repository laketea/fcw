package com.fcw.dao.impl;

import java.util.*; 

import com.fcw.domain.*;
import com.fcw.common.hibernate.*;
import com.fcw.dao.*;


/*
 *新闻dao实现类
 */ 
public class NewsDaoHibernate
	extends GenericHibernateDao<News, Integer>
	implements NewsDao
{
	public List findTopResultByChannelId(Integer id,Integer topNum){
		return this.findTopResult("from News where channelId="+id+" order by id desc", topNum);
	};

}
