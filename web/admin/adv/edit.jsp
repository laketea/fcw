<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="adv!update.action?navTabId=advList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${adv.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称：</label>
			<input type="text" name="adv.name" value="${adv.name}" class="required" size="30" readOnly="readOnly" />
		</p>
		<p style="width:100%;height:30px;">
			<label>图片地址:</label>
			<input type="hidden" name="adv.photo"  id="edit-photo" value="${adv.photo}" size="30" />
			<iframe  class="upload-iframe" src="common/upload.html?eleId=edit-photo&path=advphoto" width="420" height="30px" style="border:none"></iframe>
		</p>

		<p>
			<label>链接：</label>
			<input type="text" name="adv.url" value="${adv.url}" class="required" size="30" />
		</p>
		
		<p>
			<label>分类：</label>
			<select name="adv.advType" class="required" >
				<option value="1"  ${'1' eq adv.advType ? 'selected' : ''} >首页广告</option>
				<option value="2"  ${'2' eq adv.advType ? 'selected' : ''} >资讯首页广告</option>
				<option value="3"  ${'3' eq adv.advType ? 'selected' : ''} >首页商务合作广告</option>
			</select>
		</p>
	
		
		<p>
			<label>状态：</label>
			<select name="adv.status" class="required" >
				<option value="0"  ${'0' eq adv.status ? 'selected' : ''}>启用</option>
				<option value="1"  ${'1' eq adv.status ? 'selected' : ''} >禁用</option>
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