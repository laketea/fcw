<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="news!save.action?navTabId=newsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
	<input type="hidden" name="news.status" value="0" />
	<input type="hidden" name="news.author" value="管理员" />	
	<input type="hidden" name="news.upCount" value="0" />
	<input type="hidden" name="news.downCount" value="0" />
	<input type="hidden" name="news.visitCount" value="0" />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow-x: hidden;overflow-y: auto;" >
		<div >
		<p>
			<label>标题:</label>
			<input type="text" name="news.title" class="required" size="30" />
		</p>
		
		<p style="">
			<label>频道ID:</label>
			<select name="news.channelId" class="required" >
				<option value="0">&nbsp;&nbsp;请选择频道&nbsp;&nbsp;</option>
				<c:forEach var="item" items="${channelLst}"  >
					<option value="${item.id }"  ${item.id eq chlId ?'selected':''} >${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>连接url:</label>
			<input type="text" name="news.url" class="required" value="0" size="30" />
		</p>
		
		
		</div>
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"  class="newsadd">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
		
</form>