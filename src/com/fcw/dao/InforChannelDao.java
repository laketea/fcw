package com.fcw.dao;

import java.util.List;

import com.fcw.common.hibernate.GenericDao;
import com.fcw.domain.InforChannel;

/*
 *资料分类dao接口
 */
public interface InforChannelDao extends GenericDao <InforChannel,Integer> {
	
	public InforChannel _get(Integer id);

}
