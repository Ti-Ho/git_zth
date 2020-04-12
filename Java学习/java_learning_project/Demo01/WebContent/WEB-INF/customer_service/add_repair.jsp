<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>设备维修管理系统</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
  <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
</head>
<body class="layui-layout-body" >
<div class="layui-layout layui-layout-admin" >
  <div class="layui-header">
    <div class="layui-logo">设备维修管理系统</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="pictures/kefu.png" class="layui-nav-img">
          客服
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${pageContext.request.contextPath}/index.jsp">退出登录</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree"  >
      <li class="layui-nav-item">
          <a href="${pageContext.request.contextPath }/ShowMainServlet">首页</a>
       </li>
       <li class="layui-nav-item">
          <a href="${pageContext.request.contextPath }/ShowClientServlet">客户管理</a>
       </li>
         <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">报修管理</a>
          <dl class="layui-nav-child">
            <dd><a href="">添加报修信息</a></dd>
            <dd><a href="${pageContext.request.contextPath }/ShowRepairNotSubmitServlet">查看未提交报修信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
        <a href="${pageContext.request.contextPath }/ShowSettleServlet">结算</a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
	    <form class="layui-form" action="${pageContext.request.contextPath }/AddRepairServlet" method = "post">
	    <br><br>
  <div class="layui-form-item">
  
    <label class="layui-form-label">身份证号</label>
    <div class="layui-input-block">
      <input type="text" name="id_number" lay-verify="client_number" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">产品类型</label>
    <div class="layui-input-block">
      <select name="product_type" lay-verify="city">
        <option value=""></option>
        <option value="台式机">台式机</option>
        <option value="笔记本">笔记本</option>
        <option value="投影仪">投影仪</option>
        <option value="打印机">打印机</option>
        <option value="其他">其他</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">故障现象</label>
    <div class="layui-input-block">
      <input type="text" name="fault_phenomena"  lay-verify="fault_phenomena" placeholder="请输入故障现象" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">故障类型</label>
    <div class="layui-input-block">
      <select name="fault_type" lay-verify="fault_type">
        <option value=""></option>
        <option value="固定性故障">固定性故障</option>
        <option value="间歇性故障">间歇性故障</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
	   	<input type = "submit" value = "立即提交" class="layui-btn"  lay-filter="formDemo">
     	<input type = "reset" value = "重置" class = "layui-btn layui-btn-primary">
    </div>
  </div>
</form>
  </div>
</div>

<script>
 layui.use('element', function(){
  var element = layui.element;
  
 });
 layui.use('form', function(){
	  var form = layui.form;});
 var msg="${msg}";
 window.onload=function(){
 	if(msg!=null && msg !="")
 		alert(msg);
 }
</script>
</body>
</html>