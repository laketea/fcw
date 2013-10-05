<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="resourceChannel!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="resourceChannel.name" value="${resourceChannel.name}" />
</form>

<form method="post" action="resourceChannel!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="resourceChannel.name" value="${resourceChannel.name}" /></li>    
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
               <li><a class="add"  mask="true" target="dialog" height="390" href="resourceChannel!add.action"  ><span>
新建</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" height="390" href="resourceChannel!edit.action?id={resourceChannel_uid}" ><span>
编辑</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="resourceChannel!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
             <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>id</th>
				<th>父频道</th>
				<th>子频道</th>
				<th>资料总数</th>
				<th>排列序号</th>
				<th>导航推荐</th>
				<th>域推荐</th>
				<th>创建时间</th>
				<th>编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${resourceChannelLst}" varStatus="s">  
            <tr target="resourceChannel_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
            	<td>${item.id}</td>
				<td>${item.name}</td>
				<td></td>
				<td></td>
				<td>${item.sortNum}</td>
				<td></td>
				<td></td>
				<td>${item.createTime}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="resourceChannel!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" href="resourceChannel!edit.action?id=${item.id}" class="btnEdit">编辑</a>
				</td>
            </tr>
            <c:forEach var="child" items="${item.childChannels}" >  
			<tr target="resourceChannel_uid" rel="${child.id}" >  
            	<td><input name="ids" value="${child.id}" type="checkbox"></td>
            	<td>${child.id}</td>
				<td></td>
				<td>${child.name}</td>
				<td></td>
				<td>${child.sortNum}</td>
				<td>${'1'eq child.dhstatus ?'推荐':'不推荐'}</td>
				<td>${'1'eq child.dfstatus ?'推荐':'不推荐'}</td>
				<td>${child.createTime}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="resourceChannel!delete.action?id=${child.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" height="390" href="resourceChannel!edit.action?id=${child.id}" class="btnEdit">编辑</a>
				</td>
            </tr>

			</c:forEach>  
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