package com.auto.Builder;

public class ActionBuilder extends BaseBuilder implements Builder {
	
	
	public ActionBuilder(){
		base_path="action/admin/";
		tpl_name="ActionTemplate";
	}
	
	public String getFileName(){
		return po.getClassName()+"Action."+"java";
	}

	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", po.getClassName());
		str = str.replace("${cnname}", po.getClassCnName());
		str = str.replace("${name.Low}", this.getFirstLowClassName());	
		return str;	
	}
}
