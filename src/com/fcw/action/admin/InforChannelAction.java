
package com.fcw.action.admin; 

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fcw.common.Utils;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.service.InforChannelManager;


public class InforChannelAction extends BaseAction {
	
	protected InforChannelManager mgr;
	
	public List<InforChannel> inforChannelLst ;
	
	public List<InforChannel> firstLevelChannelLst ;
	
	public InforChannel inforChannel;
	
	public InforChannel pChannel;
	
	public Integer id;
	
	public String ids;

	public void setInforChannelManager(InforChannelManager mgr)
	{
		this.mgr = mgr;
	}
	
	/*
	 * 资料分类列表
	 */
	public String list(){
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		inforChannel = inforChannel==null?new InforChannel():inforChannel;
		inforChannel.setStatus(0);
		Page page = mgr.findByPage(inforChannel,pageNum, getNumPerPage());
		List<InforChannel> ss =(List<InforChannel>)page.getList();
		setInforChannelLst(ss);
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 删除资料分类
	 */
	public String delete(){
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 添加资料分类
	 */
	public String save(){
		if(inforChannel!=null){
			if(inforChannel.getParentId()>0){//如果父id不为0则 为二级目录
				inforChannel.setParentChannel(mgr.get(getInforChannel().getParentId()));
				inforChannel.setStatus(1);
			}else{
				inforChannel.setStatus(0);//否则则为一级节点
			}
			if(inforChannel.getSortNum()==null){
				inforChannel.setSortNum(0);
			}
			mgr.add(inforChannel);
		}
		return ajaxForwardSuccess("操作成功!");
	}
	
	public String add(){
		firstLevelChannelLst = mgr.findFirstLevelChannel();
		return "add";
	}
	
	/*
	 * 编辑资料分类
	 */
	public String edit(){
		 inforChannel = mgr.get(getId());
		return "edit";
	}
	
	/*
	 * 修改资料分类
	 */
	public String update(){
		InforChannel adm = mgr.get(getId());
		adm.setName(inforChannel.getName());
		adm.setSortNum(inforChannel.getSortNum());
		mgr.update(adm);
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


	public List<InforChannel> getInforChannelLst() {
		return inforChannelLst;
	}
	
	


	public void setInforChannelLst(List<InforChannel> inforChannelLst) {
		this.inforChannelLst = inforChannelLst;
	}

	public InforChannel getInforChannel() {
		return inforChannel;
	}

	public void setInforChannel(InforChannel inforChannel) {
		this.inforChannel = inforChannel;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<InforChannel> getFirstLevelChannelLst() {
		return firstLevelChannelLst;
	}

	public void setFirstLevelChannelLst(List<InforChannel> firstLevelChannelLst) {
		this.firstLevelChannelLst = firstLevelChannelLst;
	}

	public InforChannel getpChannel() {
		return pChannel;
	}

	public void setpChannel(InforChannel pChannel) {
		this.pChannel = pChannel;
	}
	
	
	
	
	
	
	
	
	

}
