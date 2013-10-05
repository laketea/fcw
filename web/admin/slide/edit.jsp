<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="slide!update.action?navTabId=slideList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${slide.id}">
		<input type="hidden" name="slide.createTime" value="${slide.createTime}">
		<input type="hidden" name="slide.status" value="${slide.status}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>标题：</label>
			<input type="text" name="slide.title" value="${slide.title}" class="required" size="30" />
		</p>
		<p style="width:100%;height:30px;">
			<label>图片地址:</label>
			<input type="hidden" name="slide.photo"  id="edit-photo" size="30" value="${slide.photo}" />
			<iframe  class="upload-iframe" src="common/upload.html?eleId=edit-photo&path=slidephoto" width="420" height="30px" style="border:none"></iframe>
		</p>
		<p>
			<label>链接：</label>
			<input type="text" name="slide.url" value="${slide.url}" class="required" size="30" />
		</p>
		<p>
			<label>排序：</label>
			<input type="text" name="slide.slideNum" value="${slide.slideNum}" class="required" size="30" />
		</p>
		<p>
			<label>分类：</label>
			<select name="slide.slideType" >
				<option value="1" ${'1' eq slide.slideType ? 'selected' : ''}>首页导航</option>
				<option value="2" ${'2' eq slide.slideType ? 'selected' : ''}>资讯首页导航</option>
				<option value="3" ${'3' eq slide.slideType ? 'selected' : ''}>资源频道导航</option>
				<option value="4" ${'4' eq slide.slideType ? 'selected' : ''}>商务合作广告</option>
			</select>
		</p>
	
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>