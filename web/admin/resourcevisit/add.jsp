<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="resourceVisit!add.action?navTabId=resourceVisitList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>资源ID:</label>
			<input type="text" name="resourceVisit.resourceId" class="required" size="30" />
		</p>
		<p>
			<label>公司名称:</label>
			<input type="text" name="resourceVisit.resourceName" class="required" size="30" />
		</p>
		<p>
			<label>用户ID:</label>
			<input type="text" name="resourceVisit.userId" class="required" size="30" />
		</p>
		<p>
			<label>用户名称:</label>
			<input type="text" name="resourceVisit.userName" class="required" size="30" />
		</p>
		<p>
			<label>用户头像:</label>
			<input type="text" name="resourceVisit.userFace" class="required" size="30" />
		</p>
		<p>
			<label>最近访问时间:</label>
			<input type="text" name="resourceVisit.lastTime" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="resourceVisit.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>