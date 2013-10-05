package com.fcw.common;

import java.io.BufferedInputStream;
import org.apache.log4j.Logger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Utils {
	
	private static Logger log = Logger.getLogger(Utils.class);

	public static boolean notNull(String str) {
		if (str != null && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 字符串null或空串
	 */
	public static boolean nullBlank(String str) {
		if (str == null || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * list是否为空
	 */
	public static boolean listNull(List lst) {
		return lst == null || lst.isEmpty() ? true : false;
	}

	/*
	 * lst初始化
	 */
	public static List listInit(List lst) {
		lst = lst == null ? new ArrayList() : lst;
		return lst;
	}

	/*
	 * 获取文件名后缀
	 */
	public static String getFileExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos + 1);
	}

	/*
	 * 保存文件
	 */
	public static void copyFile(File file, File destFile) throws Exception {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file), 16384);
			out = new BufferedOutputStream(new FileOutputStream(destFile), 16384);
			byte buffer[] = new byte[16384];
			while (in.read(buffer) > 0) {
				out.write(buffer);
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();

		}
		log.info("文件上传地址为:"+destFile.getAbsolutePath());

	}
	
	/*
	 * 根据double获取文件大小的描述
	 */
	public static String getFileSize(double db){
		String size ="";
		if(db<1024){
			DecimalFormat df = new DecimalFormat( "0 ");  
			size= df.format(db)+" KB";
		}else{
			db =db/1024;
			DecimalFormat df = new DecimalFormat( "0.0");  
			size= df.format(db)+" MB";
		}
		return size;
	}

	
	public static String getTemplateString(String fileName) {
		File file = new File("");
		String path = file.getAbsolutePath() + "/src/com/auto/template/" + fileName + ".txt";

		InputStream is = null;
		String ret = null;
		try {
			File f = new File(path);
			is = new FileInputStream(f);
			long contentLength = f.length();
			byte[] ba = new byte[(int) contentLength];
			is.read(ba);
			ret = new String(ba, "utf-8");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public static String getRandomChar() {
		int index = (int) Math.round(Math.random() * 2);
		String randChar = "";
		switch (index) {
		case 0:// 大写字符
			randChar = String.valueOf((char) Math.round(Math.random() * 25 + 65));
			break;
		case 1:// 小写字符
			randChar = String.valueOf((char) Math.round(Math.random() * 25 + 97));
			break;
		default:// 数字
			randChar = String.valueOf(Math.round(Math.random() * 9));
			break;
		}
		return randChar;
	}

	public static String getRandomStr() {
		String str = "";
		for (int i = 0; i < 8; i++) {
			str += getRandomChar();
		}
		return str;
	}
	
	public static String dateFormat(String oldTime){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date =  sdf.parse(oldTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--"+sdf.format(date));
		return sdf.format(date);
	}
	

	
	
	
	
	
	
	
	
}
