<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="downLoad!update.action?navTabId=downLoadList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${downLoad.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>资料ID：</label>
			<input type="text" name="downLoad.informationId" value="${downLoad.informationId}" class="required" size="30" />
		</p>
		<p>
			<label>资料名称：</label>
			<input type="text" name="downLoad.informationName" value="${downLoad.informationName}" class="required" size="30" />
		</p>
		<p>
			<label>用户ID：</label>
			<input type="text" name="downLoad.userId" value="${downLoad.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名称：</label>
			<input type="text" name="downLoad.userName" value="${downLoad.userName}" class="required" size="30" />
		</p>
		<p>
			<label>下载时间：</label>
			<input type="text" name="downLoad.downLoadTime" value="${downLoad.downLoadTime}" class="required" size="30" />
		</p>
		<p>
			<label>评分：</label>
			<input type="text" name="downLoad.score" value="${downLoad.score}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="downLoad.status" value="${downLoad.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>