
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.AdvUtil;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Adv;
import com.fcw.service.AdvManager;


public class AdvAction extends BaseAction {
	
	protected AdvManager mgr;
	
	public List<Adv> advLst ;
	
	public Adv adv;
	
	public Integer id;
	
	public String ids;
	
	private AdvUtil[] advArr;

	public void setAdvManager(AdvManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 广告列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getAdv(),pageNum, getNumPerPage());
		List<Adv> ss =(List<Adv>)page.getList();
		setAdvLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除广告
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 保存广告
	 */
	public String save(){
		mgr.add(getAdv());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加广告
	 */
	public String add(){
		advArr = AdvUtil.advCfgLst;
		return "add";
	}
	
	/*
	 * 编辑广告
	 */
	public String edit(){
		 adv = mgr.get(getId());
		 advArr = AdvUtil.advCfgLst;
		return "edit";
	}
	
	/*
	 * 修改广告
	 */
	public String update(){
		Adv adm = mgr.get(getId());
		adv.setId(getId());
		//adv.setCreateDate(adv.getCreateDate());
		mgr.update(adv);
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


	public List<Adv> getAdvLst() {
		return advLst;
	}
	
	


	public void setAdvLst(List<Adv> advLst) {
		this.advLst = advLst;
	}

	public Adv getAdv() {
		return adv;
	}

	public void setAdv(Adv adv) {
		this.adv = adv;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public AdvUtil[] getAdvArr() {
		return advArr;
	}

	public void setAdvArr(AdvUtil[] advArr) {
		this.advArr = advArr;
	}
	
	
	
	
	
	

}
