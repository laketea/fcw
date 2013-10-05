<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="newsChannel!update.action?navTabId=newsChannelList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${newsChannel.id}">
		<input type="hidden" name="newsChannel.newsCount" value="${newsChannel.newsCount}" />
		<input type="hidden" name="newsChannel.status" value="${newsChannel.status}"  />
		<input type="hidden" name="newsChannel.create_time" value="${newsChannel.create_time}"  />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>频道名称：</label>
			<input type="text" name="newsChannel.name" value="${newsChannel.name}" class="required" size="30" />
		</p>	
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>