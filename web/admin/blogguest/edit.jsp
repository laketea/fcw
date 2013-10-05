<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="blogGuest!update.action?navTabId=blogGuestList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${blogGuest.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID：</label>
			<input type="text" name="blogGuest.blogId" value="${blogGuest.blogId}" class="required" size="30" />
		</p>
		<p>
			<label>博客名称：</label>
			<input type="text" name="blogGuest.blogName" value="${blogGuest.blogName}" class="required" size="30" />
		</p>
		<p>
			<label>留言人ID：</label>
			<input type="text" name="blogGuest.guestId" value="${blogGuest.guestId}" class="required" size="30" />
		</p>
		<p>
			<label>留言人名称：</label>
			<input type="text" name="blogGuest.guestName" value="${blogGuest.guestName}" class="required" size="30" />
		</p>
		<p>
			<label>留言人头像：</label>
			<input type="text" name="blogGuest.guestPhoto" value="${blogGuest.guestPhoto}" class="required" size="30" />
		</p>
		<p>
			<label>留言时间：</label>
			<input type="text" name="blogGuest.guestTime" value="${blogGuest.guestTime}" class="required" size="30" />
		</p>
		<p>
			<label>留言标题：</label>
			<input type="text" name="blogGuest.title" value="${blogGuest.title}" class="required" size="30" />
		</p>
		<p>
			<label>留言内容：</label>
			<input type="text" name="blogGuest.content" value="${blogGuest.content}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="blogGuest.status" value="${blogGuest.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>