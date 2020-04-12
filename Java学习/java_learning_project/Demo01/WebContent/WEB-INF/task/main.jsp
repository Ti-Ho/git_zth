<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
    <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <title>设备维修管理系统</title>
      <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
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
 

        <div style="padding: 15px;"><script src="/layui/layui/layui.js"></script>
        <form name="input" action="${pageContext.request.contextPath }/SearchTaskServlet"method="post">
        	<center><h1>维修查询</h1>
        	<br>
			维修编号:<input type="text" name="number">
			<input type="submit" value="查询"></center>
			<br>
			<br>
<table class="layui-table"border="1" cellspacing="0" width="80%"  align="center">

<tr><th>维修编号</th><th>维修人员</th><th>检测记录</th><th>维修记录</th><th>工作量</th><th>维修状态</th><th>操作</th></tr>
<c:if test="${lists == null }">
<tr><td colspan="6"><font color="red">没有符合条件的数据</font></td></tr>
</c:if>
<c:if test="${lists!=null }">
<c:forEach items="${lists }" var="item">
<tr><td>${item.number }</td>
<td>${item.fix_people }</td>
<td>${item.detection_record }</td>
<td>${item.fix_record }</td>
<td>${item.workload}</td>
<td>${item.status}</td>
<td>
<a href="${pageContext.request.contextPath }/GetTaskByNumberServlet?number=${item.number}">修改</a>
<a href="${pageContext.request.contextPath }/DeleteTaskServlet?number=${item.number }">删除</a>
</td>
</tr>
</c:forEach>
</c:if>

</table>

</form></div>
    </div>
    <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
    <script>
    //JavaScript代码区域
    layui.use('element', function(){
      var element = layui.element;
      
    });
    </script>
    </body>
    </html>