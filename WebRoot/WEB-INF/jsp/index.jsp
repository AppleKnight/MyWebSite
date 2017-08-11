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
	<meta name="viewport" content="width=device-width,  initial-scale=1.0,maximum-scale=1.0">
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
		
		.icon-sn-qq{
			display: inline-block;
		    background-image: url(${imgPath}/icon-sn.svg);
		    background-repeat: no-repeat;
		    width: 28px;
		    height: 28px;
		    vertical-align: middle;
			background-position: -84px -28px;
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
			
			/*$("#login").click(function(){
				layer.msg('站长在找工作ing，后期功能会全部更新维护~',{icon:2,time:3000});
				 $.ajax({
					url:"${base}/login",
					data:{},
					success:function(result){
					
					}
				});
			});*/
			
		});
		function getIdentifyCode(){
			var email = $("#email").val();
			alert(email)
			$.ajax({
				url:"${base}/getIdentifyCode",
				data:{"email":email},
				success:function(result){
					console.warn(result);
				}
			});
		}
		
	</script>
</head>
<body>
		<nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <a class="navbar-brand brand" href="javascript:;">老哥666 </a>
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
	                <li><a href="javascript:;">登出</a></li>
				   </c:when>  
				   <c:otherwise>  
	                <li><a style="width:50px;height:50px;" title="QQ登录" href="${base }/beforeQQLogin"><img class="img-responsive" alt="" src="${imgPath }/qqlogin.png" /></a></li>
	                <li><a id="login" data-toggle="modal" data-target="#myModal">登录/注册</a></li>
				   </c:otherwise>  
				</c:choose>
              </ul>
          </div>
        </nav>
	<div class="container">
		<img class="img-responsive" alt="" src="${imgPath }/003.jpg" />
	</div>
	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="myModal">  
		<div class="modal-dialog modal-lg">    
		<div class="modal-content">      
		<div class="modal-header">        
			<button type="button" class="close" data-dismiss="modal">
			<span aria-hidden="true">×</span><span class="sr-only">Close</span></button>        
			<h4 class="modal-title">登录</h4>      
		</div>
		<div class="modal-body">        
		<div>
	    <div class="row">
	        <div class="col-md-4 col-sm-12 col-md-push-7">
	            <h1 class="h4 text-muted">用户登录</h1>
	            <form action="#" method="POST" role="form">
	                <div class="form-group">
	                    <label for="username" class="control-label">Email</label>
	                    <input type="text" class="form-control" name="username" required="" placeholder="Email地址" autocomplete="off">
	                </div>
	                <div class="form-group">
	                    <label class="control-label">密码</label><span class="pull-right"><a href="#">忘记密码</a></span>
	                    <input type="password" class="form-control" name="password" required="" placeholder="密码">
	                </div>
	                <div class="form-group clearfix">
	                    <div class="checkbox pull-left">
	                        <label><input name="remember" type="checkbox" value="1" checked=""> 记住登录状态</label>
	                    </div>
	                    <button type="submit" class="btn btn-primary pull-right pl20 pr20">登录
	                    </button>
	                </div>
	            </form>
	            <p class="h4 text-muted visible-xs-block h4">快速登录</p>
	            <div class="widget-login">
	                <p class="text-muted pull-left hidden-xs" style="margin-top: 5px;">快速登录</p>
	                <a href="${base }/beforeQQLogin" class="" title="QQ登录"><span class="icon-sn-qq"></span> <strong class="visible-xs-inline">QQ 账号</strong></a>
	            </div>
	        </div>
	        <div class="login-vline hidden-xs hidden-sm"></div>
	        <div class="col-md-4 col-md-pull-3 col-sm-12">
	            <h1 class="h4 text-muted login-title">注册新账号</h1>
	            <form action="#" method="POST" role="form" class="mt30">
	                <div class="form-group">
	                    <label for="name" class="control-label">昵称</label>
	                    <input type="text" class="form-control" name="name" required="" placeholder="常用昵称">
	                </div>
	                <div class="form-group">
	                    <div class="">
	                        <label class="radio-inline">
	                            <input type="radio" name="register_type" value="mail" checked=""> 用 Email 注册
	                        </label>
	                    </div>
	                    <div class="js-register-switch-content">
	                        <input type="phone" class="form-control" name="email" id="email" required="" placeholder="email地址" autocomplete="off">
	                        <div class="input-group">
	                        	<input name="code" type="text" class="form-control" placeholder="验证码">
	                            <span class="input-group-btn">
	                            	<button class="btn btn-default" style="width:96px;" type="button" onclick="getIdentifyCode()">获取验证码</button>
	                            </span>
	                        </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="password" class="control-label">密码</label>
	                    <input type="password" class="form-control" name="password" required="" placeholder="不少于 6 位">
	                </div>
	                <div class="form-group clearfix">
	                    <button type="submit" class="btn btn-primary pl20 pr20 pull-right" >注册</button>
	                </div>
	            </form>
	        </div>
	    </div>

		<div class="text-center text-muted">
		</div>
		</div>
		</div>          
		<div class="modal-footer hidden"></div>        
		</div>      
		</div>    
	</div>
</body>
</html>
