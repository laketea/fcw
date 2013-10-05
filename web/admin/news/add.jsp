<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="news!save.action?navTabId=newsList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
	<input type="hidden" name="news.status" value="0" />
	<input type="hidden" name="news.author" value="管理员" />	
	<input type="hidden" name="news.upCount" value="0" />
	<input type="hidden" name="news.downCount" value="0" />
	<input type="hidden" name="news.visitCount" value="0" />
	<input type="hidden" name="news.fromUrl" value="0" />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<p>
			<label>标题:</label>
			<input type="text" name="news.title" class="required" size="30" />
		</p>
		
		<p>
			<label>简介标题:</label>
			<input type="text" name="news.simpleTitle"  size="30" />
		</p>
	
		<p style="width:500px">
			<label>频道ID:</label>
			<select name="news.channelId" class="required" >
				<option value="0">&nbsp;&nbsp;请选择频道&nbsp;&nbsp;</option>
				<c:forEach var="item" items="${channelLst}"  >
					<option value="${item.id }"  ${item.id eq chlId ?'selected':''} >${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>新闻来源:</label>
			<input type="text" name="news.siteName" class="required" value="房资网" size="30" />
		</p>
		
		<p>
			<label>来源地址:</label>
			<input type="text" name="news.siteUrl" class="required" value="www.baidu.com" size="30" />
		</p>
		
		<p>
			<label>头条推荐:</label>
			<select name="news.topStatus" class="required" >
				<option value="0">不推荐</option>
				<option value="1">推荐</option>
			</select>
		</p>
		<p>
			<label>头条推荐排序:</label>
			<input type="text" name="news.topNum" class="required" value="0" size="30" />
		</p>
		<p>
			<label>头条推荐2:</label>
			<input type="checkbox" name="news.topsStatus" value="1" >
			
		</p>
		<p>
			<label>头条推荐排序2:</label>
			<input type="text" name="news.topsNum" class="required" value="0" size="30" />
		</p>
		<p>
			<label>首页推荐:</label>
			<select name="news.dftStatus" class="required" >
				<option value="0">不推荐</option>
				<option value="1">推荐</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序:</label>
			<input type="text" name="news.dftNum" class="required" value="0" size="30" />
		</p>
		<p>
			<label>资讯板块显示:</label>
			<select name="news.zxTopStatus" class="required" >
				<option value="0" }>不显示</option>
				<option value="1" } >显示</option>
			</select>
		</p>
		<p>
			<label>资讯板块显示序号:</label>
			<input type="text" name="news.zxTopNum" class="required"  value="0" size="30" />
		</p>
		
		<p>
			<label>图文新闻:</label>
			<select id="hasphotoslt" name="news.hasPhoto" class="required" >
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</p>
		<script>
		 $("#hasphotoslt").change(function(){
		 	var value = $("#hasphotoslt").val();
		 	$(".uplaodp").toggle();
		 });
		</script>
		<p class="uplaodp" style="width:100%;height:40px;display:none;" >
			<label>上传图片:</label><input type="hidden" name="news.photo" id="news-photo">
			<iframe  class="upload-iframe" src="common/upload.html?eleId=news-photo&path=newsphoto" width="600" height="40px" style="border:none"></iframe>
		</p>
		<!-- <p>
			<label>频道名称:</label>
			<input type="text" name="news.channelName" class="required" size="30" />
		</p>	 -->	
		<p style="height:80px;width:500px">
			<label>描述:</label>
			<textarea name="news.description" id="test" cols="50" rows="5" ></textarea>
		</p>
		<p class="editor-p">
			<label>内容:</label>
			<textarea cols="80" name="news.content" rows="20" class="editor" ></textarea>
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