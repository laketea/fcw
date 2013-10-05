<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="inforChannel!update.action?navTabId=inforChannelList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${inforChannel.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>分类名称：</label>
			<input type="text" name="inforChannel.name" value="${inforChannel.name}" class="required" size="30" />
		</p>
		<p>
			<label>排列序号：</label>
			<input type="text" name="inforChannel.sortNum" value="${inforChannel.sortNum}" class="required" size="30" />
		</p>
		<p>
			<label>父频道：</label>
			<input type="text"  value="${'0' eq inforChannel.status ?'顶级栏目':inforChannel.parentChannel.name}" class="required" size="30" readOnly="readOnly" />
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>