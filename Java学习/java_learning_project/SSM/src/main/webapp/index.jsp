<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆界面</title>
</head>
<body>
<h1 style="color:#251361;padding:100px">欢迎 张天昊</h1>
<br>
<form action="${path}/showStudent" method="post" >
    <input type="submit" value="显示页面"/>
</form>
</body>
</html>

