<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="artCatalog!update.action?navTabId=artCatalogList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${artCatalog.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID：</label>
			<input type="text" name="artCatalog.blogId" value="${artCatalog.blogId}" class="required" size="30" />
		</p>
		<p>
			<label>分类名称：</label>
			<input type="text" name="artCatalog.catalogName" value="${artCatalog.catalogName}" class="required" size="30" />
		</p>
		<p>
			<label>创建时间：</label>
			<input type="text" name="artCatalog.createTime" value="${artCatalog.createTime}" class="required" size="30" />
		</p>
		<p>
			<label>文章数量：</label>
			<input type="text" name="artCatalog.articles_count" value="${artCatalog.articles_count}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="artCatalog.status" value="${artCatalog.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>