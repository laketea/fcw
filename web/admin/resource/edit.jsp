<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="resource!update.action?navTabId=resourceList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${resource.id}">
		<input type="hidden" name="resource.id" value="${resource.id}">
		<input type="hidden" name="resource.status" value="${resource.status}">

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<p>
			<label>公司名称：</label>
			<input type="text" name="resource.name" value="${resource.name}" class="required" size="30" />
		</p>
		<p>
			<label>公司简称：</label>
			<input type="text" name="resource.simpleName" value="${resource.simpleName}" class="required" size="30" />
		</p>
		<p>
			<label>频道ID：</label>
			<%-- <input type="text" name="resource.channelId" value="${resource.channelId}" class="required" size="30" /> --%>
			<select  name="resource.channelId" class="required res_stype">
				<option value="-1">&nbsp;&nbsp;请选择&nbsp;&nbsp;</option>
						<c:forEach var="item" items="${firstLevelChannelLst}" >
							<option value="${item.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<c:forEach var="child" items="${item.childChannels}" >
								<option stype="two" value="${child.id}" ${child.id eq resource.channel_id ? 'selected' : ''} >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							</c:forEach>
						</c:forEach>
			</select>
		</p>
		<p>
			<label>所属地区：</label>
			<select  name="resource.area"  >
				<c:forEach var="item" items="${areaLst}" varStatus="areasts" >
				<option value="${areasts.index+1}" ${areasts.index+1 eq resource.area ? 'selected' : ''} >${item}</option>
				</c:forEach>
				
			</select>
		</p>
		<script>
		function checkResType(){
			var opt =$("select.res_stype").find("option:selected");
			if(opt.attr("stype")!=='two'){
				alert("请选择资源分类，且资源分类必须为二级分类!");
				return false;
			}
		}
		
		</script>
		<p>
			<label>主营范围：</label>
			<input type="text" name="resource.industry" value="${resource.industry}"  size="30" />
		</p>
		<p>
			<label>公司电话：</label>
			<input type="text" name="resource.phone" value="${resource.phone}" class="required phone" size="30" />
		</p>
		<p>
			<label>公司传真：</label>
			<input type="text" name="resource.tax" value="${resource.tax}"  size="30" />
		</p>
		<p>
			<label>电子邮箱：</label>
			<input type="text" name="resource.email" value="${resource.email}"  size="30" />
		</p>
		<p>
			<label>公司地址：</label>
			<input type="text" name="resource.address" value="${resource.address}"  size="30" />
		</p>
		<p>
			<label>VIP：</label>
			<select  name="resource.vip" >
				<option value="0"  ${'0' eq resource.vip ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq resource.vip ? 'selected' : ''}>是</option>
			</select>
		</p>
		<div class="divider"></div>
		<p>
			<label>首页推荐：</label>
			<select  name="resource.dfRecmd" >
				<option value="0"  ${'0' eq resource.dfRecmd ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq resource.dfRecmd ? 'selected' : ''}>是</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序：</label>
			<input type="text" name="resource.dfSortNum" value="${resource.dfSortNum}" class="required" size="30" />
		</p>
		<p>
			<label>频道推荐：</label>
			<select  name="resource.channelRecmd" >
				<option value="0"  ${'0' eq resource.channelRecmd ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq resource.channelRecmd ? 'selected' : ''}>是</option>
			</select>
		</p>
		<p>
			<label>频道推荐排序：</label>
			<input type="text" name="resource.channelSortNum" value="${resource.channelSortNum}" class="required" size="30" />
		</p>
		<div class="divider"></div>
		<p style="width:100%;height:30px;">
			<label>图片地址:</label>
			<input type="hidden" name="resource.photo"  id="edit-photo" value="${resource.photo}" size="30" />
			<iframe  class="upload-iframe" src="common/upload.html?eleId=edit-photo&path=resourcephoto" width="420" height="30px" style="border:none"></iframe>
		</p>
		<div class="divider"></div>
			<p class="editor-p">
			<label>公司概括:</label>
			<textarea cols="80" name="resource.description" rows="20" class="editor" >${resource.description}</textarea>
		</p>
		</div>
		
	</div>
			
	<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onClick="return checkResType();">修改</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div>
</form>