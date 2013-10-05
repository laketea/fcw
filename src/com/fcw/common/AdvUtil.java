package com.fcw.common;

public class AdvUtil {
	
	public static AdvUtil DFT_BANNER = new AdvUtil("首页广告",1,"960","80");
	
	public static AdvUtil[] advCfgLst ={DFT_BANNER};
	
	public AdvUtil(String name,Integer id,String width,String height){
		this.name = name;
		this.id = id;
		this.width = width;
		this.height = height;
	}
	
	private String name;
	
	private Integer id;
	
	private String width;
	
	private String height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	

}
