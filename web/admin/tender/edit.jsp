<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%> 

<form onsubmit="return validateCallback(this, dialogAjaxDone)" class="pageForm required-validate" action="tender!update.action?navTabId=tenderList&callbackType=closeCurrent" method="post" novalidate="novalidate">
		
		<input type="hidden" name="id" value="${tender.id}">
		<input type="hidden" name="tender.authorId" value="${tender.authorId}"  />
		<input type="hidden" name="tender.status" value="${tender.status}"  />
		
	<div layouth="58" class="pageFormContent" style="height: 203px; overflow: auto;" >
		
		
		<div id="add-resource">
		<p>
			<label>招标编号：</label>
			<input type="text" name="tender.tenderNum" value="${tender.tenderNum}" class="required" size="30" />
		</p>
		<p>
			<label>招标项目名称：</label>
			<input type="text" name="tender.name" value="${tender.name}" class="required" size="30" />
		</p>
		<p>
			<label>招标公司：</label>
			<input type="text" name="tender.company" value="${tender.company}" class="required" size="30" />
		</p>
		<p>
			<label>招标类别：</label>
			<input type="text" name="tender.tenderType" value="${tender.tenderType}" class="required" size="30" />
		</p>
		<p>
			<label>联系人：</label>
			<input type="text" name="tender.contact" value="${tender.contact}" class="required" size="30" />
		</p>
		<p>
			<label>联系电话：</label>
			<input type="text" name="tender.phone" value="${tender.phone}" class="required" size="30" />
		</p>
		<p>
			<label>发布时间：</label>
			<input type="text" name="tender.pbTime" value="${tender.pbTime}" class="required" readOnly="true" size="30" />
		</p>
		<p>
			<label>发布人：</label>
			<input type="text" name="tender.authorName" readOnly="true" value="${tender.authorName}" class="required" size="30" />
		</p>
		<p>
			<label>有效日期：</label>
			<input type="text" name="tender.dffDate" value="${tender.dffDate}" class="required" size="30" />
		</p>
		<p>
			<label>截至时间：</label>
			<input type="text" name="tender.endTime" value="${tender.endTime}" class="required" size="30" />
		</p>
		<%-- <p>
			<label>中标用户ID：</label>
			<input type="text" name="tender.winnerId" value="${tender.winnerId}" class="required" size="30" />
		</p> --%>
		<p>
			<label>中标用户：</label>
			<input type="text" name="tender.winnerName" value="${tender.winnerName}"  size="30" />
		</p>
		<p>
			<label>首页推荐：</label>
			<select  name="tender.dfRecmd" >
				<option value="0"  ${'0' eq tender.dfRecmd ? 'selected' : ''}>否</option>
				<option value="1" ${'1' eq tender.dfRecmd ? 'selected' : ''}>是</option>
			</select>
		</p>
		<p>
			<label>首页推荐排序：</label>
			<input type="text" name="tender.dfSortNum" value="${tender.dfSortNum}" class="required" size="30" />
		</p>
		<p>
			<label>权限控制：</label>
			<select  name="tender.vip" >
				<option value="0"  ${'0' eq tender.vip ? 'selected' : ''}>仅会员可见</option>
				<option value="1" ${'1' eq tender.vip ? 'selected' : ''}>仅VIP可见</option>
			</select>
		</p>
		<div class="divider"></div>
			<p class="editor-p">
			<label>招标内容:</label>
			<textarea cols="80" name="tender.content" rows="20" class="editor" >${tender.content}</textarea>
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