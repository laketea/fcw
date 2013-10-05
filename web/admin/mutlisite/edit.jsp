<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="mutliSite!update.action?navTabId=mutliSiteList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${mutliSite.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>站点名称：</label>
			<input type="text" name="mutliSite.name" value="${mutliSite.name}" class="required" size="30" />
		</p>
		<p>
			<label>站点Url：</label>
			<input type="text" name="mutliSite.url" value="${mutliSite.url}" class="required" size="30" />
		</p>
		<p>
			<label>站点排序：</label>
			<input type="text" name="mutliSite.siteNum" value="${mutliSite.siteNum}" class="required" size="30" />
		</p>

			<input type="hidden" name="mutliSite.status" value="1" />
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>