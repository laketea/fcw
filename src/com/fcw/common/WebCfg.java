package com.fcw.common;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 *  web设置类
 * @author yfcd
 */
public class WebCfg {
	
	private static Logger log = Logger.getLogger(WebCfg.class);

//    INSTANCE;
	public static WebCfg SITE_NAME = new WebCfg("site_name","站点名称");
	public static WebCfg SITE_URL = new WebCfg("site_url","网站地址");
	public static WebCfg RES_KEYWORD = new WebCfg("res_keyword","资源搜索关键字");
	public static WebCfg INFO_KEYWORD = new WebCfg("info_keyword","资料搜索关键字");
	public static WebCfg BUSINESS_KEYWORD = new WebCfg("business_keyword","招标搜索关键字");
	public static WebCfg NEWS_KEYWORD = new WebCfg("news_keyword","资讯搜索关键字");
	public static WebCfg SEARCH_HOT_WORD1 = new WebCfg("search_hot_word1","热门搜索关键字1");
	public static WebCfg SEARCH_HOT_WORD2 = new WebCfg("search_hot_word2","热门搜索关键字2");
	public static WebCfg SEARCH_HOT_WORD3 = new WebCfg("search_hot_word3","热门搜索关键字3");
	public static WebCfg SEARCH_HOT_WORD4 = new WebCfg("search_hot_word4","热门搜索关键字4");
	public static WebCfg[] CFGLST = {SITE_NAME,SITE_URL,RES_KEYWORD,INFO_KEYWORD,BUSINESS_KEYWORD,NEWS_KEYWORD,SEARCH_HOT_WORD1,SEARCH_HOT_WORD2,SEARCH_HOT_WORD3,SEARCH_HOT_WORD4};
	
	private static File file = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "/web-site-config.properties");
	
    private String name;
    
    private String cnName;
    
    private String value;
    
    private File defaultfile; 

    public static boolean stringNull(String val) {
        return val == null || "".equals(val) ? true : false;
    }
    
    private WebCfg(String name,String cnName){
    	this.name = name;
    	this.cnName = cnName;
    }

    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getValue() {
		if(value==null){
			value = getParam(name);
			log.info("读取配置:"+name+","+value);
		}
		return value;
	}

	public void setValue(String value) {
		if((this.value==null&&value!=null)||(this.value!=null&&value!=null&&!value.equals(this.value))){
			saveParam(name, value);
			log.info("保存配置:"+name+","+value);
		}
		this.value = value;
	}
	
	private static Properties loadp() {
        Properties pro = new Properties();
        try {
            if (file.exists()) {
                FileInputStream is = new FileInputStream(file);
                pro.load(is);
                is.close();
                is = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }

    public static String getParam(String name) {
        Properties pro = loadp();
        String value = pro.getProperty(name);
        return value==null?"":value;
    }

    public static String getParam(String name, String defaultvalue) {
        String val = getParam(name);
        return val == null ? defaultvalue : val;
    }

    public static void saveParam(String name, String value) {
        FileOutputStream os = null;
        try {
            Properties prop = loadp();
            prop.setProperty(name, value);
            os = new FileOutputStream(file);
            log.info("save fiel");
            log.info(file.getAbsolutePath());
            prop.store(os, "");
        } catch (Exception e) {
        	log.error("err:"+e.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.close();
                    os = null;
                } catch (Exception e) {
                }
            }
        }
    }
}