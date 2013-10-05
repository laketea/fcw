<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="downLoad!add.action?navTabId=downLoadList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>资料ID:</label>
			<input type="text" name="downLoad.informationId" class="required" size="30" />
		</p>
		<p>
			<label>资料名称:</label>
			<input type="text" name="downLoad.informationName" class="required" size="30" />
		</p>
		<p>
			<label>用户ID:</label>
			<input type="text" name="downLoad.userId" class="required" size="30" />
		</p>
		<p>
			<label>用户名称:</label>
			<input type="text" name="downLoad.userName" class="required" size="30" />
		</p>
		<p>
			<label>下载时间:</label>
			<input type="text" name="downLoad.downLoadTime" class="required" size="30" />
		</p>
		<p>
			<label>评分:</label>
			<input type="text" name="downLoad.score" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="downLoad.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>