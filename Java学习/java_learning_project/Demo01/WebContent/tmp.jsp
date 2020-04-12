<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登入 - layuiAdmin</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/style/admin.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/style/login.css" media="all">
</head>

<body>
  <form action = "LoginServlet" method = "post">
  <div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>设备维修管理系统</h2>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="account" id="LAY-user-login-username" lay-verify="required" placeholder="账号" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
        </div>
        <div class="layui-form-item">
          <div class="layui-row">
            <div class="layui-col-xs7">
              <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
              <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
            </div>
            <div class="layui-col-xs5">
              <div style="margin-left: 10px;">
                <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
              </div>
            </div>
          </div>
        </div>
        <div class="layui-form-item">
              <select name="role" id = "LAY-user-login-user">
                <option value="" selected="true">请选择角色</option>
                <option value="管理员" >管理员</option>
                <option value="客服">客服</option>
                <option value="任务调度人员">任务调度人员</option>
                <option value="技术工程师">技术工程师</option>
                <option value="库管">库管</option>
                <option value="财务">财务</option>
              </select>
        </div>
        <div class="layui-form-item">
          <input type = "submit" value = "登入" class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">
        </div>
      </div>
    </div>    
    <div class="layui-trans layadmin-user-login-footer">
      <p>© 2019 Design by software</p>
    </div> 
  </div>
  </form>


  <script src="${pageContext.request.contextPath }/layui/layui.js"></script>  
  <script>
    layui.use('form', function(){
      var form = layui.form;
      form.render();
    }); 
    var msg="${msg}";
    window.onload=function(){
    	if(msg!=null && msg !="")
    		alert(msg);
    }
</script>

</body>
</html>