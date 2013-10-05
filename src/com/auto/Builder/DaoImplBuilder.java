package com.auto.Builder;

public class DaoImplBuilder extends BaseBuilder implements Builder {
	
	public DaoImplBuilder(){
		base_path="dao/impl/";
		tpl_name="DaoImplTemplate";
	}
	
	public String getFileName(){
		return po.getClassName()+"DaoHibernate."+"java";
	}

	public String toString(){
		String str= this.getTemplateString();
		str = str.replace("${name}", po.getClassName());
		str = str.replace("${cnname}", po.getClassCnName());
		str = str.replace("${name.Low}", po.getClassName().toLowerCase());	
		return str;	
	}

}
