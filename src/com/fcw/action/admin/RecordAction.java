
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Record;
import com.fcw.service.RecordManager;


public class RecordAction extends BaseAction {
	
	protected RecordManager mgr;
	
	public List<Record> recordLst ;
	
	public Record record;
	
	public Integer id;
	
	public String ids;

	public void setRecordManager(RecordManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 记录列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getRecord(),pageNum, getNumPerPage());
		List<Record> ss =(List<Record>)page.getList();
		setRecordLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除记录
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加记录
	 */
	public String add(){
		mgr.add(getRecord());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑记录
	 */
	public String edit(){
		 record = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改记录
	 */
	public String update(){
		Record adm = mgr.get(getId());
		record.setId(getId());
		//record.setCreateDate(record.getCreateDate());
		mgr.update(record);
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


	public List<Record> getRecordLst() {
		return recordLst;
	}
	
	


	public void setRecordLst(List<Record> recordLst) {
		this.recordLst = recordLst;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
