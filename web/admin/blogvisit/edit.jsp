<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="blogVisit!update.action?navTabId=blogVisitList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${blogVisit.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID：</label>
			<input type="text" name="blogVisit.blogId" value="${blogVisit.blogId}" class="required" size="30" />
		</p>
		<p>
			<label>博客名称：</label>
			<input type="text" name="blogVisit.blogName" value="${blogVisit.blogName}" class="required" size="30" />
		</p>
		<p>
			<label>访问人ID：</label>
			<input type="text" name="blogVisit.visitId" value="${blogVisit.visitId}" class="required" size="30" />
		</p>
		<p>
			<label>访问人名称：</label>
			<input type="text" name="blogVisit.visitName" value="${blogVisit.visitName}" class="required" size="30" />
		</p>
		<p>
			<label>访问人头像：</label>
			<input type="text" name="blogVisit.visitPhoto" value="${blogVisit.visitPhoto}" class="required" size="30" />
		</p>
		<p>
			<label>最近访问时间：</label>
			<input type="text" name="blogVisit.visiteTime" value="${blogVisit.visiteTime}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="blogVisit.status" value="${blogVisit.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>