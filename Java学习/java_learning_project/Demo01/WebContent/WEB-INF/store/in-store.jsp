<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>入库</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
  <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
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
            <dd><a href="">入库</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowOutStoreServlet">出库</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowSearchStoreServlet">查看库存</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowBackupFlowServlet">查看备件流水表</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowCheckStoreServlet">检查备件状态</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;"><center><h3>入库</h3></div>
     <br><br>
          <form class="layui-form" name="inform" action="${pageContext.request.contextPath }/InStoreServlet" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">备件名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" required  lay-verify="required" placeholder="请输入正确备件名" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">型号</label>
    <div class="layui-input-block">
      <input type="text" name="type" required  lay-verify="required" placeholder="请输入正确型号" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">单价</label>
    <div class="layui-input-block">
      <input type="text" name="price" required  lay-verify="required" placeholder="请输入单价" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">入库数量</label>
    <div class="layui-input-block">
      <input type="text" name="amount" required  lay-verify="required" placeholder="    >0" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">警戒数量</label>
    <div class="layui-input-block">
      <input type="text" name="deadline" required  lay-verify="required" placeholder="请输入警戒数量" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo"  onclick ="submit">确认入库 </button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<br><br><br><br><br>
<center>提示:入库备件型号需与名称匹配。
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
});
</script>
  </div>
  
</div>

<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
var msg="${msg}";
window.onload=function(){
	if(msg!=null && msg !="")
		alert(msg);
}
</script>
</body>
</html>
      