<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="tenderGuest!update.action?navTabId=tenderGuestList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${tenderGuest.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>招标项目ID：</label>
			<input type="text" name="tenderGuest.tenderId" value="${tenderGuest.tenderId}" class="required" size="30" />
		</p>
		<p>
			<label>招标项目名称：</label>
			<input type="text" name="tenderGuest.tenderName" value="${tenderGuest.tenderName}" class="required" size="30" />
		</p>
		<p>
			<label>用户ID：</label>
			<input type="text" name="tenderGuest.userId" value="${tenderGuest.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名称：</label>
			<input type="text" name="tenderGuest.userName" value="${tenderGuest.userName}" class="required" size="30" />
		</p>
		<p>
			<label>投标人：</label>
			<input type="text" name="tenderGuest.contact" value="${tenderGuest.contact}" class="required" size="30" />
		</p>
		<p>
			<label>投标公司：</label>
			<input type="text" name="tenderGuest.company" value="${tenderGuest.company}" class="required" size="30" />
		</p>
		<p>
			<label>联系电话：</label>
			<input type="text" name="tenderGuest.phone" value="${tenderGuest.phone}" class="required" size="30" />
		</p>
		<p>
			<label>联系邮箱：</label>
			<input type="text" name="tenderGuest.email" value="${tenderGuest.email}" class="required" size="30" />
		</p>
		<p>
			<label>描述：</label>
			<input type="text" name="tenderGuest.description" value="${tenderGuest.description}" class="required" size="30" />
		</p>
		<p>
			<label>留言时间：</label>
			<input type="text" name="tenderGuest.guestTime" value="${tenderGuest.guestTime}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="tenderGuest.status" value="${tenderGuest.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>