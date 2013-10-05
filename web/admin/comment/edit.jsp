<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="comment!update.action?navTabId=commentList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${comment.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>标题：</label>
			<input type="text" name="comment.title" value="${comment.title}" class="required" size="30" />
		</p>
		<p>
			<label>内容：</label>
			<input type="text" name="comment.content" value="${comment.content}" class="required" size="30" />
		</p>
		<p>
			<label>用户ID：</label>
			<input type="text" name="comment.userId" value="${comment.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名：</label>
			<input type="text" name="comment.userName" value="${comment.userName}" class="required" size="30" />
		</p>
		<p>
			<label>发布时间：</label>
			<input type="text" name="comment.pbTime" value="${comment.pbTime}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="comment.status" value="${comment.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>