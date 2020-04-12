<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>检查库存状态</title>
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
            <dd><a href="${pageContext.request.contextPath }/ShowBackupFlowServlet">查看备件流水表</a></dd>
            <dd><a href="">检查备件状态</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <div style="padding: 15px;"><center><h3>查询库存</h3></div>
     <br><br>
          <form class="layui-form" name="checkform" action="${pageContext.request.contextPath }/CheckStoreServlet" method="post">
  <div class="layui-form-item">
    <label class="layui-form-label">备件名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" required  lay-verify="required" placeholder="请输入正确备件名称" autocomplete="on" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">型号</label>
    <div class="layui-input-block">
      <input type="text" name="type" required  lay-verify="required" placeholder="请输入正确备件型号" autocomplete="on" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo"  onclick ="submit">检查库存状态 </button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<br><br><br><br><br>
<center>提示:请注意输入的备件名称与型号需相对应。
 
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
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
      