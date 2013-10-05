<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="friend!update.action?navTabId=friendList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${friend.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>发送人ID：</label>
			<input type="text" name="friend.fromId" value="${friend.fromId}" class="required" size="30" />
		</p>
		<p>
			<label>发送人名称：</label>
			<input type="text" name="friend.fromName" value="${friend.fromName}" class="required" size="30" />
		</p>
		<p>
			<label>内容：</label>
			<input type="text" name="friend.content" value="${friend.content}" class="required" size="30" />
		</p>
		<p>
			<label>接收人ID：</label>
			<input type="text" name="friend.toId" value="${friend.toId}" class="required" size="30" />
		</p>
		<p>
			<label>接收人名称：</label>
			<input type="text" name="friend.toName" value="${friend.toName}" class="required" size="30" />
		</p>
		<p>
			<label>发送时间：</label>
			<input type="text" name="friend.sendTime" value="${friend.sendTime}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="friend.status" value="${friend.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>