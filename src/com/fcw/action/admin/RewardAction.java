
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Reward;
import com.fcw.service.RewardManager;


public class RewardAction extends BaseAction {
	
	protected RewardManager mgr;
	
	public List<Reward> rewardLst ;
	
	public Reward reward;
	
	public Integer id;
	
	public String ids;

	public void setRewardManager(RewardManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 悬赏列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getReward(),pageNum, getNumPerPage());
		List<Reward> ss =(List<Reward>)page.getList();
		setRewardLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除悬赏
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加悬赏
	 */
	public String add(){
		mgr.add(getReward());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑悬赏
	 */
	public String edit(){
		 reward = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改悬赏
	 */
	public String update(){
		Reward adm = mgr.get(getId());
		reward.setId(getId());
		//reward.setCreateDate(reward.getCreateDate());
		mgr.update(reward);
		return ajaxForwardSuccess("修改成功!");
	}
	
	/*
	 * 批量删除
	 */
	public String batch(){
		 mgr.batchDelete(ids);	
		return ajaxForwardSuccess("操作成功!");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public List<Reward> getRewardLst() {
		return rewardLst;
	}
	
	


	public void setRewardLst(List<Reward> rewardLst) {
		this.rewardLst = rewardLst;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
