    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
      <title>分配维修任务</title>
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
              任务管理员
            </a>
            <dl class="layui-nav-child">
              <dd><a href="${pageContext.request.contextPath }/index.jsp">退出登录</a></dd>
            </dl>
          </li>
        </ul>
      </div>
     
      <table id="demo" lay-filter="test"></table>
 

        <div style="padding: 15px;"><script src="/layui/layui/layui.js"></script>
        <form name="input" action="${pageContext.request.contextPath }/ShowAllTasksServlet"method="post">
<table class="layui-table"border="1" cellspacing="0" width="80%"  align="center">
<caption><h1>查询结果</h1></caption><br>
<tr><th>维修编号</th><th>维修人员</th><th>检测记录</th><th>维修记录</th><th>工作量</th><th>维修状态</th><th>操作</th></tr>
<c:if test="${fix==null }">
<tr><td colspan="6"><font color="red">没有符合条件的数据</font></td></tr>
</c:if>
<c:if test="${fix!=null }">

<tr><td>${fix.number }</td>
<td>${fix.fix_people }</td>
<td>${fix.detection_record }</td>
<td>${fix.fix_record }</td>
<td>${fix.workload}</td>
<td>${fix.status}</td>
<td>
<a href="${pageContext.request.contextPath }/GetTaskByNumberServlet?number=${item.number}">修改</a>
<a href="${pageContext.request.contextPath }/DeleteTaskServlet?number=${item.number }">删除</a>
</td>
</tr>
</c:if>

</table>
<br>
<center><input type="submit" value="返回"></center>
</form>
      </div>
      
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