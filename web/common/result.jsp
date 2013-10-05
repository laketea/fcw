<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GBK"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link type="text/css" rel="stylesheet" href="../resource/css/common.css"/>
<title>test</title>
<script src="../resource/js/jquery.js" type="text/javascript"></script>
</head>
<script>
	 $(document).ready(function(){
	 	var result = $("#result").val();
	 	if(result!='上传失败!'){
	 		$(window.parent.document).find("#${eleId}").val(result);
	 		$(window.parent.document).find("#img-${eleId}").attr("src","../"+result);
	 	}
	 	$("#reSubmit").click(function(){
	 		$(window.parent.document).find("#${eleId}").val("");
	 	})
	 });	
</script>
<body>
<input type="hidden" id="result" value="${result}">
<a id="reSubmit" style="font-size:12px;" href="upload.html?eleId=${eleId}&path=${filepath}">[重新上传]</a>
</body>
</html>