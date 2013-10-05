<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, navTabAjaxDone)" class="pageForm required-validate" action="resource!save.action?navTabId=resourceList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		

	<div layouth="58"  class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<p>
			<label>公司名称:</label>
			<input type="text" name="resource.name" class="required" size="30" />
		</p>
		<p>
			<label>公司简称:</label>
			<input type="text" name="resource.simpleName" class="required" size="30" />
		</p>
		<p>
			<label>所属频道:</label>
			<select id="snfs" name="resource.channelId" class="required">
				<option value="-1">&nbsp;&nbsp;请选择&nbsp;&nbsp;</option>
						<c:forEach var="item" items="${firstLevelChannelLst}" >
							<option value="${item.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<c:forEach var="child" items="${item.childChannels}" >
								<option value="${child.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							</c:forEach>
						</c:forEach>
			</select>
		</p>
		<p>
			<label>所属地区:</label>
			
			<select name="resource.area"  >
				<c:forEach var="item" items="${areaLst}" varStatus="areasts" >
				<option value="${areasts.index+1}">${item}</option>
				</c:forEach>
				
			</select>
		</p>
		<p>
			<label>主营范围:</label>
			<input type="text" name="resource.industry"  size="30" />
		</p>
		<p>
			<label>公司电话:</label>
			<input type="text" name="resource.phone" class="required" size="30" />
		</p>
		<p>
			<label>公司传真:</label>
			<input type="text" name="resource.tax"  size="30" />
		</p>
		<p>
			<label>电子邮箱:</label>
			<input type="text" name="resource.email"  size="30" />
		</p>
		<p>
			<label>公司地址:</label>
			<input type="text" name="resource.address"  size="30" />
		</p>

		<div class="divider"></div>
		<p>
			<label>首页推荐:</label>
			<select  name="resource.dfRecmd" >
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</p>
		<p>
			<label>频道推荐:</label>
			<select  name="resource.channelRecmd" >
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序:</label>
			<input type="text" name="resource.dfSortNum" class="required" value="0" size="30" />
		</p>
		<p>
			<label>频道推荐排序:</label>
			<input type="text" name="resource.channelSortNum" class="required" value="0" size="30" />
		</p>
		<div class="divider"></div>
		<p>
			<label>初始帐号:</label>
			<input type="text" name="resource.nick" class="required"  size="30" />
		</p>
		<p>
			<label>初始密码:</label>
			<input type="text" name="resource.pwd" class="required"  size="30" />
		</p>
		<div class="divider"></div>
		<p style="width:100%;height:30px;">
			<label>图片地址:</label>
			<input type="hidden" name="resource.photo"  id="resource-photo" size="30" />
			<iframe  class="upload-iframe" src="common/upload.html?eleId=resource-photo&path=resourcephoto" width="420" height="30px" style="border:none"></iframe>
		</p>
		
		
		
		<div class="divider"></div>
			<p class="editor-p">
			<label>公司概括:</label>
			<textarea cols="80" name="resource.description" rows="20" class="editor"></textarea>
		</p>
		</div>	
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>