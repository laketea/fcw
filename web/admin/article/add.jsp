<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="article!add.action?navTabId=articleList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID:</label>
			<input type="text" name="article.blogId" class="required" size="30" />
		</p>
		<p>
			<label>博客名称:</label>
			<input type="text" name="article.blogName" class="required" size="30" />
		</p>
		<p>
			<label>标题:</label>
			<input type="text" name="article.title" class="required" size="30" />
		</p>
		<p>
			<label>内容:</label>
			<input type="text" name="article.content" class="required" size="30" />
		</p>
		<p>
			<label>发布时间:</label>
			<input type="text" name="article.phTime" class="required" size="30" />
		</p>
		<p>
			<label>阅读次数:</label>
			<input type="text" name="article.view_count" class="required" size="30" />
		</p>
		<p>
			<label>分类ID:</label>
			<input type="text" name="article.catalogId" class="required" size="30" />
		</p>
		<p>
			<label>分类名称:</label>
			<input type="text" name="article.catalogName" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="article.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>