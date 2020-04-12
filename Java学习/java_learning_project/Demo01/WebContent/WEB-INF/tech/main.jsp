<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>技术人员管理界面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
</head>
<div id = "divid" style = " display: none;">
<form class="layui-form"  method = "post" lay-filter="usereditform">
 <div class="layui-form-item">
  <div class="layui-inline">
      <label class="layui-form-label">维修编号</label>
      <div class="layui-input-inline">
        <input id = "id_number" name="number" lay-verify="required" readonly="默认维修编号" autocomplete="off" class="layui-input" type="text">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">维修人员</label>
      <div class="layui-input-inline">
        <input id = "id_fix_people" name="fix_people" lay-verify="required" autocomplete="off" class="layui-input" type="text">
      </div>
    </div>	
   	
   	<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">检测记录</label>
    <div class="layui-input-block">
      <textarea id = "id_detection_record" name="detection_record" lay-verify="required" autocomplete="off" class="layui-textarea"></textarea>
    </div>
  	</div>
   	
   	 <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">维修记录</label>
    <div class="layui-input-block">
      <textarea id = "id_fix_record" name="fix_record" lay-verify="required" autocomplete="off" class="layui-textarea"></textarea>
    </div>
  	</div>
   	
    
    <div class="layui-form-item">
    <label class="layui-form-label">工作量</label>
    
    <div class="layui-input-inline">
      <select id = "id_workload" name="workload" lay-verify="required" autocomplete="off">
        <option value="1">1day</option>
        <option value="2">2day</option>
        <option value="3">3day</option>
        <option value="4">4day</option>
        <option value="5">5day</option>
        <option value="6">6day</option>
        <option value="7">7day</option>
        <option value="8">8day</option>
        <option value="9">9day</option>
        <option value="10">10day</option>
        <option value="11">11day</option>
        <option value="12">12day</option>
        <option value="13">13day</option>
        <option value="14">14day</option>
        <option value="15">15day</option>
      </select>
    </div>
    </div>
    
    
    <div class="layui-form-item">
    <label class="layui-form-label">维修状态</label>
    
    <div class="layui-input-inline">
      <select id = "id_status" name="status" lay-verify="required" autocomplete="off">
        <option value="0">未分配</option>
        <option value="1">分配未检测</option>
        <option value="2">检测完成维修未完成</option>
        <option value="3">维修完成</option>
      </select>
    </div>
    </div>
    	
    	
  </div>
</form>
</div>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">设备维修管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item">
				<a href="javascript:;"> 
				<img src="pictures/gongchengshi.png" class="layui-nav-img"> ${param.fix_people}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/index.jsp">退出登录</a>
						</dd>
					</dl></li>
			</ul>
		</div>

       <form class="layui-form">
		<div class = "demoTable">
			搜索维修号：
			<div class="layui-inline">
				<input class="layui-input" name="id" id="demoReload" autocomplete="off">
			</div>
			<button class="layui-btn "  onclick="return false;" data-type="reload" id="selectbyCondition">搜索</button>
			<script type="text/html" id="barDemo">
  				<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  				<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
			</script>
		</div>

		<table class="layui-hide" id="test" lay-filter="test"></table>    
</form>
       
  
</div>
<script>
function getUrlParams(name) { // 不传name返回所有值，否则返回对应值
    var url = window.location.search;
    if (url.indexOf('?') == 1) { return false; }
    url = url.substr(1);
    url = url.split('&');
    var name = name || '';
    var nameres;
    // 获取全部参数及其值
    for(var i=0;i<url.length;i++) {
        var info = url[i].split('=');
        var obj = {};
        obj[info[0]] = decodeURI(info[1]);
        url[i] = obj;
    }
    // 如果传入一个参数名称，就匹配其值
    if (name) {
        for(var i=0;i<url.length;i++) {
            for (const key in url[i]) {
                if (key == name) {
                    nameres = url[i][key];
                }
            }
        }
    } else {
        nameres = url;
    }
    // 返回结果
    return nameres;
}
</script>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script>
var url=window.location.href;
var fix_people = getUrlParams("fix_people");
console.log(fix_people);
layui.use(['form','table','layedit', 'element'], function(){
	
  var table = layui.table;
  var form = layui.form;
  var $ = layui.$;
  var layedit = layui.edit;
  var element = layui.element;
  
  
  table.render({
    elem: '#test'
    ,url:'${pageContext.request.contextPath }/GetAllTechServlet'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
    ,cols: [[
      {field:'number', title: '维修编号', sort: true}
      ,{field:'fix_people',  title: '维修人员'}
      ,{field:'detection_record',  title: '检测记录'}
      ,{field:'fix_record', title: '维修记录'}
      ,{field:'workload', title: '工作量', sort:true} //minWidth：局部定义当前单元格的最小宽度
      ,{field:'status', title: '维修状态'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
     ]]
  	,id: 'testReload'
	,height: 500
	,page: true
	,limit: 10
	,where:{
		fix_people : fix_people
	}
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
	            number: demoReload.val()  //搜索number 将输入框的值赋给number
	        }
	      });
	    }
	  };
  
  $('#selectbyCondition').on('click', function(){
	   var type = $(this).data('type');
	   active[type] ? active[type].call(this) : '';
	});
  
  
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
	table.on('tool(test)', function(obj){    //删除
	    var data = obj.data;
	    //console.log(obj)
	  	var editList=[];
	  	$.each(data,function(name,value) {//循环遍历json数据
	        editList.push(value);//将json数据中的value放入数组中（下面的子窗口显示的时候要用到）
	    });
	  	/* console.log(editList); */
	    if(obj.event === 'del'){
	      layer.confirm('确认删除维修编号为 '+ data.number + ' 的维修记录？', function(index){
	    	  $.ajax({
                    url:'${pageContext.request.contextPath }/DeleteTechServlet',
                    type:'get',
                    data:{'number':data.number},//向服务端发送删除的id
                    success:function(suc){
                            obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                            layer.close(index);
                            console.log(index);
                            layer.msg("删除成功",{icon:1});
                    }
                });
	        layer.close(index);
	      });//////////////////////////////////////////////////////////////////////////////
	    } else if(obj.event === 'edit'){    //编辑
	    	layer.open({
				type: 1,
				area: ['500px', '580px'],
				title: "编辑维修信息",
				content: $('#divid'),
				btn:['confirm', 'cancle'],
				yes: function(index, layero){
					$.ajax ({
						url: '${pageContext.request.contextPath }/UpdateTechServlet',
						target: 'get',
						data: {
							'number': $('#id_number').val(),
							'fix_people': $('#id_fix_people').val(),
							'detection_record': $('#id_detection_record').val(),
							'fix_record': $('#id_fix_record').val(),
							'workload': $('#id_workload').val(),
							'status': $('#id_status').val(),
						},
						success:function(res) {
								layer.close(index);
								table.reload('testReload', {page:{curr:1}});
								$("#divid")[0].reset();
						}
					}); 
				}
			});
			
			form.val("usereditform", {
				"number": data.number, 
				'fix_people': data.fix_people,
				'detection_record': data.detection_record,
				'fix_record': data.fix_record,
				'workload': data.workload,
				'status': data.status
			});
	    }
	  });
  
});

</script>
</body>
</html>