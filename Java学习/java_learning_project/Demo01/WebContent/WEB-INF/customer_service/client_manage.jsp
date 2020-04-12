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
<!--弹出层1-->
<div id='addclient' style='display:none'>
   <form class="layui-form">
   <div class="layui-form-item">
    <label class="layui-form-label">身份证号</label>
    <div class="layui-input-inline">
      <input type="text" name="title" id='ID_number-add' required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">手机号</label>
    <div class="layui-input-inline">
      <input type="text" name="title" id='phone-add' required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="title" id='email-add' required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
   </div>
   </form>
</div>
<!--弹出层2-->
<div id='editclient' style='display:none'>
  <form>
   <br><br>
  <div class="layui-form-item">
 
    <label class="layui-form-label">手机号</label>
    <div class="layui-input-inline">
      <input type="text" name="title" id='phone-edit' required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-inline">
      <input type="text" name="title" id='email-edit' required  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    </div>
   </div>
  </form>
</div>
<body class="layui-layout-body" >

<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<!--顶层框架-->
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
          <a href="">客户管理</a>
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
  <form class="layui-form">
				<div class="layui-form-item">
				<br>
   					<label class="layui-form-label">搜索客户</label>
    				<div class="layui-input-inline">
      				<input type="text" name="title" id='demoReload' placeholder="请输入身份证号" class="layui-input">
   				 	</div>
				<button class="layui-btn " onclick="return false;"
					data-type="reload" id= "selectbyCondition">搜索</button>
				</div>
	</form>
	    <table class="layui-hide" id="test" lay-filter="test"></table>
  </div>

</div>

<!--按钮-->
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-xs" lay-event="add">新增</button>
  </div>
</script>
<!--按钮-->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
      //加载元素组件
	  //加载表格组件
layui.use(['table', 'layer','form','element'], function(){
	  var PATH = document.getElementById("path").value;
	  var element = layui.element;
	  var form = layui.form;
	  var table = layui.table;
	  var layer = layui.layer;
	  var $ = layui.$;
	  //表格展示
	  table.render({
	    elem: '#test'
	    ,url: PATH + '/GetAllClientsServlet'
	    ,cellMinWidth: 80 
	    ,toolbar: '#toolbarDemo'
	    ,title:'客户表'
	    ,height:570
	    ,page: { 
	        layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] 
	        ,groups: 1 
	        ,first: false 
	        ,last: false 
	        
	      }
	    ,cols: [[
	      {field:'number', title: '客户编号', sort: true}
	      ,{field:'ID_number', title: '身份证编号'}
	      ,{field:'phone', title: '手机号码'}
	      ,{field:'email', title: '邮箱'}
	      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:270}
	    ]]
	    ,id: "testReload"
	  });
	  
	  var active = {
				reload: function () {
		            var demoReload = $('#demoReload');
		            table.reload('testReload', {
		            	url: PATH + '/GetAllClientsServlet',
		                where: {
		                   ID_number: demoReload.val()
		                }
		             });
		          }
			}
	  $('#selectbyCondition').on('click', function () {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
	  //监听增加
	  table.on('toolbar(test)', function(obj){
		    if(obj.event == 'add'){
		    	layer.open({
		    		type:1,
		    		offset:'auto',
		    	    content: $('#addclient'),
		    	    btn: ['确认', '取消'],
		    	    area: ['400px','300px'],
		    	    yes:function(index,layero){
		    	    	$.ajax({
		                      url: PATH + '/AddClientServlet',
		                      type:'get',
		                      data:{'ID_number':$('#ID_number-add').val(),
		                    	  'phone':$('#phone-add').val(),
		                          'email':$('#email-add').val() 
		                      },
		                      success:function(suc){
		                          if(suc == "ok"){
		                              layer.close(index);
		                              layer.msg("增添成功",{icon:1});
		                              table.reload('testReload', {page:{curr:1}});
		                          }
		                          else{
		                              layer.msg("增添失败",{icon:5});
		                          }
		                     }
		    	       	});
		    		}
		  		});
		    }
	  });
	  //监听删除和编辑
	  table.on('tool(test)', function(obj){
		  var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		    	  $.ajax({
                      url:PATH + '/DeleteClientServlet',
                      type:'get',
                      data:{'ID_number': data.ID_number},
                      success:function(suc){
                          if(suc== "ok" ){
                              obj.del(); 
                              layer.close(index);
                              layer.msg("删除成功",{icon:1});
                          }
                          else{
                              layer.msg("删除失败, 该客户有未完成的业务",{icon:5});
                          }
                      }
                  });
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		    	layer.open({
		    		type:1,
		    	    content:$('#editclient'),
		    	    btn:['确认','取消'],
		    	    area:['400px','300px'],
		    	    yes:function(index,layero){
		    	    	$.ajax({
		                      url:PATH + '/UpdateClientServlet',
		                      type:'get',
		                      data:{'number': data.number,
		                    	  'ID_number': data.ID_number,
		                    	  'phone': $('#phone-edit').val(),
		                          'email': $('#email-edit').val(),
		                      },
		                      success:function(suc){
		                          if(suc == "ok"){
		                              layer.close(index);
		                              table.reload('testReload', {page:{curr:1}});
		                              layer.msg("修改成功",{icon:1});
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
