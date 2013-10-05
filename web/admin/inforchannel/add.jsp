<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="inforChannel!save.action?navTabId=inforChannelList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>分类名称:</label>
			<input type="text" name="inforChannel.name" class="required" size="30" />
		</p>
		<p>
			<label>排列序号:</label>
			<input type="text" name="inforChannel.sortNum" class="required" size="30" />
		</p>
		<p>
			<label>父频道:</label>
			<select id="snfs" name="inforChannel.parentId" class="required">
				<option value="-1">请选择</option>
				<option value="0">===顶级目录===</option>
						<c:forEach var="item" items="${firstLevelChannelLst}" >
						<option value="${item.id}"
							>----${item.name}----</option>
						</c:forEach>
			</select>
		</p>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>