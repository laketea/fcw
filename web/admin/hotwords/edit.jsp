<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="hotWords!update.action?navTabId=hotWordsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${hotWords.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称：</label>
			<input type="text" name="hotWords.name" value="${hotWords.name}" class="required" size="30" />
		</p>
		<p>
			<label>地址：</label>
			<input type="text" name="hotWords.url" value="${hotWords.url}" class="required" size="30" />
		</p>
		<p>
			<label>排序：</label>
			<input type="text" name="hotWords.sortNum" value="${hotWords.sortNum}" class="required" size="30" />
		</p>
		
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>