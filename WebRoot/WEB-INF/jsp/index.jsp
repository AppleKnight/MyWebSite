<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("base", request.getContextPath());
	request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
	request.setAttribute("cssPath", request.getContextPath()+"/resources/css");
	request.setAttribute("imgPath", request.getContextPath()+"/resources/img");
%>

<%
	/* String ip = request.getRemoteAddr();
	com.wat.domain.UserInfo user =(com.wat.domain.UserInfo)request.getSession().getAttribute("user");
	user.setUserIPAddr(ip); */
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
		a.gap:hover,a.gap:FOCUS{
			color: #9d9d9d !important;
			background-color: #333333 !important;
		}
		.brand{
		    color: #fff !important;
		}
		.navbar-nav > li >a:not(.gap):HOVER,a:not(.gap):FOCUS {
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
					url:"${base}/promiseMe",
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
			
			$("#buildpage").click(function(){
				$.ajax({
					url:"${base}/buildpage",
					data:{},
					success:function(result){
						console.warn(result);
					}
				});
			});
			
			$("#login").click(function(){
				layer.msg('站长在找工作ing，后期功能会全部更新维护~',{icon:2,time:3000});
				/* $.ajax({
					url:"${base}/login",
					data:{},
					success:function(result){
					
					}
				});*/
			}); 
			
		});
		
	</script>
</head>
<body>
		<nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <a class="navbar-brand brand" href="javascript:;">老哥666 Success</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a>首页</a></li>
                <li><a href="#about">聊天室</a></li>
                <li><a id="promiseMe" href="#">点赞</a></li>
                <li><a id="buildpage" href="#">FreeMaker</a></li>
                <li><a href="#contact">IP：${user.userIPAddr }</a></li>
                <li><a class="gap">|</a></li>
                <c:choose>  
				   <c:when test="${user.openID != '' && user.openID != null && user.openID != undefind}">
	                <li><img style="    border-radius: 50px;width: 50px;" class="img-responsive" alt="" src="${user.headImg }" /></li>
	                <li><a href="${base }/personal">${user.nickName }</a></li>
	                <li><a href="#">登出</a></li>
				   </c:when>  
				   <c:otherwise>  
	                <li><a style="width:50px;height:50px;" title="QQ登录" href="${base }/beforeQQLogin"><img class="img-responsive" alt="" src="${imgPath }/qqlogin.png" /></a></li>
	                <li><a id="login" href="javascript:;">登录</a></li>
	                <li><a href="#">注册</a></li>
				   </c:otherwise>  
				</c:choose>
              </ul>
          </div>
        </nav>
	<div class="container">
		<img class="img-responsive" alt="" src="${imgPath }/003.jpg" />
	</div>
</body>
</html>
