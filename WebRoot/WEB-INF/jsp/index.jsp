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
	<style type="text/css">
		.navbar-nav > li >a:HOVER {
		    color: #fff;
    		background-color: #080808 !important;
		}
		.navbar-nav > li >a:FOCUS {
			color: #fff;
    		background-color: #080808 !important;
		}
		.navbar-inverse {
		    background-color: #333333;
		    border-color: #333333;
		}
	</style>
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
		
		<nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <a class="navbar-brand" href="#">老哥666</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                <li><a href="#about">聊天室</a></li>
                <li><a id="promiseMe" href="#">点赞</a></li>
                <li><a href="#contact">作者</a></li>
                <li><a href="#contact">IP：${ipAddr }</a></li>
              </ul>
            </div>
          </div>
        </nav>
		
		<img class="img-responsive" alt="" src="${imgPath }/003.jpg" />
	</div>
</body>
</html>
