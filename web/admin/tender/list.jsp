<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="tender!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="tender.name" value="${tender.name}" />
</form>

<form method="post" action="tender!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="tender.name" value="${tender.name}" /></li>    
        </ul>  
       <div class="subBar">
                  <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
                  </ul>
            </div>
    </div>  
</div>  
</form>
<div class="pageContent">  
    <div class="panelBar">  
        <ul class="toolBar">  
               <li><a class="add"  mask="true" target="navTab" href="tender/add.jsp"  ><span>
新建</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" width="860" height="640" href="tender!edit.action?id={tender_uid}" ><span>
编辑</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="tender!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
            <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>id</th>
				
				<th width="150px">招标编号</th>
				<th width="150px">招标项目名称</th>
				<th width="250px">招标公司</th>
				<th>发布时间</th>
				<th>有效日期</th>
				<th>截至时间</th>
				<th>发布者名称</th>
				<th>中标用户</th>
				<th>首页推荐</th>
				<th>首页推荐排序</th>
				<th>权限</th>
				<th>状态</th>
				<th>编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${tenderLst}" varStatus="s">  
            <tr target="tender_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				
				<td>${item.tenderNum}</td>
				<td>${item.name}</td>
				<td>${item.company}</td>
				<td>${item.pbTime}</td>
				<td>${item.dffDate}</td>
				<td>${item.endTime}</td>
				<td>${item.authorName}</td>
				<td>${item.winnerName}</td>
				<td>${item.dfRecmd eq '0' ? '否' : '是'}</td>
				<td>${item.dfSortNum}</td>
				<td>${item.vip eq '1' ? 'VIP可见' : '会员可见'}</td>
				<td>${item.status eq '0' ? '正在进行' : ''}${item.status eq '1' ? '已结束' : ''}
				</td>
				<td>
					<a title="删除" target="ajaxTodo" href="tender!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" width="860" height="640" href="tender!edit.action?id=${item.id}" class="btnEdit">编辑</a>
				</td>
				
            </tr>  
            </c:forEach>  
        </tbody>  
    </table>    
    <div class="panelBar">  
        <div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak
({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="${totalRecords}" numPerPage="{numPerPage}" pageNumShown="10" 
currentPage="1"></div> 
    </div>  
</div>  