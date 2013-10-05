package com.fcw.action.usercenter;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.Record;
import com.fcw.domain.Users;
import com.fcw.service.RecordManager;

public class UserRecordAction extends BaseFrontAction {

	protected RecordManager mgr;

	private Record record;

	private Page page;

	private Integer id;

	private Integer flag = 0;

	public void setRecordManager(RecordManager mgr) {
		this.mgr = mgr;
	}

	public String record() {

		fetchPageNum();
		
		
		Object obj =  getSession().getAttribute("user");
		Users user = (Users)obj;
		id = user.getBlogInfo().getId();

		System.out.println("blogId is:"+id);
		if (flag == 0) {
			page = mgr.findFriendsRecordPage(id, pageNum, perNum);
		}
		if (flag == 1) {
			record = new Record();
			record.setBlogId(id);
			page = mgr.findByPage(record, pageNum, perNum);
		}

		if (flag == 2) {
			page = mgr.findByPage(record, pageNum, perNum);
		}

		return "record";
	}
	
	

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
