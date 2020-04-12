    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <title>分配维修任务</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
      <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
    </head>
    <body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <div class="layui-logo">设备维修管理系统</div>
        <ul class="layui-nav layui-layout-right">
          <li class="layui-nav-item">
            <a href="javascript:;">
              <img src="pictures/diaodu.png" class="layui-nav-img">
              任务调度员
            </a>
            <dl class="layui-nav-child">
              <dd><a href="${pageContext.request.contextPath }/index.jsp">退出登录</a></dd>
            </dl>
          </li>
        </ul>
      </div>
      
      
      <table id="demo" lay-filter="test"></table>
 
        <div style="padding: 15px;">
        
        <form action="${pageContext.request.contextPath }/UpdateTaskServlet" method="post">
			<center><h1>分配维修任务</h1>
			<br>
			维修编号：<input type="text" name="number" value="${fix.number}"><br/><br>
			维修人员：<input type="text" name="fix_people" value="${fix.fix_people}"><br/><br>
			<input type="submit" value="分配任务">
		</center>
			</form>
		</div>
		</div>
    <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
    <script>
    layui.use('element', function(){
      var element = layui.element;
      
    });
    </script>
    </body>
    </html>