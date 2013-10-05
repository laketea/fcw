<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="rewardReply!update.action?navTabId=rewardReplyList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${rewardReply.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称：</label>
			<input type="text" name="rewardReply.title" value="${rewardReply.title}" class="required" size="30" />
		</p>
		<p>
			<label>内容：</label>
			<input type="text" name="rewardReply.content" value="${rewardReply.content}" class="required" size="30" />
		</p>
		<p>
			<label>悬赏ID：</label>
			<input type="text" name="rewardReply.rewardId" value="${rewardReply.rewardId}" class="required" size="30" />
		</p>
		<p>
			<label>用户ID：</label>
			<input type="text" name="rewardReply.userId" value="${rewardReply.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名：</label>
			<input type="text" name="rewardReply.userName" value="${rewardReply.userName}" class="required" size="30" />
		</p>
		<p>
			<label>发布时间：</label>
			<input type="text" name="rewardReply.pbTime" value="${rewardReply.pbTime}" class="required" size="30" />
		</p>
		<p>
			<label>链接：</label>
			<input type="text" name="rewardReply.url" value="${rewardReply.url}" class="required" size="30" />
		</p>
		<p>
			<label>资料ID：</label>
			<input type="text" name="rewardReply.infoId" value="${rewardReply.infoId}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="rewardReply.status" value="${rewardReply.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>