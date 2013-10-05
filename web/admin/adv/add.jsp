<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="adv!save.action?navTabId=advList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		<p>
			<label>名称:</label>
			<input type="text" name="adv.name" class="required" size="30" />
		</p>
		<p style="width:100%;height:30px;">
			<label>图片地址:</label>
			<input type="hidden" name="adv.photo"  id="adv-photo" size="30" />
			<iframe  class="upload-iframe" src="common/upload.html?eleId=adv-photo&path=advphoto" width="420" height="30px" style="border:none"></iframe>
		</p>
		<p>
			<label>链接:</label>
			<input type="text" name="adv.url" class="required" size="30" />
		</p>
		<p>
			<label> 类型:</label>
			<select name="adv.advType">
				<option value="1">首页广告</option>
				<option value="2">资讯首页广告</option>
				<option value="3">首页商务合作广告</option>
			</select>
		</p>
		<p>
			<label>宽度:</label>
			<input type="text" name="adv.width" class="required" size="30" />
		</p>
		<p>
			<label>高度:</label>
			<input type="text" name="adv.height" class="required" size="30" />
		</p>
		
		<p>
			<label>状态:</label>
			
			<select name="adv.status" class="required" >
				<option value="0">启用</option>
				<option value="1">关闭</option>
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