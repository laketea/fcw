<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>  
<%@ include file="/admin/common/include.jsp"%>  

<form id="pagerForm" method="post" action="information!list.action">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${numPerPage}" />
	<input type="hidden" name="information.name" value="${information.name}" />
</form>

<form method="post" action="information!list.action" onsubmit="return navTabSearch(this)">  
<div class="pageHeader">  
    <input type="hidden" name="pageNum" value="${pageNum}" />  
    <div class="searchBar">  
        <ul class="searchContent">  
        	<li><label>关键字：</label> <input type="text"
					name="information.name" value="${information.name}" /></li>    
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
               <li><a class="add"  mask="true" target="dialog" width="825" height="400"  href="information!add.action"  ><span>
新建</span></a></li>  
				<li><a class="edit"  mask="true" target="dialog" width="825" height="400" href="information!edit.action?id={information_uid}" ><span>
编辑</span></a></li>
				<li><a class="edit"  mask="true" target="ajaxTodo"  href="information!verity.action?id={information_uid}" ><span>
通过审核</span></a></li> 
                <li><a class="delete" rel="ids" target="selectedTodo" postType="string" href="information!batch.action"  title="
确实要删除这些记录吗?"><span>批量删除</span></a></li> 
        </ul>  
    </div>  
    <table class="table" width="100%" layoutH="138" >  
        <thead>  
            <tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>id</th>
				
				
				<th width="350px">资料名称</th>
				<th>分类名称</th>
				<th>地区</th>
				<th>文件大小</th>
				<th>文件后缀</th>
				<th>上传时间</th>
				<th>评分</th>
				<th>vip</th>
				<th>资源币</th>
				<th>上传用户</th>
				<th>审核</th>
				<th>后台上传</th>
				<th>推荐</th>
				<th>推荐排序</th>
				<th>编辑</th>
				
            </tr>  
        </thead>                
        <tbody>  
            <c:forEach var="item" items="${informationLst}" varStatus="s">  
            <tr target="information_uid" rel="${item.id}" >  
            	<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.inforChannel.name}</td>
				<td>${item.area}</td>
				<td>${item.fileSize}</td>
				<td>${item.fileType}</td>
				<td>${item.upTime}</td>
				<td>${item.aveScore}</td>
				<td>${'0' eq item.vip?'非VIP':'VIP'}</td>
				<td>${item.coin}</td>
				<td>${item.userName}</td>
				<td>${'0' eq item.examine?'未审核':'已审核'}</td>
				<td>${'0' eq item.admin?'否':'是'}</td>
				<td>${'0' eq item.dfRecmd?'否':''}${'1' eq item.dfRecmd?'头条':''}${'2' eq item.dfRecmd?'首页':''}</td>
				<td>${item.dfSortNum}</td>
				<td>
					<a title="删除" target="ajaxTodo" href="information!delete.action?id=${item.id}" class="btnDel">删除</a>
					<a title="编辑" target="dialog" width="825" height="540"  href="information!edit.action?id=${item.id}" class="btnEdit">编辑</a>
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