<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<meta name="keywords" content="Marilyzj管理后台">
<meta name="description" content="Marilyzj管理后台">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min93e3.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
<link href="css/login.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<style>
body.signin {
	color: rgb(41, 138, 138);
}
</style>
<script>
function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	if(username.length == 0  ){
		//alert("请您输入正确的用户名 ！");|| !/^[\da-zA-Z_\u4e00-\u9fa5]{2,16}$/.test(username)
		yanzheng($("#username"));
		return false;
	}
	if(password.length == 0){
		//alert("您的密码输入错误 ！");||!/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,15}$/.test(password)
		yanzheng($("#password"));
		return false;
	}else{
	$("#form").submit();
	return true;	
	}
}
function yanzheng($this){
	var tip = $this.attr("tip");
	//alert(tip);
	$("#tips").text(tip).css("color","rgb(26,140,255)");
};
</script>

</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<div class="logopanel m-b">
						<h1>Marilyzj</h1>
					</div>
					<div class="m-b"></div>
					<h4>
						欢迎使用 <strong>Marilyzj管理后台</strong>
					</h4>
					<!--  <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
				</div>
			</div>
			<div class="col-sm-5">
				<form method="post" action="<%=path %>/UserServlet?method=login" id="forms" onsubmit="return login()">
					<h4 class="no-margins" id="tips">登录：</h4>

					<p class="m-t-md">登录到Marilyzj管理后台</p>
					<input type="text" id="username" class="form-control uname"
						placeholder="用户名" tip="请输入正确的帐号" name="username"/> 
					<input type="password" id="password" class="form-control pword m-b" placeholder="密码"
						tip="请输入正确的密码" name="password"/> 
						<!--  <a href="#">忘记密码了？</a>  -->
					<button class="btn btn-success btn-block" onclick="login()">登录</button>
				</form>
			</div>
		</div>
		<div class="signup-footer">
			<div class="pull-left">&copy; 2017 All Rights Reserved</div>
		</div>
	</div>
</body>
</html>
