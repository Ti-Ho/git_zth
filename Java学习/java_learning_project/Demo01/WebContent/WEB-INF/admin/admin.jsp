<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Admin's Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/js/admin.js"></script>
</head>
<!-- 修改用户信息 -->
<div id="useredit" style="display: none">
	<form class="layui-form" action="" lay-filter="usereditform">
		<div class="layui-form-item">
		<br>
			<label class="layui-form-label">账号: </label>
			<label></label>
			<div class="layui-input-inline">
      			<input type="text" name="account" id ="account" lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码: </label>
			<div class="layui-input-inline">
      			<input type="text" name="password" id ="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色: </label>
    		<div class="layui-input-inline">
     			<select name="role" id = "role">
        			<option value="客服" selected="">客服</option>
        			<option value="任务调度人员">任务调度人员</option>
        			<option value="技术工程师">技术工程师</option>
        			<option value="库管">库管</option>
        			<option value="财务">财务</option>
      			</select>
    		</div>
    	</div>
	</form>
</div>
<!-- 添加用户 -->
<div id="useradd" style="display: none">
	<form class="layui-form" action="" lay-filter="useraddform">
		<div class="layui-form-item">
		<br>
			<label class="layui-form-label">账号: </label>
			<div class="layui-input-inline">
      			<input type="text" name="account-add" id = "account-add"lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码: </label>
			<div class="layui-input-inline">
      			<input type="text" name="password-add" id = "password-add" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色: </label>
    		<div class="layui-input-inline">
     			<select name="role-add" id = "role-add">
        			<option value="客服" selected="">客服</option>
        			<option value="任务调度人员">任务调度人员</option>
        			<option value="技术工程师">技术工程师</option>
        			<option value="库管">库管</option>
        			<option value="财务">财务</option>
      			</select>
    		</div>
    	</div>
	</form>
</div>
<body class="layui-layout-body">

	<input type="hidden" id="path" value="${pageContext.request.contextPath}">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">设备维修管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="pictures/guanliyuan.png" class="layui-nav-img"> 管理员
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath }/index.jsp">退出登录</a>
						</dd>
					</dl></li>
			</ul>
		</div>
		<div >
		
			<form class="layui-form">
				<div class="layui-form-item">
				<br>
   					<label class="layui-form-label">搜索角色</label>
    				<div class="layui-input-inline">
      				<select name="quiz1" id = "demoReload">
      				<option value="" selected="">全部人员</option>
        			<option value="客服" >客服</option>
        			<option value="任务调度人员">任务调度人员</option>
        			<option value="技术工程师">技术工程师</option>
        			<option value="库管">库管</option>
        			<option value="财务">财务</option>
      				</select>
   				 	</div>
   				
    		
				<button class="layui-btn " onclick="return false;"
					data-type="reload" id="selectbyCondition">搜索</button>
					 </div>
					</form>
		</div>
			<table id="demo" lay-filter="test"></table>
			
		</div>

<!-- 每行按钮 -->
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- 表格上方按钮 -->
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="addData">添加用户</button>
  </div>
</script>
</body>
</html>