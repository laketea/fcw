package com.auto.Builder;

public class ServiceImplBuilder extends BaseBuilder implements Builder {
	
	public ServiceImplBuilder(){
		tpl_name="ServiceImplTemplate";
		base_path="service/impl/";
	}
	
	public String getFileName(){
		return po.getClassName()+"ManagerImpl."+"java";
	}
	
	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", po.getClassName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());
		return str;
	}

}
