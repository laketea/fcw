
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Slide;
import com.fcw.service.SlideManager;


public class SlideAction extends BaseAction {
	
	protected SlideManager mgr;
	
	public List<Slide> slideLst ;
	
	public Slide slide;
	
	public Integer id;
	
	public String ids;

	public void setSlideManager(SlideManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 幻灯片列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getSlide(),pageNum, getNumPerPage());
		List<Slide> ss =(List<Slide>)page.getList();
		setSlideLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除幻灯片
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加幻灯片
	 */
	public String add(){
		slide.setStatus(0);
		mgr.add(getSlide());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑幻灯片
	 */
	public String edit(){
		 slide = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改幻灯片
	 */
	public String update(){
		Slide adm = mgr.get(getId());
		slide.setId(getId());
		//slide.setCreateDate(slide.getCreateDate());
		mgr.update(slide);
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


	public List<Slide> getSlideLst() {
		return slideLst;
	}
	
	


	public void setSlideLst(List<Slide> slideLst) {
		this.slideLst = slideLst;
	}

	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
