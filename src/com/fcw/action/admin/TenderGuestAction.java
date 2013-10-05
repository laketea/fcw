
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.TenderGuest;
import com.fcw.service.TenderGuestManager;


public class TenderGuestAction extends BaseAction {
	
	protected TenderGuestManager mgr;
	
	public List<TenderGuest> tenderGuestLst ;
	
	public TenderGuest tenderGuest;
	
	public Integer id;
	
	public String ids;

	public void setTenderGuestManager(TenderGuestManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 投标信息列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getTenderGuest(),pageNum, getNumPerPage());
		List<TenderGuest> ss =(List<TenderGuest>)page.getList();
		setTenderGuestLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除投标信息
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加投标信息
	 */
	public String add(){
		mgr.add(getTenderGuest());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑投标信息
	 */
	public String edit(){
		 tenderGuest = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改投标信息
	 */
	public String update(){
		TenderGuest adm = mgr.get(getId());
		tenderGuest.setId(getId());
		//tenderGuest.setCreateDate(tenderGuest.getCreateDate());
		mgr.update(tenderGuest);
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


	public List<TenderGuest> getTenderGuestLst() {
		return tenderGuestLst;
	}
	
	


	public void setTenderGuestLst(List<TenderGuest> tenderGuestLst) {
		this.tenderGuestLst = tenderGuestLst;
	}

	public TenderGuest getTenderGuest() {
		return tenderGuest;
	}

	public void setTenderGuest(TenderGuest tenderGuest) {
		this.tenderGuest = tenderGuest;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
