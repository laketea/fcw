<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="rewardReply!add.action?navTabId=rewardReplyList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称:</label>
			<input type="text" name="rewardReply.title" class="required" size="30" />
		</p>
		<p>
			<label>内容:</label>
			<input type="text" name="rewardReply.content" class="required" size="30" />
		</p>
		<p>
			<label>悬赏ID:</label>
			<input type="text" name="rewardReply.rewardId" class="required" size="30" />
		</p>
		<p>
			<label>用户ID:</label>
			<input type="text" name="rewardReply.userId" class="required" size="30" />
		</p>
		<p>
			<label>用户名:</label>
			<input type="text" name="rewardReply.userName" class="required" size="30" />
		</p>
		<p>
			<label>发布时间:</label>
			<input type="text" name="rewardReply.pbTime" class="required" size="30" />
		</p>
		<p>
			<label>链接:</label>
			<input type="text" name="rewardReply.url" class="required" size="30" />
		</p>
		<p>
			<label>资料ID:</label>
			<input type="text" name="rewardReply.infoId" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="rewardReply.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>