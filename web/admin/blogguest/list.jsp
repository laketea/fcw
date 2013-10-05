<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="blogGuest!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
</form>

<form method="post" action="blogGuest!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="angleInfo.nick" value="${angleInfo.nick}" /></li>    
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
               <li><a class="add"  mask="true" target="dialog" href="blogguest/add.jsp"  ><span>
新建</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" href="blogGuest!edit.action?id={blogGuest_uid}" ><span>
编辑</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="blogGuest!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
            <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>id</th>
				<th>博客ID</th>
				<th>博客名称</th>
				<th>留言人ID</th>
				<th>留言人名称</th>
				<th>留言人头像</th>
				<th>留言时间</th>
				<th>留言标题</th>
				<th>留言内容</th>
				<th>状态</th>
				<th>编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${blogGuestLst}" varStatus="s">  
            <tr target="blogGuest_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				<td>${item.blogId}</td>
				<td>${item.blogName}</td>
				<td>${item.guestId}</td>
				<td>${item.guestName}</td>
				<td>${item.guestPhoto}</td>
				<td>${item.guestTime}</td>
				<td>${item.title}</td>
				<td>${item.content}</td>
				<td>${item.status}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="blogGuest!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" href="blogGuest!edit.action?id=${item.id}" class="btnEdit">编辑</a>
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