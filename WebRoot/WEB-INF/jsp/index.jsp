<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("base", request.getContextPath());
	request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
	request.setAttribute("cssPath", request.getContextPath()+"/resources/css");
	request.setAttribute("imgPath", request.getContextPath()+"/resources/img");
%>

<%
	String ip = request.getRemoteAddr();
	request.setAttribute("ipAddr", ip);
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>老哥666</title>
	
	<link rel="stylesheet" href="${cssPath }/bootstrap.min.css"/>
	
	
	<script type="text/javascript" src="${jsPath }/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${jsPath }/bootstrap.min.js"></script>
	<script type="text/javascript" src="${jsPath }/layer/layer.js"></script>
	<script type="text/javascript">
		/* 初始化时执行 */
		$(function(){
			
			$("#promiseMe").click(function(){
				$.ajax({
					url:"promiseMe.do",
					data:{},
					success:function(result){
						if(result === '1'){
							layer.msg('谢谢您！~',{icon:1,time:1500});
						}else{
							layer.msg('好像没赞赏成功哦~',{icon:2,time:1500});
						}
					}
				});
			});
			
		});
		
	</script>
</head>
<body>
	<div class="container">
		<img class="img-responsive" alt="" src="${imgPath }/003.jpg" />
		<!-- ip address -->
		<div class="row" style="margin:20px;">
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				您当前的IP为：${ipAddr }
			</div>
			<div class="col-xs-4"></div>
		</div>
		<!-- function -->
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4  col-sm-offset-1">
				<input id="promiseMe" class="btn btn-success" type="button" value="点　赞"/>
			</div>
			<div class="col-xs-4"></div>
		</div>
	</div>
</body>
</html>
