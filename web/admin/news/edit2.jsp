<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="news!update.action?navTabId=newsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${news.id}">
		<input type="hidden" name="news.author" value="${news.author}"  />
		<input type="hidden" name="news.status" value="${news.status}"  />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow-x: hidden;overflow-y: auto;" >
		<div >
		<p>
			<label>标题：</label>
			<input type="text" name="news.title" value="${news.title}" class="required" size="30" />
		</p>
		
		<p>
			<label>所属频道：</label>
			<select  name="news.channelId" class="required">
						<c:forEach var="item" items="${channelLst}" >
								<option value="${item.id}" ${item.id eq news.channelId ? 'selected' : ''} >${item.name}</option>
						</c:forEach>
			</select>
			
		</p>
		
		
		<p>
			<label>连接url：</label>
			<input type="text" name="news.url" value="${news.url}" class="required" size="30" />
		</p>
		
		<p>
			<label>发布时间：</label>
			<input type="text" name="news.pbTime" value="${news.pbTime}"  size="30" readOnly="readonly" />
		</p>
		
		</div>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>