<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="tenderGuest!add.action?navTabId=tenderGuestList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>招标项目ID:</label>
			<input type="text" name="tenderGuest.tenderId" class="required" size="30" />
		</p>
		<p>
			<label>招标项目名称:</label>
			<input type="text" name="tenderGuest.tenderName" class="required" size="30" />
		</p>
		<p>
			<label>用户ID:</label>
			<input type="text" name="tenderGuest.userId" class="required" size="30" />
		</p>
		<p>
			<label>用户名称:</label>
			<input type="text" name="tenderGuest.userName" class="required" size="30" />
		</p>
		<p>
			<label>投标人:</label>
			<input type="text" name="tenderGuest.contact" class="required" size="30" />
		</p>
		<p>
			<label>投标公司:</label>
			<input type="text" name="tenderGuest.company" class="required" size="30" />
		</p>
		<p>
			<label>联系电话:</label>
			<input type="text" name="tenderGuest.phone" class="required" size="30" />
		</p>
		<p>
			<label>联系邮箱:</label>
			<input type="text" name="tenderGuest.email" class="required" size="30" />
		</p>
		<p>
			<label>描述:</label>
			<input type="text" name="tenderGuest.description" class="required" size="30" />
		</p>
		<p>
			<label>留言时间:</label>
			<input type="text" name="tenderGuest.guestTime" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="tenderGuest.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>