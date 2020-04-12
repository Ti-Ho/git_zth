layui.use(['table', 'form', 'element', 'layer'], function(){
	var PATH = document.getElementById("path").value
		,table = layui.table
		,form = layui.form
		,element = layui.element
		,layer = layui.layer;
	//表格渲染
	table.render({
		elem: '#demo'
		,height: 560
		,url: PATH + '/GetAllAdminServlet' 
		,toolbar: '#toolbarDemo'
		,defaultToolbar:['filter', 'print']
		,cols: [[
			{field: 'account', title: '账号', sort: true}
			,{field: 'password', title: '密码'}
			,{field: 'role', title: '角色', sort:true}
			,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:120}
		]]
    	,id: "testReload",
    	page: false
	});
	//查询
	var $ = layui.$, active = {
			reload: function () {
            var demoReload = $('#demoReload');
            table.reload('testReload', {
            	url: PATH + '/GetAllAdminServlet',
                where: {
                   role: demoReload.val()
                }
             });
          }
	}
	$('#selectbyCondition').on('click', function () {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
	//表格上方按钮事件
	table.on('toolbar(test)', function(obj){
		if (obj.event == 'addData') {
			layer.open({
	  			type: 1,
	  			tile: "添加用户",
	  			area: ['400px','500px'],
	  			content: $('#useradd'),
	  			btn: ['确认', '取消'],
	  			yes: function(index, layero){
	     		   $.ajax ({
	     			   url: PATH+'/AddAdminServlet',
	     			   target: 'get',
	     	    	   data: {
	     	    		   'account': $('#account-add').val(),
	     	    		   'password': $('#password-add').val(),
	     	    		   'role': $('#role-add').val(),
	     	    	   },
	     	    	   success:function(res) {
	     	    		   if (res == "ok") {
	     	    			   layer.close(index);
	     	 					table.reload('testReload', {page:{curr:1}});
	     	    		   }
	     	    	   }
	     		   }); 
	     	   }
	  		});
	    }
	});
	//表格每行按钮事件
	table.on('tool(test)', function(obj){
		var data = obj.data;
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				$.ajax({
					url:PATH+'/DeleteAdminServlet',
					target: 'get',
					data: {'account':data.account},
					success:function(suc) {
						if (suc == "ok"){
							obj.del();
							layer.close(index);
							layer.msg("删除成功", {icon:1});
						} else {
							layer.msg("删除失败", {icon:5});
						}
					}
				}); 
				layer.close(index);     
			});
		} else if(obj.event === 'edit'){
			layer.open({
				type: 1,
				area: ['400px', '480px'],
				title: "编辑信息",
				content: $('#useredit'),
				btn:['confirm', 'cancle'],
				yes: function(index, layero){
					$.ajax ({
						url: PATH+'/UpdateAdminServlet',
						target: 'get',
						data: {
							'account': $('#account').val(),
							'password': $('#password').val(),
							'role': $('#role').val(),
						},
						success:function(res) {
							if (res == "ok") {
								layer.close(index);
								table.reload('testReload', {page:{curr:1}});
							}
						}
					}); 
				}
			}); 
			
			form.val("usereditform", {
				"account": data.account 
			});
		}
	}); 
});