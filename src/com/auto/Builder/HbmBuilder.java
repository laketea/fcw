package com.auto.Builder;

import com.auto.business.Po;

public class HbmBuilder extends BaseBuilder implements Builder {
	
	
	public HbmBuilder(){
		base_path="domain/";
		tpl_name="HbmTemplate";
	}

	public String getPropertyColumn(){
		if(this.po.getProperty().isEmpty()){
			return"";
		}
		String str="<!-- 映射普通属性 -->\n";	
		for (String[] pro : this.po.getProperty()){
			if(pro[1].toLowerCase().equals("id")){
				continue;
			}
			str+="\t\t";
			str+="<property name=\""+pro[1]+"\" column=\""+pro[1]+"\" type=\""+pro[0].toLowerCase()+"\" length=\"50\"/>";
			str+="\n";
		}
		return str;
	}
	
	public String toString() {
		String code= getTemplateString();
		code=code.replace("${name}", po.getClassName());
		code=code.replace("${property_column}", getPropertyColumn());
		return code;
	}
	
	public String getFileName(){
		return po.getClassName()+".hbm.xml";
	}
	
	
	
}
