<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="resourceChannel!update.action?navTabId=resourceChannelList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${resourceChannel.id}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>频道名称：</label>
			<input type="text" name="resourceChannel.name" value="${resourceChannel.name}" class="required" size="30" />
		</p>
		
		<p>
			<label>排列序号：</label>
			<input type="text" name="resourceChannel.sortNum" value="${resourceChannel.sortNum}" class="required" size="30" />
		</p>
		
		<p>
			<label>是否导航推荐:</label>
			<select  name="resourceChannel.dhstatus" class="required">
				<option value="0" ${'0' eq resourceChannel.dhstatus ? 'selected' : ''}>不推荐</option>
				<option value="1" ${'1' eq resourceChannel.dhstatus ? 'selected' : ''} >推荐</option>
			</select>
		</p>
		
		<p>
			<label>是否导航域推荐:</label>
			<select  name="resourceChannel.dfstatus" class="required">
				<option value="0" ${'0' eq resourceChannel.dfstatus ? 'selected' : ''}>不推荐</option>
				<option value="1" ${'1' eq resourceChannel.dfstatus ? 'selected' : ''} >推荐</option>
			</select>
		</p>
		<p>
			<label>父频道ID：</label>
			<input type="text"  value="${inforChannel.parentChannel.name}" class="required" size="30" />
		</p>
		
		<p>
			<label>导航区域标题:</label>
			<input type="text" name="resourceChannel.dfTitle" value="${resourceChannel.dfTitle}" size="30" />
		</p>
		<p>
			<label>导航区域标题地址:</label>
			<input type="text" name="resourceChannel.dfTitleUrl" value="${resourceChannel.dfTitleUrl}" size="30" />
		</p>
		<p>
			<label>导航区域文字1:</label>
			<input type="text" name="resourceChannel.dfFirstLine" value="${resourceChannel.dfFirstLine}"  size="30" />
		</p>
		<p>
			<label>导航区域文字1地址:</label>
			<input type="text" name="resourceChannel.dfFirstLineUrl" value="${resourceChannel.dfFirstLineUrl}"  size="30" />
		</p>
		<p>
			<label>导航区域文字2:</label>
			<input type="text" name="resourceChannel.dfSecondLine" value="${resourceChannel.dfSecondLine}"  size="30" />
		</p>
		<p>
			<label>导航区域文字2地址:</label>
			<input type="text" name="resourceChannel.dfSecondLineUrl" value="${resourceChannel.dfSecondLineUrl}"  size="30" />
		</p>
		<p>
			<label>导航区域图片:</label>
			<input type="text" name="resourceChannel.dfPhoto" id="rsce-dfPhoto" value="${resourceChannel.dfPhoto}"  size="30" />
		</p>
		<p style="width:100%;height:30px;">
			<label>导航区域修改:</label>
			<iframe  class="upload-iframe" src="common/upload.html?eleId=rsce-dfPhoto&path=dfphoto" width="420" height="30px" style="border:none"></iframe>
		</p>
		<p>
			<label>导航区域图片地址:</label>
			<input type="text" name="resourceChannel.dfPhotoUrl" value="${resourceChannel.dfPhotoUrl}"  size="30" />
		</p>
		
		
		
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>