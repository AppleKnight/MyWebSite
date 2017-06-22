<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("base", request.getContextPath());
	request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
	request.setAttribute("cssPath", request.getContextPath()+"resources/css");
	request.setAttribute("imgPath", request.getContextPath()+"resources/img");
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	
	<link rel="stylesheet" href="${cssPath }/bootstrap.min.css"/>
	
	
	<script type="text/javascript" src="${jsPath }/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${jsPath }/bootstrap.min.js"></script>
</head>
<body>
	<img class="img-responsive" alt="" src="${imgPath }/YX-007.jpg" />
</body>
</html>
