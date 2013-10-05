<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="news!update.action?navTabId=newsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${news.id}">
		<input type="hidden" name="news.author" value="${news.author}"  />
		<input type="hidden" name="news.status" value="${news.status}"  />
		<input type="hidden" name="news.pbTime" value="${news.pbTime}"  />
    <input type="hidden" name="news.fromUrl" value="1" />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<p>
			<label>标题：</label>
			<input type="text" name="news.title" value="${news.title}" class="required" size="30" />
		</p>
		
		
		<p>
			<label>头条推荐:</label>
			<select name="news.topStatus" class="required" >
				<option value="0"  ${'0' eq news.topStatus ? 'selected' : ''}>不推荐</option>
				<option value="1"  ${'1' eq news.topStatus ? 'selected' : ''} >推荐</option>
			</select>
		</p>
		<p>
			<label>资讯板块显示:</label>
			<select name="news.zxTopStatus" class="required" >
				<option value="0"  ${'0' eq news.topStatus ? 'selected' : ''}>不显示</option>
				<option value="1"  ${'1' eq news.topStatus ? 'selected' : ''} >显示</option>
			</select>
		</p>
		<p>
			<label>资讯板块显示序号:</label>
			<input type="text" name="news.zxTopNum" class="required" value="${news.zxTopNum}" value="0" size="30" />
		</p>
		<p>
			<label>新闻来源:</label>
			<input type="text" name="news.siteName" class="required" value="${empty news.siteName ?'房资网':news.siteName}" size="30" />
		</p>
		
		<p>
			<label>来源地址:</label>
			<input type="text" name="news.siteUrl" class="required" value="${empty news.siteUrl ?'#':news.siteUrl}" size="30" />
		</p>
		<p>
			<label>简短标题：</label>
			<input type="text" name="news.simpleTitle" value="${news.simpleTitle}" class="required" size="30" />
		</p>
		
		<p>
			<label>所属频道：</label>
			<select  name="news.channelId" class="required">
						<c:forEach var="item" items="${channelLst}" >
								<option value="${item.id}" ${item.id eq news.channelId ? 'selected' : ''} >${item.name}</option>
						</c:forEach>
			</select>
			
		</p>
		
		</div>
		<%-- <p>
			<label>频道名称：</label>
			<input type="text" name="news.channelName" value="${news.channelName}" class="required" size="30" />
		</p>
		<p>
			<label>状态：</label>
			<input type="text" name="news.status" value="${news.status}" class="required" size="30" />
		</p> --%>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>