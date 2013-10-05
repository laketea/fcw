<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="record!update.action?navTabId=recordList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${record.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID：</label>
			<input type="text" name="record.blogId" value="${record.blogId}" class="required" size="30" />
		</p>
		<p>
			<label>博客名称：</label>
			<input type="text" name="record.blogName" value="${record.blogName}" class="required" size="30" />
		</p>
		<p>
			<label>内容：</label>
			<input type="text" name="record.content" value="${record.content}" class="required" size="30" />
		</p>
		<p>
			<label>发布时间：</label>
			<input type="text" name="record.pbTime" value="${record.pbTime}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="record.status" value="${record.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>