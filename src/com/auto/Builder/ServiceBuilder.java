package com.auto.Builder;

public class ServiceBuilder extends BaseBuilder implements Builder {
	
	public ServiceBuilder(){
		tpl_name="ServiceTemplate";
		base_path="service/";
	}
	
	public String getFileName(){
		return po.getClassName()+"Manager."+"java";
	}
	
	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", po.getClassName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());
		return str;
	}

}
