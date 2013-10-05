<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<script src="../js/jquery-1.7.2.js" type="text/javascript"></script>
</head>
<script>
	 $(document).ready(function(){
	 	//alert("test");
	 	var result = $("#result").html();
	 	if(result!='上传失败!'){
	 		//alert(result);
	 		$(window.parent.document).find("#${eleId}").val(result);
	 	}
	 	$("#reSubmit").click(function(){
	 		$(window.parent.document).find("#${eleId}").val("");
	 	})
	 });	
</script>
<body>
<span id="result" style="font-size:12px">${result}</span>&nbsp;&nbsp;<a id="reSubmit" style="font-size:12px;" href="upload.html??eleId=${eleId}&path=${filepath}">[重新上传]</a>
</body>
</html>