<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="reward!update.action?navTabId=rewardList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${reward.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称：</label>
			<input type="text" name="reward.title" value="${reward.title}" class="required" size="30" />
		</p>
		<p>
			<label>内容：</label>
			<input type="text" name="reward.content" value="${reward.content}" class="required" size="30" />
		</p>
		<p>
			<label>金币：</label>
			<input type="text" name="reward.gold" value="${reward.gold}" class="required" size="30" />
		</p>
		<p>
			<label>用户ID：</label>
			<input type="text" name="reward.userId" value="${reward.userId}" class="required" size="30" />
		</p>
		<p>
			<label>用户名：</label>
			<input type="text" name="reward.userName" value="${reward.userName}" class="required" size="30" />
		</p>
		<p>
			<label>发布时间：</label>
			<input type="text" name="reward.pbTime" value="${reward.pbTime}" class="required" size="30" />
		</p>
		<p>
			<label>回复次数：</label>
			<input type="text" name="reward.rpCount" value="${reward.rpCount}" class="required" size="30" />
		</p>
		<p>
			<label>查看次数：</label>
			<input type="text" name="reward.viewCount" value="${reward.viewCount}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="reward.status" value="${reward.status}" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>