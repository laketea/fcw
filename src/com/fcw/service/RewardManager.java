/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Reward;


public interface RewardManager {
	
	public void add(Reward reward);
	
	public void update(Reward reward);
	
	public void delete(Integer id);
	
	public List<Reward> findAll();
	
	public Reward get(Integer id);
	
	public Page findByPage(Reward reward,int pageNo ,int PageSize);
	
	public List findTopReward(Integer topNum);
	
	public void batchDelete(String ids);
	
	

}
