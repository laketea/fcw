<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="resource!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="resource.name" value="${resource.name}" />
</form>

<form method="post" action="resource!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="resource.name" value="${resource.name}" /></li>    
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
               <li><a class="add"  mask="true" target="navTab"  href="resource!add.action"  ><span>
添加资源</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" width="800" height="540" href="resource!edit.action?id={resource_uid}" ><span>
编辑</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="resource!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
            <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="250px">公司名称</th>
				<th width="100px">资源分类</th>
				<!--<th width="100px">所属地区</th>-->
				<th width="100px">主营范围</th>
<!-- 				<th width="100px">公司电话</th>
				<th width="100px">公司传真</th>
				<th width="150px">电子邮箱</th> -->
				<th width="100px">VIP</th>
				<th width="80px">首页推荐</th>
				<th width="80px">首页推荐排序</th>
				<th width="80px">频道推荐</th>
				<th width="80px">频道推荐排序</th>
				<th width="150px">加入时间</th>
				<th width="100px">状态</th>
				<th width="100px">编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${resourceLst}" varStatus="s">  
            <tr target="resource_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.name}</td>
				<td>${item.resourceChannel.name}</td>
				<!--<td>${item.area}</td> -->
				<td>${item.industry}</td>
				<%-- <td>${item.phone}</td>
				<td>${item.tax}</td>
				<td>${item.email}</td> --%>
				<td>${'1' eq item.vip ? 'VIP' : '普通'}</td>
				<td>${'1' eq item.dfRecmd ? '是' : '否'}</td>
				<td>${item.dfSortNum}</td>
				<td>${'1' eq item.channelRecmd ? '是' : '否'}</td>
				<td>${item.channelSortNum}</td>
				<td>${item.createTime}</td>
				<td>${item.status}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="resource!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" width="860" height="650" href="resource!edit.action?id=${item.id}" class="btnEdit">编辑</a>
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