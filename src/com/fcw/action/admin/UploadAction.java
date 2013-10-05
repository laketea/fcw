package com.fcw.action.admin;


import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
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

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.fcw.common.Utils;


public class UploadAction extends BaseAction {

	private Logger log = Logger.getLogger(UploadAction.class);

	private File myFile;
	
	private String myFileContentType; 
	
	private String myFileFileName; 

	private String filepath="photo";
	
	private String result;
	
	private String eleId;


	public String upload() {
		log.info("开始上传!");
		String fileName = "";
		String ext ="";
		filepath = this.getParameter("filepath");
		eleId = this.getParameter("eleId");
		double fileSize = 0;
		HttpServletResponse response = this.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			File path = new File(ServletActionContext.getRequest().getRealPath("/"+filepath));
			fileSize = (double) myFile.length() /1024;
			if (!path.exists()) {
				path.mkdir();
			}	
			ext =Utils.getFileExtention(myFileFileName);
			fileName = UUID.randomUUID().toString() + "." + ext;
			Utils.copyFile(myFile, new File(ServletActionContext.getRequest().getRealPath("/"+filepath) + File.separator + fileName));
			result = filepath +"/" +fileName;
		} catch (Exception e) {
			log.error("上传失败错误 ："+e.getMessage());
			result = "上传失败!";
		}
		return "result";
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


	public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public String getEleId() {
		return eleId;
	}


	public void setEleId(String eleId) {
		this.eleId = eleId;
	}
	
	
	
	
	
	
	

	
	

 }  
	
	
