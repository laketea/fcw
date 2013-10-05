
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.DownLoad;
import com.fcw.service.DownLoadManager;


public class DownLoadAction extends BaseAction {
	
	protected DownLoadManager mgr;
	
	public List<DownLoad> downLoadLst ;
	
	public DownLoad downLoad;
	
	public Integer id;
	
	public String ids;

	public void setDownLoadManager(DownLoadManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 资料下载信息列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getDownLoad(),pageNum, getNumPerPage());
		List<DownLoad> ss =(List<DownLoad>)page.getList();
		setDownLoadLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除资料下载信息
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加资料下载信息
	 */
	public String add(){
		mgr.add(getDownLoad());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑资料下载信息
	 */
	public String edit(){
		 downLoad = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改资料下载信息
	 */
	public String update(){
		DownLoad adm = mgr.get(getId());
		downLoad.setId(getId());
		//downLoad.setCreateDate(downLoad.getCreateDate());
		mgr.update(downLoad);
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


	public List<DownLoad> getDownLoadLst() {
		return downLoadLst;
	}
	
	


	public void setDownLoadLst(List<DownLoad> downLoadLst) {
		this.downLoadLst = downLoadLst;
	}

	public DownLoad getDownLoad() {
		return downLoad;
	}

	public void setDownLoad(DownLoad downLoad) {
		this.downLoad = downLoad;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
