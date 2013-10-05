package com.auto.Builder;

import java.io.File;

public class SearchListJspBuilder extends BaseBuilder implements Builder {
	
	public SearchListJspBuilder(){
		base_path="action/";
		tpl_name="SearchListJspTemplate";
	}
	
	public String getFileName(){
		return "list.jsp";
	}
	
	private String getPropertiesDescription(){
		String str="";
		str+="";
		str+="<th width=\"22\"><input type=\"checkbox\" group=\"ids\" class=\"checkboxCtrl\"></th>";
		str+="\n\t\t\t\t";
		for(String[] pro:po.getProperty()){
			str+="<th>";
			str+=pro[2];
			str+="</th>\n\t\t\t\t";
		}
		str+="<th>编辑</th>\n\t\t\t\t";
		return str;
	}
	
	private String getPropertiesValue(){
		String str="";
		str+="<td>";
		str+="<input name=\"ids\" value=\"${item.id}\" type=\"checkbox\">";
		str+="</td>\n\t\t\t\t";
		for(String[] pro:po.getProperty()){
			str+="<td>";
			str+="${item."+pro[1]+"}";
			str+="</td>\n\t\t\t\t";
		}
		str+="<td>\n\t\t\t\t\t";
		str+="<a title=\"删除\" target=\"ajaxTodo\" href=\"${name}!delete.action?id=${item.id}\" class=\"btnDel\">删除</a>";
		str+="\n\t\t\t\t\t";
		str+="<a title=\"编辑\" target=\"dialog\" href=\"${name}!edit.action?id=${item.id}\" class=\"btnEdit\">编辑</a>\n\t\t\t\t";
		str+="</td>\n\t\t\t\t";
		return str;
	}	

	public String toString(){
		String str= this.getTemplateString();
		
		str = str.replace("${properties_descirption}", this.getPropertiesDescription());
		str = str.replace("${properties_value}", this.getPropertiesValue());
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
