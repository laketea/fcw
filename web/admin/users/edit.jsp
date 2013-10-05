<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="users!update.action?navTabId=usersList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${users.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>帐号名：</label>
			<input type="text" name="users.account" value="${users.account}" class="required" size="30" />
		</p>
		<p>
			<label>昵称：</label>
			<input type="text" name="users.nick" value="${users.nick}" class="required" size="30" />
		</p>
		<p>
			<label>邮箱：</label>
			<input type="text" name="users.email" value="${users.email}" class="required" size="30" />
		</p>
		<p>
			<label>密码：</label>
			<input type="text" name="users.password" value="${users.password}" class="required" size="30" />
		</p>
		<p>
			<label>申请时间：</label>
			<input type="text" name="users.apyTime" value="${users.apyTime}" class="required" size="30" />
		</p>
		<p>
			<label>用户类型：</label>
			<input type="text" name="users.userGroup" value="${users.userGroup}" class="required" size="30" />
		</p>
		<p>
			<label>是否通过验证：</label>
			<input type="text" name="users.status" value="${users.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>