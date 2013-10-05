<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="information!update.action?navTabId=informationList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${information.id}">
		<input type="hidden" name="information.userId" value="${information.userId}" />
		<input type="hidden" name="information.status" value="${information.status}"  />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
		<%-- <p>
			<label>分类ID：</label>
			<input type="text" name="information.channelId" value="${information.channelId}" class="required" size="30" />
		</p> --%>
		<p>
			<label>资料名称：</label>
			<input type="text" name="information.name" value="${information.name}" class="required" size="30" />
		</p>
		<p>
			<label>所属分类：</label>
			<select  name="information.channelId" class="required">
				<option value="-1">&nbsp;&nbsp;请选择&nbsp;&nbsp;</option>
						<c:forEach var="item" items="${channelLst}" >
							<option value="${item.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<c:forEach var="child" items="${item.childChannels}" >
								<option value="${child.id}" ${child.id eq information.channel_id ? 'selected' : ''} >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							</c:forEach>
						</c:forEach>
			</select>
		</p>
		<p>
			<label>上传用户：</label>
			<input type="text" name="information.userName" value="${information.userName}" class="required" size="30" readOnly="readonly" />
		</p>
		
		<p>
			<label>地区：</label>
			<input type="text" name="information.area" value="${information.area}" class="required" size="30" />
		</p>
		<p>
			<label>年份：</label>
			<input type="text" name="information.year" value="${information.year}" class="required" size="30" />
		</p>
		<p>
			<label>文件路径：</label>
			<input type="text" name="information.filePath" value="${information.filePath}"  size="30" readOnly="readonly" />
		</p>
		<p>
			<label>文件大小：</label>
			<input type="text" name="information.fileSize" value="${information.fileSize}" readOnly="readonly" size="30" />
		</p>
		<p>
			<label>文件后缀：</label>
			<input type="text" name="information.fileType" value="${information.fileType}" readOnly="readonly" size="30" />
		</p>
		<p>
			<label>上传时间：</label>
			<input type="text" name="information.upTime" value="${information.upTime}" readOnly="readonly" size="30" />
		</p>
		<p>
			<label>VIP：</label>
			<select  name="information.vip" >
				<option value="0"  ${'0' eq information.vip ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq information.vip ? 'selected' : ''}>是</option>
			</select>
		</p>
		<p>
			<label>资源币：</label>
			<input type="text" name="information.coin" value="${information.coin}" class="required" size="30" />
		</p>
		<p>
			<label>评价总数：</label>
			<input type="text" name="information.gradeCount" value="${information.gradeCount}" class="required" size="30" />
		</p>
		<p>
			<label>总评分：</label>
			<input type="text" name="information.score" value="${information.score}" class="required" size="30" />
		</p>
		<p>
			<label>评分：</label>
			<input type="text" name="information.aveScore" value="${information.aveScore}" class="required" size="30" />
		</p>
		<p>
			<label>是否审核：</label>
			<select  name="information.examine" >
				<option value="0"  ${'0' eq information.examine ? 'selected' : ''}>未审核</option>
				<option value="1" ${'1' eq information.examine ? 'selected' : ''}>已审核</option>
				
			</select>
			
		</p>
		<p>
			<label>是否管理员上传：</label>
			<select  name="information.admin" >
				<option value="0"  ${'0' eq information.admin ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq information.admin ? 'selected' : ''}>是</option>
			</select>
		</p>
		<p>
			<label>是否推荐：</label>
			<select  name="information.dfRecmd" >
				<option value="0"  ${'0' eq information.dfRecmd ? 'selected' : ''}>未推荐</option>
				<option value="1" ${'1' eq information.dfRecmd ? 'selected' : ''}>头条推荐</option>
				<option value="2" ${'2' eq information.dfRecmd ? 'selected' : ''}>首页推荐</option>
			</select>
		</p>
		<p>
			<label>推荐排序：</label>
			<input type="text" name="information.dfSortNum" value="${information.dfSortNum}" class="required" size="30" />
		</p>
		<p>
			<label>频道推荐：</label>
			<input type="checkbox" name="information.pdRecmd" value="1"  ${'1' eq information.pdRecmd ? 'checked' : ''} >
		</p>
		<p>
			<label>频道推荐排序：</label>
			<input type="text" name="information.pdSortNum" value="${information.pdSortNum}" class="required" size="30" />
		</p>
		<p>
			<label>资料中心推荐:</label>
			<select  name="information.zlDfRecmd" >
				<option value="0" ${'0' eq information.zlDfRecmd ? 'selected' : ''} >不推荐</option>
				<option value="1" ${'1' eq information.zlDfRecmd ? 'selected' : ''} >推荐</option>
			</select>
		</p>
		<p>
			<label>资料推荐排序:</label>
			<input type="text" name="information.zlDfNum" value="${information.zlDfNum}" class="required" size="30" />
		</p>
		
		<div class="divider"></div>
		<p style="height:95px;width:730px">
			<label>简介:</label>
			<textarea name="information.intro" cols="78" rows="5" >${information.intro}</textarea>
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