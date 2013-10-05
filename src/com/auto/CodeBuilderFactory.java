package com.auto;

import java.util.ArrayList;
import java.util.List;

import com.auto.Builder.*;
import com.auto.business.Po;

/**
 * 代码生成工具
 * @author Administrator
 *
 */
public class CodeBuilderFactory {
	
	private List<Po> poLst = new ArrayList<Po>() ;
	
	private List<Builder> tplLst = new ArrayList<Builder>() ;
	
	private static Builder _po = new PoBuilder();
	private static Builder _hbm = new HbmBuilder();
	private static Builder _dao = new DaoBuilder();
	private static Builder _daoImpl = new DaoImplBuilder();
	private static Builder _service = new ServiceBuilder();
	private static Builder _serviceImpl = new ServiceImplBuilder();
	private static Builder _action = new ActionBuilder();
	private static Builder _addJsp = new AddJspBuilder();
	private static Builder _listJsp = new ListJspBuilder();
	private static Builder _searchListJsp = new SearchListJspBuilder();
	private static Builder _editJsp = new EditJspBuilder();
	
	public CodeBuilderFactory(){
		
	}
	
	public void  addPo(Po obj){
		this.poLst.add(obj);
	}
	
	public void registerTpl(Builder tpl){
		this.tplLst.add(tpl);
	}
	
	public void setPoLst( List<Po> lst){
		this.poLst = lst;	
	}
	
	public void setDefaultBuilderLst(){
		 List<Builder> lst = new ArrayList<Builder>();
		 lst.add(_po);
		 lst.add(_hbm);
		 lst.add(_dao);
		 lst.add(_daoImpl);
		 lst.add(_service);
		 lst.add(_serviceImpl);
		 lst.add(_action);
		 lst.add(_addJsp);
		 lst.add(_searchListJsp);
		 lst.add(_editJsp);
		 this.tplLst = lst;
	}
	
	public void setEditAddBuilderLst(){
		 List<Builder> lst = new ArrayList<Builder>();
		 lst.add(_addJsp);
		 lst.add(_editJsp);
		 this.tplLst = lst;
	}
	
	public void setSearchBuilderLst(){
		 List<Builder> lst = new ArrayList<Builder>();
		 lst.add(_po);
		 lst.add(_hbm);
		 lst.add(_dao);
		 lst.add(_daoImpl);
		 lst.add(_service);
		 lst.add(_serviceImpl);
		 lst.add(_action);
		 lst.add(_addJsp);
		 lst.add(_searchListJsp);
		 lst.add(_editJsp);
		 this.tplLst = lst;
	}
	
	public void produceXml(){
		
		
	}
	
	/*
	 * 代码生成器start
	 */
	public void produceFiles(){
		if(poLst.isEmpty()||tplLst.isEmpty()){
			return;
		}
		
		for(Po obj:poLst){
			System.out.println(">>>>>>业务:"+obj.getClassCnName()+"("+obj.getClassName()+") ,代码生成开始!--->>>>>>>>>>>>>>");
			for(Builder tpl:tplLst){
				tpl.printFile(obj);
			}
			System.out.println(">>>>>>业务:"+obj.getClassCnName()+"("+obj.getClassName()+") ,代码生成结束!--->>>>>>>>>>>>>>");
		}
		
		
	}
	
	
	
	
	
	

}
