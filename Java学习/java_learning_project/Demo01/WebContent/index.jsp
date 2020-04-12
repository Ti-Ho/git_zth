<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- head -->
<head>
  <meta charset="utf-8">
  <title>登入</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/style/admin.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layui/style/login.css" media="all">
  <link id="layuicss-layer" rel="stylesheet" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/verification.css">
</head>
 
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
 
<body cz-shortcut-listen="true" class="layui-layout-body">

<form name = "hform">
	<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login">
	<div class="layadmin-user-login-main">
      <div class="layadmin-user-login-box layadmin-user-login-header">
        <h2>设备维修管理系统</h2>
      </div>
      <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
          <input type="text" name="account" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
        </div>
        <div class="layui-form-item">
          <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
          <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
        </div>
        
        <div class="layui-layer-move">
        	<div class="code">
            	<input type="text" value="" placeholder="请输入验证码（不区分大小写）" class="input-val">
            	<canvas id="canvas" width="100" height="36"></canvas>
        	</div>
        </div>
        <br>
        <div class="layui-form-item">
              <select name="role">
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
          <input type = "button" value = "登入" id ="btn" class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">
        </div>
      </div>
    </div>
  </div>
</form>

</body>
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>  
  <script>
    layui.use('form', function(){
      var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
      var $ = layui.$;
      form.render();
    }); 
    
   /*  var msg="${msg}";
    window.onload=function(){
    	alert(msg);
    	if(msg!=null && msg !="")
    		alert(msg);
    }; */
    $(function(){
        var show_num = [];
        draw(show_num);
 
        $("#canvas").on('click',function(){
            draw(show_num);
        })
        $("#btn").on('click',function(){
            var val = $(".input-val").val().toLowerCase();
            var num = show_num.join("");
            
            var account = document.hform.account.value;
            var password = document.hform.password.value;
            var role = document.hform.role.value;
			//alert(account);
			//alert(password);
			//alert(role);
            if(val==''){
                alert('请输入验证码！');
            }else if(val == num){
                //alert('提交成功！');
                $(".input-val").val('');
                $.ajax({
                    url:'${pageContext.request.contextPath}/LoginServlet',
                    type:'get',
                    data:{'account':account,'password':password,'role':role},
                    success:function(suc){
                    	//alert(suc);
                            if(suc == "0"){
                            //	alert("111");
                           	 	window.location.href="${pageContext.request.contextPath}/ShowMainServlet";
                            }else if(suc=="1"){
                            	window.location.href = "${pageContext.request.contextPath }/ShowAllTasksServlet"
                            }else if(suc=="2"){
                            	window.location.href = "${pageContext.request.contextPath }/ShowTechServlet?fix_people="+account;
                            }else if(suc=="3"){
                            	window.location.href = "${pageContext.request.contextPath }/ShowStoreServlet"
                            }else if(suc=="4"){
                            	window.location.href = "${pageContext.request.contextPath }/ShowAdminServlet"
                            }else if(suc=="5"){
                            	window.location.href = "${pageContext.request.contextPath }/ShowFinanceServlet"
                            }else{
                            	alert("你输入的账号或密码不正确,请重新输入!");
                            }
                    }
                });
               
                draw(show_num);
            }else{
                alert('验证码错误！请重新输入！');
                $(".input-val").val('');
                draw(show_num);
            }
        });
    })
 
    function draw(show_num) {    // 把随机得到得数放入show_num[]中
        var canvas_width=$('#canvas').width();
        var canvas_height=$('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度
        
        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标 (固定)
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标 (随机)
            context.font = "bold 23px 微软雅黑";
 
            context.translate(x, y);
            context.rotate(deg);
 
            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);
 
            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }
    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
</script>
</html>