package com.auto.Builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.auto.business.Po;
import com.auto.common.Utils;

public class BaseBuilder {
	
	public Po po = new Po();
	public  String tpl_name="Template";
	public  String base_path ="";  

	/*
	 * 获取模板数据string
	 */
	public String getTemplateString(){
		return Utils.getTemplateString(tpl_name);
	}
		
	/*
	 * 模板替换后的string
	 */
	public String toString() {
		return getTemplateString();
	}
	
	/*
	 * 设置文件名
	 */
	public String getFileName(){
		return po.getClassName()+".java";
	}

	/*
	 * 打印替换后的string
	 */
	public void print() {
		System.out.println(toString());
	}

	/*
	 * 生成文件
	 */
	public void printFile(Po po) {
		this.po = po;
		FileOutputStream fos =null;
		try {  
             fos = new FileOutputStream(getFilePath());  
//             fos.write((toString()).getBytes("GBK"));  
             OutputStreamWriter write = new OutputStreamWriter(fos,"UTF-8");
             BufferedWriter writer=new BufferedWriter(write);   
             //PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePathAndName)));
             //PrintWriter writer = new PrintWriter(new FileWriter(filePathAndName));
             writer.write(toString());
             writer.close();
             System.out.println("文件:"+getFilePath()+"生成成功!");
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{
        	try {
        		fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
	}
	
	/*
	 * 获取路径
	 */
	public String getFilePath(){
		File file = new File("");
		return file.getAbsolutePath()+"/src/com/fcw/"+base_path+getFileName();
	}
	
	public String getFirstLowClassName(){
		String f = po.getClassName().substring(0,1).toLowerCase();
		return f+po.getClassName().substring(1);
	}

}
