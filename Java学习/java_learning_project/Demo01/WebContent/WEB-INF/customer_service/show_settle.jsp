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
          <dd><a href="${pageContext.request.contextPath }/index.jsp">退出登录</a></dd>
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
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">立即处理</a>
</script>
<script>
layui.use('element', function(){
	  var element = layui.element;
});
layui.use(['table', 'form'], function(){
	  var table = layui.table;
	  var form = layui.form;
	  var $ = layui.$;
	  //已完成的维修任务
	  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath}/GetAllFixServlet'
	    ,title:'已完成维修任务'
	    ,cols: [[
	      {field:'number', title: '维修编号', sort: true}
	      ,{field:'fix_people', title: '维修人员'}
	      ,{field:'detection_record',  title: '检测记录'}
	      ,{field:'fix_record', title: '维修记录'}
	      ,{field:'workload', title: '工作量'}
	      ,{field:'status',  title: '状态'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
	    ]]
	  ,page: true
	  });
	  table.on('tool(test)', function(obj){
		  var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('确定结算吗？', function(index){
		    	  $.ajax({
                    url:'${pageContext.request.contextPath }/AddTmpSettleServlet',
                    type:'get',
                    data:{'number':data.number},
                    success:function(suc){
                    	//alert(suc);
                    	if (suc == "ok") {
                    		layer.close(index);
                        	window.location.href = "${pageContext.request.contextPath }/ShowResultSettleServlet"
                    	} else {
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
