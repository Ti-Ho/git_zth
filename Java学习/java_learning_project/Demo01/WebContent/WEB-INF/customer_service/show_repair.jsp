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
<input type="hidden" id="path" value="${pageContext.request.contextPath}">

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
  <!--左侧框架-->
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
            <dd><a href="">查看未提交报修信息</a></dd>
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
  <a class="layui-btn layui-btn-xs" lay-event="submit">立即提交</a>
</script>
<script>
layui.use(['table', 'layer','form','element'], function(){
	  var element = layui.element;
	  var form = layui.form;
	  var table = layui.table;
	  var layer = layui.layer;
	  var $ = layui.$;
	  //表格展示
	  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath }/GetRepairServlet'
	    ,cellMinWidth: 80 
	    ,title:'未提交任务'
	    ,height:570
	    ,page: { 
	        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] 
	        ,groups: 1 
	        ,first: false 
	        ,last: false 
	        
	      }
	    ,cols: [[
	      {field:'number',  title: '维修编号', sort: true}
	      ,{field:'client_number',  title: '报修人'}
	      ,{field:'product_type', title: '产品型号'}
	      ,{field:'fault_phenomena',  title: '故障现象'}
	      ,{field:'fault_type', title: '故障类型'}
	      ,{field:'time', title: '时间'}
	      ,{field:'status', title: '状态'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:270}
	    ]]
	  });
	  //监听删除和编辑
	  table.on('tool(test)', function(obj){
		  var data = obj.data;
		    if(obj.event === 'submit'){
		    	layer.open({
		    		type:0,
		    	    content:"确定提交吗",
		    	    btn:['确认','取消'],
		    	    area:['200px','200px'],
		    	    yes:function(index,layero){
		    	    	$.ajax({
		                      url:'${pageContext.request.contextPath }/SubmitFixServlet',
		                      type:'get',
		                      data:{'number':data.number},
		                      success:function(suc){
		                          if(suc=="ok"){
		                              obj.del(); 
		                              layer.close(index);
		                              console.log(index);
		                              layer.msg("提交成功",{icon:1});
		                          }
		                          else{
		                              layer.msg("修改失败",{icon:5});
		                          }
		                      }
		    	    });
		    }
		  });
	      }
	  });
});

</script>
</body>
</html>
