<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="news!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="news.title" value="${news.title}" />
</form>

<form method="post" action="news!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="news.title" value="${news.title}" /></li>    
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
               <li><a class="add"  mask="true" target="dialog" width="800" height="540" href="news!add.action"  ><span>
新建</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" width="800" height="540" href="news!edit.action?id={news_uid}" ><span>
编辑</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="news!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
            <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="50px">id</th>
				<th width="350px">标题</th>
				<th width="100px">所属频道</th>
				<th width="80px">发布者</th>
				<th width="100px">发布时间</th>
				<th width="50px">头条</th>
				<th width="50px">首页</th>
				<th width="50px">顶</th>
				<th width="50px">踩</th>
				<th width="50px">访问量</th>
				
				<th>状态</th>
				<th>编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${newsLst}" varStatus="s">  
            <tr target="news_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				<td>${item.title}</td>
				<td>${item.channelName}</td>
				<td>${item.author}</td>
				<td>${item.pbTime}</td>
				<td>${'0' eq item.topStatus ? '否' : '是'}</td>
				<td>${'0' eq item.dftStatus ? '否' : '是'}</td>
				<td>${item.upCount}</td>
				<td>${item.downCount}</td>
				<td>${item.visitCount}</td>
				<td>${item.status}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="news!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" width="800" height="540" href="news!edit.action?id=${item.id}" class="btnEdit">编辑</a>
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