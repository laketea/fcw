package com.fcw.dao.impl;

import java.util.*; 

import org.hibernate.Hibernate;

import com.fcw.domain.*;
import com.fcw.common.hibernate.*;
import com.fcw.dao.*;


/*
 *资料分类dao实现类
 */ 
public class InforChannelDaoHibernate
	extends GenericHibernateDao<InforChannel, Integer>
	implements InforChannelDao
{
	public InforChannel _get(Integer id){
		InforChannel cl =super.get(id);
		Hibernate.initialize(cl);
		Hibernate.initialize(cl.getParentChannel());
		return cl;
	}
}
