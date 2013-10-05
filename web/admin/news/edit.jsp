<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="news!update.action?navTabId=newsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${news.id}">
		<input type="hidden" name="news.author" value="${news.author}"  />
		<input type="hidden" name="news.status" value="${news.status}"  />
        <input type="hidden" name="news.fromUrl" value="0" />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<p>
			<label>标题：</label>
			<input type="text" name="news.title" value="${news.title}" class="required" size="30" />
		</p>
		
		<p>
			<label>简短标题：</label>
			<input type="text" name="news.simpleTitle" value="${news.simpleTitle}" class="required" size="30" />
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
			<label>头条推荐:</label>
			<select name="news.topStatus" class="required" >
				<option value="0"  ${'0' eq news.topStatus ? 'selected' : ''}>不推荐</option>
				<option value="1"  ${'1' eq news.topStatus ? 'selected' : ''} >推荐</option>
			</select>
		</p>
		<p>
			<label>头条推荐排序:</label>
			<input type="text" name="news.topNum" class="required" value="${news.topNum}" size="30" />
		</p>
		<p>
			<label>头条推荐2:</label>
			<input type="checkbox"  name="news.topsStatus" value="1" ${'1' eq news.topsStatus ? 'checked' : ''}  >
		</p>
		<p>
			<label>头条推荐排序2:</label>
			<input type="text" name="news.topsNum" class="required" value="${news.topsNum}" size="30" />
		</p>
		<p>
			<label>首页推荐:</label>
			<select name="news.dftStatus" class="required" >
				<option value="0" ${'0' eq news.dftStatus ? 'selected' : ''}>不推荐</option>
				<option value="1" ${'1' eq news.dftStatus ? 'selected' : ''}>推荐</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序:</label>
			<input type="text" name="news.dftNum" class="required" value="${news.dftNum}" size="30" />
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
			<label>图文新闻:</label>
			<select name="news.hasPhoto" class="required" >
				<option value="0" ${'0' eq news.hasPhoto ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq news.hasPhoto ? 'selected' : ''} >是</option>
			</select>
		</p>
		
		<p>
			<label>发布时间：</label>
			<input type="text" name="news.pbTime" value="${news.pbTime}"  size="30" readOnly="readonly" />
		</p>
		<p>
			<label>顶：</label>
			<input type="text" name="news.upCount" value="${news.upCount}" class="required" size="30" />
		</p>
		<p>
			<label>踩：</label>
			<input type="text" name="news.downCount" value="${news.downCount}" class="required" size="30" />
		</p>
		<p>
			<label>访问量：</label>
			<input type="text" name="news.visitCount" value="${news.visitCount}" class="required" size="30" />
		</p>
		<p>
			<label>所属频道：</label>
			<select  name="news.channelId" class="required">
						<c:forEach var="item" items="${channelLst}" >
								<option value="${item.id}" ${item.id eq news.channelId ? 'selected' : ''} >${item.name}</option>
						</c:forEach>
			</select>
			
		</p>
		<p style="width:500px;height:80px">
			<label>描述：</label>
			<textarea name="news.description" cols="50" rows="5" >${news.description}</textarea>
		</p>
		<p class="editor-p">
			<label>内容：</label>
			<textarea cols="80" name="news.content" rows="20" class="editor" >${news.content}</textarea>
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