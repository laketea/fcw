<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="userInfo!add.action?navTabId=userInfoList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>公司ID:</label>
			<input type="text" name="userInfo.companyId" class="required" size="30" />
		</p>
		<p>
			<label>公司名称:</label>
			<input type="text" name="userInfo.companyName" class="required" size="30" />
		</p>
		<p>
			<label>真实名字:</label>
			<input type="text" name="userInfo.realName" class="required" size="30" />
		</p>
		<p>
			<label>性别:</label>
			<input type="text" name="userInfo.male" class="required" size="30" />
		</p>
		<p>
			<label>年龄:</label>
			<input type="text" name="userInfo.age" class="required" size="30" />
		</p>
		<p>
			<label>联系电话:</label>
			<input type="text" name="userInfo.phone" class="required" size="30" />
		</p>
		<p>
			<label>用户id:</label>
			<input type="text" name="userInfo.userId" class="required" size="30" />
		</p>
		<p>
			<label>最近修改时间:</label>
			<input type="text" name="userInfo.lastUpdateTime" class="required" size="30" />
		</p>
		<p>
			<label>积分:</label>
			<input type="text" name="userInfo.score" class="required" size="30" />
		</p>
		<p>
			<label>状态:</label>
			<input type="text" name="userInfo.status" class="required" size="30" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>