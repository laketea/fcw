<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, navTabAjaxDone)" class="pageForm required-validate" action="tender!add.action?navTabId=tenderList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
	<input type="hidden" name="tender.authorId" value="0"  >
	<input type="hidden" name="tender.authorName" value="管理员"  >
	<input type="hidden" name="tender.status" value="0"  >
		

	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		
		<div id="add-resource">
		<!-- <p>
			<label>发布者ID:</label>
			<input type="text" name="tender.authorId" class="required" size="30" />
		</p> -->
		<!-- <p>
			<label>发布者名称:</label>
			<input type="text" name="tender.authorName" class="required" size="30" />
		</p> -->
		<p>
			<label>招标编号:</label>
			<input type="text" name="tender.tenderNum" class="required" size="30" />
		</p>
		<p>
			<label>招标项目名称:</label>
			<input type="text" name="tender.name" class="required" size="30" />
		</p>
		<p>
			<label>招标公司:</label>
			<input type="text" name="tender.company" class="required" size="30" />
		</p>
		<p>
			<label>招标类别:</label>
			<input type="text" name="tender.tenderType" class="required" size="30" />
		</p>
		<p>
			<label>联系人:</label>
			<input type="text" name="tender.contact" class="required" size="30" />
		</p>
		<p>
			<label>联系电话:</label>
			<input type="text" name="tender.phone" class="required" size="30" />
		</p>
		<!-- <p>
			<label>发布时间:</label>
			<input type="text" name="tender.pbTime" class="required" size="30" />
		</p> -->
		<p>
			<label>有效日期:</label>
			<input type="text" name="tender.dffDate" class="required" size="30" />
		</p>
		<p>
			<label>截至时间:</label>
			<input type="text" name="tender.endTime" yearstart="-10" yearend="5" class="date" pattern="yyyy-MM-dd"  />
		</p>
		<!-- <p>
			<label>中标用户ID:</label>
			<input type="text" name="tender.winnerId" class="required" size="30" />
		</p>
		<p>
			<label>中标用户:</label>
			<input type="text" name="tender.winnerName" class="required" size="30" />
		</p> -->
		<p>
			<label>首页推荐:</label>
			<select  name="tender.dfRecmd" >
				<option value="0">否</option>
				<option value="1">是</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序:</label>
			<input type="text" name="tender.dfSortNum" value="0" class="required" size="30" />
		</p>
		<p>
			<label>权限控制:</label>
			<select  name="tender.vip" >
				<option value="0">仅会员可见</option>
				<option value="1">仅VIP可见</option>
			</select>
		</p>
		<!-- <p>
			<label>状态:</label>
			<input type="text" name="tender.status" class="required" size="30" />
		</p> -->
		<div class="divider"></div>
		<p class="editor-p">
			<label>招标内容:</label>
			<textarea cols="80" name="tender.content" rows="20" class="editor"></textarea>
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