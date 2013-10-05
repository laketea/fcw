<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ page language="java" import="com.fcw.common.WebCfg" %>
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="webcfg!save.action?navTabId=webCfg&callbackType=" method="post" novalidate="novalidate">
		
	

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		
		<c:forEach var="item" items="${cfgLst}" varStatus="s">  
			<p style="width:100%">
			<label>${item.cnName}：</label>
			<input type="text" name="${item.name}" value="${item.value}" class="required" size="30" />
		</p>
		</c:forEach>
		<div style="padding-left:110px;margin-top:10px;float:left">
			<div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div>
				<div class="button" style="margin-left:10px"><div class="buttonContent"><button class="close" type="button">取消</button></div></div>
		</div>
		
	</div>
			
	<!-- <div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button" style="margin-left:20px"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div> -->
</form>