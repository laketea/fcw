package com.auto.Builder;

public class DaoBuilder extends BaseBuilder implements Builder {
	
	
	public DaoBuilder(){
		base_path="dao/";
		tpl_name="DaoTemplate";
	}
	
	public String getFileName(){
		return po.getClassName()+"Dao."+"java";
	}

	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", po.getClassName());
		str = str.replace("${cnname}", po.getClassCnName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());	
		return str;	
	}
	
}
