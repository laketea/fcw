package com.fcw.action.blog;

import com.fcw.action.front.BaseFrontAction;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.BlogGuest;
import com.fcw.domain.BlogInfo;
import com.fcw.domain.Information;
import com.fcw.domain.Record;
import com.fcw.domain.Users;
import com.fcw.service.BlogGuestManager;
import com.fcw.service.BlogInfoManager;
import com.fcw.service.InformationManager;
import com.fcw.service.RecordManager;
import com.fcw.service.ResourceManager;

public class RecordAction extends BaseFrontAction {
	
	public static String DFT_PHOTO ="../resource/img/testtest.jpg";
	
	protected RecordManager mgr;
	
	protected BlogInfoManager bmgr;
	
	private Record record ;
	
	private Page page;
	
	private Integer id; 
	
	private BlogInfo blog;
	
	public void setRecordManager(RecordManager mgr) {
		this.mgr = mgr;
	}
	
	public void setBlogInfoManager(BlogInfoManager mgr) {
		this.bmgr = mgr;
	}
	
	public String index(){
			
		blog = bmgr.get(id);
		record = new Record();
		fetchPageNum();
		record.setBlogId(id);
		page = mgr.findByPage(record, pageNum, perNum);
		
		return "index";
	}
	
	public void message(){
		
		Object obj =  getSession().getAttribute("user");
		if(obj==null){
			this.responseString("1");
			return ;
		}
		Users user = (Users)obj;
		
		if(user.getBlog()==null||user.getBlog()==0){
			this.responseString("2");
			return ;
		}
		
		if(user.getBlogInfo().getId()!=id){
			this.responseString("0");
			return ;
		}
		
		BlogInfo blog = user.getBlogInfo();
		String content = this.getParameter("content");
		Record record = new Record();
		record.setContent(content);
		record.setBlogId(blog.getId());
		record.setBlogName(blog.getUserName());
		
		mgr.add(record);
		this.responseString("3");
		return ;
	}

	
	
	
	

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public BlogInfo getBlog() {
		return blog;
	}

	public void setBlog(BlogInfo blog) {
		this.blog = blog;
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
