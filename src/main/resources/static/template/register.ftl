<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>接口测试平台</title>
<link rel="stylesheet" type="text/css" href="/lemon/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
.tips_dd_init{
		display:none;
} 
</style>
<script src="/lemon/js/jquery-1.11.3.js"></script>
<script src="/lemon/js/Particleground.js"></script>
<script type="text/javascript" src="/lemon/js/jquery.md5.js" charset="UTF-8"></script>
<script type="text/javascript" src="/lemon/js/common.js" charset="UTF-8"></script>
<script>
function checkEmail(){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
	var username = $("#username").val();
	if($.trim(username)==""){
		$(".tips_dd_init").show();
		$("p.tips").html("用户名不能为空");
		return false;
	}
	var result = reg.test(username);
	if(result==false){
		$(".tips_dd_init").show();
		$("p.tips").html("非法的邮件格式");
		return false;
	}
	var checkRepeatUrl = lemon.config.global.rootUrl + "/user/find";
	var checkpass = false;
	var tips=null;
	$.ajax({
		type : "POST",
		url : checkRepeatUrl,
		data : {
			username:username
		},
		dataType:'json',
		async:false,
		success : function(ret) {
			if(ret.status!="1"){
                checkpass=false;
				tips=ret.message;
				return checkpass;
			}else {
                checkpass=true;
                return  checkpass;
            }

		}
	});
	//已注册则提示用户更换用户名
	if(checkpass == false){
		$(".tips_dd_init").show();
		$("p.tips").html(tips);

	}
	return checkpass;
}

function checkPassword(){
	var password = $("#password").val();
	if($.trim(password)==""){
		$(".tips_dd_init").show();
		$("p.tips").html("密码不能为空");
		return false;
	}
	if($.trim(password).length<6){
		$(".tips_dd_init").show();
		$("p.tips").html("密码长度至少为6位");
		return false;
	}
}
function checkPwdConfirm(){
	var pwdconfirm = $("#pwdconfirm").val();
	if($.trim(pwdconfirm)==""){
		$(".tips_dd_init").show();
		$("p.tips").html("重复密码不能为空");
		return false;
	}
	var password = $("#password").val();
	if(pwdconfirm!==password){
		$(".tips_dd_init").show();
		$("p.tips").html("密码不一致");
		return false;
	}
}
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  
  //绑定事件
  $("#username").blur(function(){
	  checkEmail(); 
  });
  $("#password").blur(function(){
	  checkPassword(); 
  });
  $("#pwdconfirm").blur(function(){
	  checkPwdConfirm(); 
  });
  //注册
  $(".submit_btn").click(function(){
	  	if(checkEmail()==false){
            alert(11);
			return false;
		}
		if(checkPassword()==false){
            alert(22);
			return false;
		}
		if(checkPwdConfirm()==false){
            alert(33);
			return false;
		}
		var addUrl = lemon.config.global.rootUrl + "/user/register";
		$.ajax({
			type : "POST",
			url : addUrl,
			data : {
				username:$.trim($("#username").val()),
				password:$.trim($.md5($("#password").val())),
			},
			dataType:'json',
			async:false,
			success : function(result) {
				if(result.status=="1"){
					alert("注册成功");
					window.location.href=lemon.config.global.rootUrl
							+ "/user/tologin";
				}else{
					$(".tips_dd_init").show();
					$("p.tips").html(result.message);
				}
			}
		});
  });
});
</script>
</head>
<body>
<form action="">
	<dl class="admin_login">
		 <dt>
		  <strong>接口测试平台</strong>
		  <em>Management System</em>
		 </dt>
		 <dd class="user_icon">
		  <input type="text" placeholder="账号" class="login_txtbx" id="username"/>
		 </dd>
		 <dd class="pwd_icon">
		  <input type="password" placeholder="密码" class="login_txtbx" id="password"/>
		 </dd>
		 <dd class="pwd_icon">
		  <input type="password" placeholder="重复密码" class="login_txtbx" id="pwdconfirm"/>
		 </dd>
		 <dd class="tips_dd_init">
				<p class="tips" style="color:red"></p>
		 </dd>
		 <dd>
		  <input type="button" value="立即注册" class="submit_btn"/>
		 </dd>
		 <dd>
		  <p>已有账号？<a href="login.ftl" style="text-decoration:underline;"><strong>去登录</strong></a></p>
		 </dd>
	</dl>
</form>
</body>
</html>
