<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>备件管理首页</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
  <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
</head>
<body class="layui-layout-body" >
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
            <dd><a href="${pageContext.request.contextPath }/ShowCheckStoreServlet">检查备件状态</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;"><center><h3>欢迎使用备件管理系统！</h3></div>
    <div class="layui-tab">
  <ul class="layui-tab-title">
    <li class="layui-this">提示	</li>
    <li>需求备件种类</li>
    <li>备件单价变化情况</li>
    <li>库存警戒数量</li>
    <li>仓库最大库存</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">本页面为备件管理分系统的主页面，在这个界面您可以从左侧导航栏中选择您需要使用的功能<br>也可以选择回到主界面，或者直接在其他标签下查询您所需要的信息。</div>
    <div class="layui-tab-item">螺母<br>螺丝<br>主板<br></div>
     <div class="layui-tab-item">近期本公司所需的备件单价变量较小。</div>
    <div class="layui-tab-item">螺母:        20<br>螺丝:        20<br>主板:       5<br></div>
    <div class="layui-tab-item">螺母:300<br>螺丝:300<br>主板:50<br></div>
  </div>
</div>
 
<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
  
  //…
});
</script>
  </div>
  
</div>

<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>
      