package com.auto.Builder;

import java.io.File;

public class ListJspBuilder extends BaseBuilder implements Builder {
	
	public ListJspBuilder(){
		base_path="action/";
		tpl_name="ListJspTemplate";
	}
	
	public String getFileName(){
		return "list.jsp";
	}
	
	private String getPropertiesDescription(){
		String str="";
		for(String[] pro:po.getProperty()){
			str+="<th>";
			str+=pro[2];
			str+="</th>\n\t\t\t\t";
		}
		return str;
	}
	
	private String getPropertiesValue(){
		String str="";
		for(String[] pro:po.getProperty()){
			str+="<td>";
			str+="${item."+pro[1]+"}";
			str+="</td>\n\t\t\t\t";
		}
		return str;
	}	

	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", this.getFirstLowClassName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());
		str = str.replace("${properties_descirption}", this.getPropertiesDescription());
		str = str.replace("${properties_value}", this.getPropertiesValue());
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
