/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.RewardReply;


public interface RewardReplyManager {
	
	public void add(RewardReply rewardreply);
	
	public void update(RewardReply rewardreply);
	
	public void delete(Integer id);
	
	public List<RewardReply> findAll();
	
	public RewardReply get(Integer id);
	
	public Page findByPage(RewardReply rewardreply,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	

}
