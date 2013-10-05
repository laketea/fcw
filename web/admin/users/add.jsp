<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="users!add.action?navTabId=usersList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>帐号名:</label>
			<input type="text" name="users.account" class="required" size="30" />
		</p>
		<p>
			<label>昵称:</label>
			<input type="text" name="users.nick" class="required" size="30" />
		</p>
		<p>
			<label>邮箱:</label>
			<input type="text" name="users.email" class="required" size="30" />
		</p>
		<p>
			<label>密码:</label>
			<input type="text" name="users.password" class="required" size="30" />
		</p>
		<p>
			<label>申请时间:</label>
			<input type="text" name="users.apyTime" class="required" size="30" />
		</p>
		<p>
			<label>用户类型:</label>
			<input type="text" name="users.userGroup" class="required" size="30" />
		</p>
		<p>
			<label>是否通过验证:</label>
			<input type="text" name="users.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>