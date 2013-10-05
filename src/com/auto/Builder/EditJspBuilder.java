package com.auto.Builder;

import java.io.File;

public class EditJspBuilder extends BaseBuilder implements Builder {
	
	public EditJspBuilder(){
		base_path="action/";
		tpl_name="EditJspTemplate";
	}
	
	public String getFileName(){
		return "edit.jsp";
	}
	
	public String getPropertyesInput(){
		String str="";
		for(String[] pro:po.getProperty()){
			if("id".equals(pro[1])){
				continue;
			}
			str+="<p>\n\t\t\t";
			str+="<label>"+pro[2]+"：</label>";
			str+="\n\t\t\t";
			str+="<input type=\"text\" name=\"${name}."+pro[1]+"\" value=\"${${name}."+pro[1]+"}\" class=\"required\" size=\"30\" />";
			str+="\n\t\t";
			str+="</p>";
			str+="\n\t\t";
		}
		return str;
	}
	

	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${properties_input}", this.getPropertyesInput());
		str = str.replace("${name}", this.getFirstLowClassName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());	
		return str;	
	}
	
	public String getFilePath(){
		File file = new File("");
		String parent=file.getAbsolutePath()+"/WebRoot/admin/"+po.getClassName().toLowerCase();
		File pFile = new File(parent);
		if(!pFile.exists()){
			pFile.mkdir();
		}
		return parent+"/"+getFileName();
	}

}
