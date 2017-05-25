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
<title>error</title>
<meta name="keywords" content="Marilyzj管理后台">
<meta name="description" content="Marilyzj管理后台">

<link href="css/bootstrap.min14ed.css" rel="stylesheet">
<link href="css/font-awesome.min93e3.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css" rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="middle-box text-center animated fadeInDown">
		<h1>400</h1>
		<h3 class="font-bold">用户名或密码错误</h3>

		<div class="error-desc">
			<br />您可以返回主页看看 <br /> <a href="<%=path %>/index.jsp"
				class="btn btn-primary m-t">主页</a>
		</div>
	</div>
</body>
</html>
