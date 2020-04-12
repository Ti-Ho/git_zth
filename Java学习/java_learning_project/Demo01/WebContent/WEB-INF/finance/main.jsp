<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>财务管理界面</title>
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
          <img src="pictures/caiwu.png" class="layui-nav-img">
          财务
        </a>
        <dl class="layui-nav-child">
          <dd><a href="${pageContext.request.contextPath }/index.jsp">退出登录</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
	<form class="layui-form">
		<div class = "demoTable">
		<br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;搜索维修号：
			<div class="layui-inline">
				<input class="layui-input" name="id" id="demoReload" autocomplete="off">
			</div>
			<button class="layui-btn "  onclick="return false;" data-type="reload" id="selectbyCondition">搜索</button>
		</div>
		<table class="layui-hide" id="test" lay-filter="test"></table>    
	</form>
  </div>
 


<script>
		layui.use(['form','table', 'jquery', 'element'], function(){
				  var element = layui.element;
				  var table = layui.table;
				  var form = layui.form;
				  var $ = layui.jquery;
				  var layedit = layui.edit;
				  table.render({
				    elem: '#test'
				    ,url:'${pageContext.request.contextPath }/GetAllFinanceServlet'
				    ,cellMinWidth: 80
				    ,cols: [[
				      {field:'fix_number', title: '维修编号', sort: true}
				      ,{field:'fix_money', title: '维修费用'}
				      ,{field:'material_money', title: '材料费用'}
				      ,{field:'total_money', title:'结算费用'}
				      ,{field:'settle_time', title: '结算时间'}
				     ]]
				  	,id: 'testReload'
					,height: 500
					,page: true
					,limit: 10
				  });
				  
				  var active = {  //搜索更新刷新
					    reload: function(){
					      var demoReload = $('#demoReload');
						      //执行重载
					      table.reload('testReload', {
					        page: {
					          curr: 1 //重新从第 1 页开始
					        }
					        ,where: {
					            fix_number: demoReload.val()  
					        }
					      });
					    }
					  };
				  
				  $('#selectbyCondition').on('click', function(){
					   var type = $(this).data('type');
					   active[type] ? active[type].call(this) : '';
					});
				  
				});	
			</script>
</body>
</html>