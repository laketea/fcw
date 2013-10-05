<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="reward!add.action?navTabId=rewardList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称:</label>
			<input type="text" name="reward.title" class="required" size="30" />
		</p>
		<p>
			<label>内容:</label>
			<input type="text" name="reward.content" class="required" size="30" />
		</p>
		<p>
			<label>金币:</label>
			<input type="text" name="reward.gold" class="required" size="30" />
		</p>
		<p>
			<label>用户ID:</label>
			<input type="text" name="reward.userId" class="required" size="30" />
		</p>
		<p>
			<label>用户名:</label>
			<input type="text" name="reward.userName" class="required" size="30" />
		</p>
		<p>
			<label>发布时间:</label>
			<input type="text" name="reward.pbTime" class="required" size="30" />
		</p>
		<p>
			<label>回复次数:</label>
			<input type="text" name="reward.rpCount" class="required" size="30" />
		</p>
		<p>
			<label>查看次数:</label>
			<input type="text" name="reward.viewCount" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="reward.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>