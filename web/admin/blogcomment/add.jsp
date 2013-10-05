<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="blogComment!add.action?navTabId=blogCommentList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>博客ID:</label>
			<input type="text" name="blogComment.blogId" class="required" size="30" />
		</p>
		<p>
			<label>博客名称:</label>
			<input type="text" name="blogComment.blogName" class="required" size="30" />
		</p>
		<p>
			<label>内容:</label>
			<input type="text" name="blogComment.title" class="required" size="30" />
		</p>
		<p>
			<label>内容:</label>
			<input type="text" name="blogComment.content" class="required" size="30" />
		</p>
		<p>
			<label>评论人ID:</label>
			<input type="text" name="blogComment.cmtId" class="required" size="30" />
		</p>
		<p>
			<label>评论人名称:</label>
			<input type="text" name="blogComment.cmtName" class="required" size="30" />
		</p>
		<p>
			<label>评论人头像:</label>
			<input type="text" name="blogComment.cmtPhoto" class="required" size="30" />
		</p>
		<p>
			<label>评论时间:</label>
			<input type="text" name="blogComment.cmtTime" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="blogComment.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>