<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.fcw.common.WebCfg"%>
    <ul>
    <li><a href="blog!index.action?id=${id}">空间首页</a></li>
    
    <li><a href="blogrecord!index.action?id=${id}">记录</a></li>
    <li><a href="blogarticle!index.action?id=${id}">日志</a></li>
    
    <li><a href="blogfriend!list.action?id=${id}">好友</a></li>
    <li><a href="blogguest!list.action?id=${id}">留言板</a></li>
    <li><a href="blogguest!list.action?id=${id}">个人资料</a></li>
    </ul>
