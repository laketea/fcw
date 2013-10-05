
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.RewardReply;
import com.fcw.service.RewardReplyManager;


public class RewardReplyAction extends BaseAction {
	
	protected RewardReplyManager mgr;
	
	public List<RewardReply> rewardReplyLst ;
	
	public RewardReply rewardReply;
	
	public Integer id;
	
	public String ids;

	public void setRewardReplyManager(RewardReplyManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 悬赏回复列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getRewardReply(),pageNum, getNumPerPage());
		List<RewardReply> ss =(List<RewardReply>)page.getList();
		setRewardReplyLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除悬赏回复
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加悬赏回复
	 */
	public String add(){
		mgr.add(getRewardReply());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑悬赏回复
	 */
	public String edit(){
		 rewardReply = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改悬赏回复
	 */
	public String update(){
		RewardReply adm = mgr.get(getId());
		rewardReply.setId(getId());
		//rewardReply.setCreateDate(rewardReply.getCreateDate());
		mgr.update(rewardReply);
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


	public List<RewardReply> getRewardReplyLst() {
		return rewardReplyLst;
	}
	
	


	public void setRewardReplyLst(List<RewardReply> rewardReplyLst) {
		this.rewardReplyLst = rewardReplyLst;
	}

	public RewardReply getRewardReply() {
		return rewardReply;
	}

	public void setRewardReply(RewardReply rewardReply) {
		this.rewardReply = rewardReply;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
