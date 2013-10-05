<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/include.jsp"%>
<%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房产网-商务合作</title>
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />

<link type="text/css" rel="stylesheet" href="../resource/css/common.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/ui-default.css" />
<link type="text/css" rel="stylesheet"
	href="../resource/css/default.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/sidle.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="../resource/css/swhz.css" />
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<script type="text/javascript" src="../resource/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../resource/js/common.js"></script>
<script src="../resource/js/jquery.Xslider.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		// 焦点图片淡隐淡现
		$("#slider6").Xslider({
			affect : 'fade',
			ctag : 'div'
		});
	});
</script>
<body>

	<%@include file="../common/top.jsp"%>
	<c:set var="channelName" value="商务合作" scope="request" />
	<%@include file="../common/head.jsp"%>
	<div id="top-grad"></div>
	
<div id="swhz" class="wrap center960 box ">
    <div class="banner" >
    
    <div class="business-adv">

				<div class="slider" id="slider6">
					<div class="conbox">
						<c:forEach var="item" items="${slideLst}">
							<div>
								<a href="${item.url}" target="_blank" title=""><img
									width="708" height="231" border="0" alt=""
									src="../${item.photo}" />
								</a>
							</div>
						</c:forEach>

					</div>
					<div class="switcher">
						<a href="#" class=""></a> <a href="#" class="cur"></a>
					</div>
				</div>

			</div>
    <div class="sw-login"></div>
    <div  class="sw-reg"></div>
    </div>
    <div class="content fl">
        <div class="title"><span>最新投标</span></div>
        <ul id="tb_list">
        <c:forEach var="item" items="${tenderLst}" >
            <li>
               <div class="box"><a href="../business!show.action?id=${item.id}" class="${empty sessionScope.login? '  needLogin':''}
               ${not empty sessionScope.user && '1' eq item.vip && (empty sessionScope.user.vip || 0 eq sessionScope.user.vip  ) ? '  needVip':''} fl tb_name
              ${1 eq item.overdue? '  overdue':''}
               ">${item.name}</a><a sid="${item.id}"   class="showTb fr tb_btn">[我要投标]</a></div>
                <div class="box"> <span>招商类型:${item.tenderType}</span>
                <span>发布时间:${item.pbTime}</span>
                <span>有效时间:${1 eq item.overdue? '已结束':item.endTime}</span>
                <a href="../business!show.action?id=${item.id}"  class="tb-view  ${empty sessionScope.login? '  needLogin':''}
               ">[查看详细]</a>
                 </div>
            </li>
           </c:forEach>
        </ul>
        
        <div class="info-page" style="padding-left:18px;">
        <pg:pager url="business!index.action" items="${businessPage.totalRecords}" maxPageItems="10" export="currentPageNumber=pageNumber">
        <pg:first>
        <a href="${pageUrl}">首页</a>
        </pg:first>
        <pg:prev>
        <a href="${pageUrl }">上一页</a>
        </pg:prev>
        <pg:pages>
        <c:choose>
        <c:when test="${currentPageNumber eq pageNumber}">
        <a  > <font color="red">${pageNumber }</font></a>
        </c:when>
        <c:otherwise>
        <a href="${pageUrl }">${pageNumber }</a>
        </c:otherwise>
        </c:choose>
        </pg:pages>
        <pg:next>
        <a href="${pageUrl }">下一页</a>
        </pg:next>
        <pg:last>
        <a href="${pageUrl }">尾页</a>
        </pg:last>
        </pg:pager>
        </div>
    </div>
    <div id="zb-list" class=" sidebar fr">
        <h2>中标公告</h2>
        <div class="zb-bg"></div>
        <ul>
         <c:forEach var="litem" items="${sucessedLst}" >
            <li>
                <h3>${litem.name}</h3>
                <span>${litem.winnerName}</span>
            </li>
          </c:forEach>
        </ul>
    </div>



</div>
	
	<%@include file="../common/foot.jsp"%>
<div id="dialog-form" title="投标留言">
	<form>
	<fieldset>
		<label for="name">留言</label>
		<textarea id="ly-content" class="text ui-widget-content ui-corner-all" rows="8" cols="41" ></textarea>
		<input type="hidden" name="sid" id="sid" >
	</fieldset>
	</form>
</div>



</body>
</html>