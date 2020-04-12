<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>设备维修管理系统</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
  <script src="${pageContext.request.contextPath }/layui/layui.js"></script>
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
            <dd><a href="${pageContext.request.contextPath }/ShowRepairServlet">添加报修信息</a></dd>
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
	    <table class="layui-hide" id="test" lay-filter="test"></table>
  </div>
</div>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="confirm" >确认</a>
</script>
<script>
layui.use('element', function(){
	  var element = layui.element;});
layui.use(['table', 'layer'], function(){
	  var table = layui.table;
	  var $ = layui.$;
	  var layer = layui.layer;
	  //已完成的维修任务
	  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath }/GetTmpSettleServlet'
	    ,title:'已完成维修任务'
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,cols: [[
	      {field:'fix_number', title: '维修编号', sort: true}
	      ,{field:'fix_money', title: '维修费用'}
	      ,{field:'material_money', title: '材料费用'}
	      ,{field:'total_money', title: '总费用'}
	      ,{field:'settle_time', title: '结算时间'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
	    ]]
	  ,page: true
	  });
	  
	  table.on('tool(test)', function(obj){
		  var data = obj.data;
		    if(obj.event === 'confirm'){
		      layer.confirm('真的确定吗', function(index){
		    	  $.ajax({
                    url:'${pageContext.request.contextPath }/AddSettleServlet',
                    type:'get',
                    data:{
                    	'fix_number':data.fix_number,
                    	'fix_money': data.fix_money,
                    	'material_money': data.material_money,
                    	'total_money': data.total_money,
                    	'settle_time': data.settle_time,
                    },
                    success:function(suc){
                        if(suc=="ok"){
                            obj.del(); 
                            layer.close(index);
                            layer.msg("操作成功",{icon:1});
                        }
                        else{
                            layer.msg("操作失败",{icon:5});
                        }
                    }
                });
		        layer.close(index);
		      });
		    }
      });
});
</script>
</body>
</html>
