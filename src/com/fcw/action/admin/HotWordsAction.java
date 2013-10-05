
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.HotWords;
import com.fcw.service.HotWordsManager;


public class HotWordsAction extends BaseAction {
	
	protected HotWordsManager mgr;
	
	public List<HotWords> hotWordsLst ;
	
	public HotWords hotWords;
	
	public Integer id;
	
	public String ids;

	public void setHotWordsManager(HotWordsManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 热门搜索列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(getHotWords(),pageNum, getNumPerPage());
		List<HotWords> ss =(List<HotWords>)page.getList();
		setHotWordsLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除热门搜索
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加热门搜索
	 */
	public String add(){
		mgr.add(getHotWords());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 编辑热门搜索
	 */
	public String edit(){
		 hotWords = mgr.get(getId());	
		return "edit";
	}
	
	/*
	 * 修改热门搜索
	 */
	public String update(){
		HotWords adm = mgr.get(getId());
		hotWords.setId(getId());
		hotWords.setCreateTime(adm.getCreateTime());
		mgr.update(hotWords);
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


	public List<HotWords> getHotWordsLst() {
		return hotWordsLst;
	}
	
	


	public void setHotWordsLst(List<HotWords> hotWordsLst) {
		this.hotWordsLst = hotWordsLst;
	}

	public HotWords getHotWords() {
		return hotWords;
	}

	public void setHotWords(HotWords hotWords) {
		this.hotWords = hotWords;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	

}
