<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return iframeCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="information!save.action?navTabId=informationList&callbackType=closeCurrent" enctype="multipart/form-data" method="post" novalidate="novalidate">
		
	<input type="hidden" name="information.userId" value="0" />
	<input type="hidden" name="information.userName" value="管理员" />	
	<input type="hidden" name="information.gradeCount" value="0" />
	<input type="hidden" name="information.score" value="0" />
	<input type="hidden" name="information.aveScore" value="0" />
	<input type="hidden" name="information.examine" value="1" />
	<input type="hidden" name="information.admin" value="1" />
	<input type="hidden" name="information.status" value="0" />

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		<div id="add-resource">
<!-- 		<p>
			<label>分类ID:</label>
			<input type="text" name="information.channelId" class="required" size="30" />
		</p>
		<p>
			<label>分类名称:</label>
			<input type="text" name="information.channelName" class="required" size="30" />
		</p> -->
		<p >
			<label>资料名称:</label>
			<input type="text" name="information.name" class="required" size="30" />
		</p>
		<p >
			<label>资料分类:</label>
		<select  name="information.channelId" class="required" >
				<option value="-1">&nbsp;&nbsp;请选择&nbsp;&nbsp;</option>
						<c:forEach var="item" items="${channelLst}" >
							<option value="${item.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							<c:forEach var="child" items="${item.childChannels}" >
								<option value="${child.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
							</c:forEach>
						</c:forEach>
			</select>
		</p>
		<p>
			<label>地区:</label>
			<input type="text" name="information.area" class="required" size="30" />
		</p>
		<p>
			<label>年份:</label>
			<input type="text" name="information.year" class="required" size="30"  />
		</p>
		
		<!-- <p>
			<label>文件路径:</label>
			<input type="text" name="information.filePath" class="required" size="30" />
		</p> -->
	<!-- 	<p>
			<label>文件大小:</label>
			<input type="text" name="information.fileSize" class="required" size="30" />
		</p>
		<p>
			<label>文件后缀:</label>
			<input type="text" name="information.fileType" class="required" size="30" />
		</p> -->
		<!-- <p>
			<label>上传时间:</label>
			<input type="text" name="information.upTime" class="required" size="30" />
		</p> -->
		<p>
			<label>是否vip:</label>
			<select  name="information.vip" >
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</p>
		<p>
			<label>资源币:</label>
			<input type="text" name="information.coin" class="required" size="30" value="0" />
		</p>
	
		<p>
			<label>是否推荐:</label>
			<select  name="information.dfRecmd" >
				<option value="0">不推荐</option>
				<option value="1">头条推荐</option>
				<option value="2">首页推荐</option>
			</select>
		</p>
		<p>
			<label>推荐排序:</label>
			<input type="text" name="information.dfSortNum" class="required" size="30" value="0" />
		</p>
		<p>
			<label>频道推荐:</label>
			<input type="checkbox" name="information.pdRecmd" value="1" >
		</p>
		<p>
			<label>频道推荐排序:</label>
			<input type="text" name="information.pdSortNum" class="required" size="30" value="0" />
		</p>
		
		<p>
			<label>资料中心推荐:</label>
			<select  name="information.zlDfRecmd" >
				<option value="0">不推荐</option>
				<option value="1">推荐</option>
			</select>
		</p>
		<p>
			<label>资料推荐排序:</label>
			<input type="text" name="information.zlDfNum" class="required" size="30" value="0" />
		</p>
		
		<div class="divider"></div>
		<p style="height:95px;width:730px">
			<label>简介:</label>
			<textarea name="information.intro" cols="78" rows="5" ></textarea>
		</p>
		<div class="divider"></div>
		<p>
			<label>上传文件:</label>
			<input type="file" name="myFile"  />
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