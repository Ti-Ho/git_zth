<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>入库</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">设备维修管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="pictures/kuguan.png" class="layui-nav-img">
          库管
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${pageContext.request.contextPath }/index.jsp">退出登录</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath }/ShowStoreServlet">首页</a></li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">备件管理</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath }/ShowInStoreServlet">入库</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowOutStoreServlet">出库</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowSearchStoreServlet">查看库存</a></dd>
            <dd><a href="">查看备件流水表</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowCheckStoreServlet">检查备件状态</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
      
      <div class="layui-body">
      <table id="demo" lay-filter="test"></table>
 

        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><script src="./layui/layui.js"></script>
        <form>
<table class="layui-table"border="1" cellspacing="0" width="80%"  align="center">
<caption><h1>备件流水信息</h1></caption>
<tr><th>备件编号</th><th>备件型号</th><th>维修编号</th><th>出库量</th><th>单价</th><th>出库时间</th></tr>

<c:if test="${list==null }">
<tr><td colspan="6"><font color="red">没有符合条件的数据</font></td></tr>
</c:if>
<c:if test="${list!=null }">
<c:forEach items="${list }" var="item">
<tr><td>${item.name}</td>
<td>${item.type }</td>
<td>${item.fixNumber}</td>
<td>${item.amount }</td>
<td>${item.price}</td>
<td>${item.outTime}</td>
</tr>
</c:forEach>
</c:if>

</table>
</form></div>
      </div>
    </div>
    <script src="${pageContext.request.contextPath }/layui/layui/layui.js"></script>
    <script>
    //JavaScript代码区域
    layui.use('element', function(){
      var element = layui.element;
      
    });
    </script>
    </body>
    </html>