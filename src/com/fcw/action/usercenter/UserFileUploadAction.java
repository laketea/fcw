package com.fcw.action.usercenter;

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

import com.fcw.action.front.BaseFrontAction;
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

public class UserFileUploadAction extends BaseFrontAction {

	protected InformationManager mgr;

	protected InforChannelManager channelmgr;

	public List<Information> informationLst;

	public List<InforChannel> channelLst;

	public Information info = new Information();

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

	public String upload() {
		Users user= (Users)getSession().getAttribute("user");
		info.setUserId(user.getId());
		info.setUserName(user.getNick());
		InforChannel chl = channelmgr.get(info.getChannelId());
		info.setInforChannel(chl);
		info.setChannel_id(info.getChannelId());
		info.setChannelName(chl.getName());
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
		info.setFilePath(fileName);
		info.setFileType(ext);
		info.setFileSize(Utils.getFileSize(fileSize));
		mgr.add(info);
		return "sucessed";
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

	public Information getInfo() {
		return info;
	}

	public void setInfo(Information information) {
		this.info = information;
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
	
	

	
	
	

}
