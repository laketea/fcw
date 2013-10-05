<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="blogInfo!update.action?navTabId=blogInfoList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${blogInfo.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>用户ID：</label>
			<input type="text" name="blogInfo.userId" value="${blogInfo.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名称：</label>
			<input type="text" name="blogInfo.userName" value="${blogInfo.userName}" class="required" size="30" />
		</p>
		<p>
			<label>博客唯一标识：</label>
			<input type="text" name="blogInfo.blogKey" value="${blogInfo.blogKey}" class="required" size="30" />
		</p>
		<p>
			<label>年龄：</label>
			<input type="text" name="blogInfo.age" value="${blogInfo.age}" class="required" size="30" />
		</p>
		<p>
			<label>性别：</label>
			<input type="text" name="blogInfo.male" value="${blogInfo.male}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="blogInfo.status" value="${blogInfo.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>