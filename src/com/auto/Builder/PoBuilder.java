package com.auto.Builder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PoBuilder extends BaseBuilder implements Builder  {

	public static String BASE_PATH="domain/";
	
	public static String TPL_NAME="PoTemplate";
	
	public String _path = "domain";

	public String _package = "package com.fcw." + _path + ";";

	public String _import = "import java.io.Serializable;\nimport java.sql.Date;";
	
	public PoBuilder(){
		base_path="domain/";
		tpl_name="PoTemplate";
	}

	public String getDesption() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format((new Date()));
		String str = "";
		str += "/**\n";
		str += " * @Author zhangwei \n";
		str += " * @Email  laketea@163.com \n";
		str += " * @Time   ${time}\n";
		str += " */";
		str = str.replace("${time}", time);
		return str;
	}

	public String _class() {
		return "public class " + po.getClassName() + "\n\t" + "implements Serializable \n{";
	}

	public String getProperty() {
		String str = "\n";
		for (String[] pro : this.po.getProperty()) {
			str += "\tprivate " + pro[0] + " " + pro[1] + "; " + " //" + pro[2] + "\n\n";
		}
		return str;
	}

	public String getDefaultClass() {
		String str = "";
		str += "\tpublic " + po.getClassName() + "(){";
		str += "\n\n\t";
		str += "}";
		return str;
	}

	public String getProMethod(){ 
		String str = "\n";
		for (String[] pro : this.po.getProperty()) {
			str += "\tpublic " + pro[0] + " " + firstUp(pro[1], true) + "() {";
			str += "\n\t\t";
			str += "return " + pro[1] + ";";
			str += "\n\t";
			str += "}";
			str += "\n\n";
			str += "\tpublic void " + firstUp(pro[1], false) + "(" + pro[0] + " " + pro[1] + ") {";
			str += "\n\t\t";
			str += "this." + pro[1] + " = " + pro[1] + ";";
			str += "\n\t";
			str += "}";
			str += "\n\n";
		}
		return str;
	}


	public String toString() {
		String code= getTemplateString();
		code=code.replace("${package}", _package);
		code=code.replace("${import}", _import);
		code=code.replace("${Description}", getDesption());
		code=code.replace("${name}", po.getClassName());
		code=code.replace("${properties}", getProperty());
		code=code.replace("${proMethod}", getProMethod());
		return code;
	}
	
	public String firstUp(String str, boolean gs) {
		String f = str.substring(0, 1);
		String before = gs ? "get" : "set";
		return before + f.toUpperCase() + str.substring(1);
	}

}
