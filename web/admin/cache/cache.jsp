<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="com.fcw.common.WebCfg"%>
<%@ include file="/admin/common/include.jsp"%>




<div layouth="58" class="pageFormContent"
	style="height: 203px; overflow: auto;">


	<p style="width:100%">
	 <table class="table" width="100%" layoutH="138" >
	 <thead>    
		<tr>
				<th>缓存类型</th>
				<th>操作</th>	
            </tr> 
     </thead>
     <tbody>
		<tr>
			<td width="150px">首页缓存</td>
			<td width="300px"><a href="cache!reflush.action?id=1"
				target="navTab" rel="cache">点击刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${1 eq id}">
					<span style="color:red">刷新成功!</span>
				</c:if></td>
		</tr>
		
		<tr>
			<td width="150px">顶部缓存</td>
			<td width="300px"><a href="cache!reflush.action?id=2"
				target="navTab" rel="cache">点击刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${2 eq id}">
					<span style="color:red">刷新成功!</span>
				</c:if></td>
		</tr>
		
		<tr>
			<td width="150px">资料缓存</td>
			<td width="300px"><a href="cache!reflush.action?id=3"
				target="navTab" rel="cache">点击刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${3 eq id}">
					<span style="color:red">刷新成功!</span>
				</c:if></td>
		</tr>
		
		<tr>
			<td width="150px">资源缓存</td>
			<td width="300px"><a href="cache!reflush.action?id=4"
				target="navTab" rel="cache">点击刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${4 eq id}">
					<span style="color:red">刷新成功!</span>
				</c:if></td>
		</tr>
		
		<tr>
			<td width="150px">所有缓存</td>
			<td width="300px"><a href="cache!reflush.action?id=5"
				target="navTab" rel="cache">点击刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${5 eq id}">
					<span style="color:red">刷新成功!</span>
				</c:if></td>
		</tr>
		</tbody> 
	</table>
	



</div>

<!-- <div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				<li><div class="button" style="margin-left:20px"><div class="buttonContent"><button class="close" type="button">取消</button></div></div></li>
			</ul>
		</div> -->
