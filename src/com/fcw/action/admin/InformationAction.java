package com.fcw.action.admin;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.fcw.common.Utils;
import com.fcw.common.WebSite;
import com.fcw.common.hibernate.Page;
import com.fcw.domain.InforChannel;
import com.fcw.domain.Information;
import com.fcw.domain.Resource;
import com.fcw.domain.ResourceChannel;
import com.fcw.domain.Users;
import com.fcw.service.InforChannelManager;
import com.fcw.service.InformationManager;

public class InformationAction extends BaseAction {

	protected InformationManager mgr;

	protected InforChannelManager channelmgr;

	public List<Information> informationLst;

	public List<InforChannel> channelLst;

	public Information information = new Information();

	private File myFile;
	
	private String myFileContentType; 
	
	private String myFileFileName; 

	public Integer id;

	public String ids;

	public void setInformationManager(InformationManager mgr) {
		this.mgr = mgr;
	}

	public void setInforChannelManager(InforChannelManager mgr) {
		this.channelmgr = mgr;
	}

	/*
	 * 资料列表
	 */
	public String list() {
		HashMap<Integer, InforChannel> map = channelmgr.findAllMap();
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		Page page = mgr.findByPage(information, pageNum, getNumPerPage());
		List<Information> ss = (List<Information>) page.getList();
		setInformationLst(ss);
		if (!Utils.listNull(ss)) {
			for (Information infor : ss) {
				if (map.containsKey(infor.getChannel_id())) {
					infor.setInforChannel(map.get(infor.getChannel_id()));
				}
			}
		}
		this.setTotalCount(page.getTotalRecords());
		return "list";
	}
	
	/*
	 * 资料列表
	 */
	public String exlist() {
		HashMap<Integer, InforChannel> map = channelmgr.findAllMap();
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		information.setExamine(-1);//待审核
		Page page = mgr.findByPage(information, pageNum, getNumPerPage());
		List<Information> ss = (List<Information>) page.getList();
		setInformationLst(ss);
		if (!Utils.listNull(ss)) {
			for (Information infor : ss) {
				if (map.containsKey(infor.getChannel_id())) {
					infor.setInforChannel(map.get(infor.getChannel_id()));
				}
			}
		}
		this.setTotalCount(page.getTotalRecords());
		return "exlist";
	}

	/*
	 * 删除资料
	 */
	public String delete() {
		mgr.delete(getId());
		return ajaxForwardSuccess("操作成功!");
	}
	
	/*
	 * 验证用户通过
	 */
	public String verity(){
		Information infor = mgr.get(getId());
		infor.setExamine(1);
		mgr.update(infor);
		return ajaxForwardSuccess("审核通过成功!");
	}

	/*
	 * 添加资料
	 */
	public String add() {
		channelLst = channelmgr.findAll();
		return "add";
	}

	public String save() {
		InforChannel chl = channelmgr.get(information.getChannelId());
		information.setInforChannel(chl);
		information.setChannel_id(information.getChannelId());
		information.setChannelName(chl.getName());
		String fileName = "";
		String ext ="";
		double fileSize = 0;
		try {
			File path = new File(ServletActionContext.getRequest().getRealPath("/temp"));
			fileSize = (double) myFile.length() /1024;
			if (!path.exists()) {
				path.mkdir();
			}	
			ext =Utils.getFileExtention(myFileFileName);
			fileName = UUID.randomUUID().toString() + "." + ext;
			Utils.copyFile(myFile, new File(ServletActionContext.getRequest().getRealPath("/temp") + File.separator + fileName));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		information.setFilePath(fileName);
		information.setFileType(ext);
		information.setFileSize(Utils.getFileSize(fileSize));
		mgr.add(information);
		return ajaxForwardSuccess("操作成功!");
	}

	/*
	 * 编辑资料
	 */
	public String edit() {
		channelLst = channelmgr.findFirstLevelChannel();
		information = mgr.get(getId());
		information.setInforChannel(channelmgr.get(information.getChannel_id()));
		return "edit";
	}

	/*
	 * 修改资料
	 */
	public String update() {
		Information adm = mgr.get(getId());
		information.setId(getId());
		information.setChannel_id(information.getChannelId());
		InforChannel chl = channelmgr.get(information.getChannelId());
		information.setInforChannel(chl);
		information.setChannelName(chl.getName());
		information.setUpTime(adm.getUpTime());
		mgr.update(information);
		return ajaxForwardSuccess("修改成功!");
	}

	/*
	 * 批量删除
	 */
	public String batch() {
		mgr.batchDelete(ids);
		return ajaxForwardSuccess("操作成功!");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Information> getInformationLst() {
		return informationLst;
	}

	public void setInformationLst(List<Information> informationLst) {
		this.informationLst = informationLst;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getIds() {
		return ids;
	}

	public List<InforChannel> getChannelLst() {
		return channelLst;
	}

	public void setChannelLst(List<InforChannel> channelLst) {
		this.channelLst = channelLst;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	
	
	public static void main(String[] args) {  
        DecimalFormat df = new DecimalFormat( "0 ");  
        double d1 = 2.1;  
        double d2 = 1.7345678;  
        System.out.println(df.format(d1));   
        System.out.println(df.format(d2));   
 }  
	
	
	

}
