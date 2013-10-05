
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Tender;
import com.fcw.service.TenderManager;


public class TenderAction extends BaseAction {
	
	protected TenderManager mgr;
	
	public List<Tender> tenderLst ;
	
	public Tender tender;
	
	public Integer id;
	
	public String ids;

	public void setTenderManager(TenderManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 招标列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getTender(),pageNum, getNumPerPage());
		List<Tender> ss =(List<Tender>)page.getList();
		setTenderLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除招标
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加招标
	 */
	public String add(){
		mgr.add(getTender());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑招标
	 */
	public String edit(){
		 tender = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改招标
	 */
	public String update(){
		Tender adm = mgr.get(getId());
		tender.setId(getId());
		//tender.setCreateDate(tender.getCreateDate());
		mgr.update(tender);
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


	public List<Tender> getTenderLst() {
		return tenderLst;
	}
	
	


	public void setTenderLst(List<Tender> tenderLst) {
		this.tenderLst = tenderLst;
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
