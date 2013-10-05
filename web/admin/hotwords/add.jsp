<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="hotWords!add.action?navTabId=hotWordsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称:</label>
			<input type="text" name="hotWords.name" class="required" size="30" />
		</p>
		<p>
			<label>地址:</label>
			<input type="text" name="hotWords.url" class="required" size="30" />
		</p>
		<p>
			<label>排序:</label>
			<input type="text" name="hotWords.sortNum" class="required" value="0" size="30" />
		</p>
		
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>