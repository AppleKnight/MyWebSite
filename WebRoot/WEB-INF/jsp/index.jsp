<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("base", request.getContextPath());
	request.setAttribute("jsPath", request.getContextPath()+"/resources/js");
	request.setAttribute("cssPath", request.getContextPath()+"/resources/css");
	request.setAttribute("imgPath", request.getContextPath()+"/resources/img");
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0">
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
		.required{
		    font-size: 12px;
		    color: #A03717;
		    position: relative;
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
						console.warn(result);	
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
			//登录
			$("#doLogin").click(function(){
				var email = $("input[name='username']").val();
				var password = $("input[name='password']").val();
				if(!email){
					layer.msg('请填写注册时邮箱！谢谢~',{icon:2,time:2000});
					return false;					
				}
				if(!password){
					layer.msg('请填写登录密码！谢谢~',{icon:2,time:2000});
					return false;					
				}
				$.ajax({
					url:"${base}/normalLogin",
					data:{"email":email,"password":password},
					success:function(data){
						switch(data)
						{
							case "0":
								layer.msg('登录信息不合法，请核实！谢谢~',{icon:2,time:2000});
								break;
							case "1": 
								layer.msg('登录成功，即将跳转到个人中心~',{icon:1,time:2000});
								setTimeout(function(){
									window.location.href="${base}/personal";
								},2000);
								break;
							case "2": 
								layer.msg('登录信息有误！请重试~',{icon:2,time:2000});
								break;
							default:;						
						};
					}
				});
			});
			//注册
			$("#doRegister").click(function(){
				var nickname = $("input[name='nickname']").val();
				var email = $("input[name='email']").val();
				var password = $("input[name='reqPassword']").val();
				var confirmpassword = $("input[name='confirmpassword']").val();
				if(!nickname){
					layer.msg('请填写带*标记的信息！谢谢~',{icon:2,time:2000});
					return false;
				}
				if(!email){
					layer.msg('请填写带*标记的信息！谢谢~',{icon:2,time:2000});
					return false;
				}
				if(password == null || password == undefined || password.length <= 6){
					layer.msg('密码不合法，请重新填写！谢谢~',{icon:2,time:2000});
					return false;
				} 
				if(confirmpassword == null || confirmpassword == undefined || confirmpassword.length <= 6){
					layer.msg('确认密码信息不合法，请重新填写！谢谢~',{icon:2,time:2000});
					return false;
				}
				if(confirmpassword != password ){
					alert(confirmpassword+"--"+password)
					layer.msg('两次输入的密码不一致，请重新填写！谢谢~',{icon:2,time:2000});
					return false;
				}
				$.ajax({
					url:"${base}/normalRegister",
					type:"post",
					data:{"nickname":nickname,"email":email,"password":password},
					success:function(data){
						switch(data)
						{
							case "0":
								layer.msg('注册信息不合法，请核实！谢谢~',{icon:2,time:2000});
								break;
							case "1": 
								layer.msg('注册成功，2s后跳转到个人中心~',{icon:1,time:2000});
								window.location.href="${base}/personal";
								break;
							case "2": 
								layer.msg('该邮箱已被使用！请更换后重试~',{icon:2,time:2000});
								break;
							default:;						
						};
					}
				});
			});
		});
		function getIdentifyCode(){
			var email = $("#email").val();
			alert(email)
			$.post("getIdentifyCode",{"email":email},function(result){
					console.warn(result);
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
				   <c:when test="${user.nickName != '' && user.nickName != null && user.nickName != undefind}">
	                <li><img style="border-radius: 50px;width: 50px;" class="img-responsive" alt="" src="${user.headImg }" /></li>
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
	            <form action="personal" method="POST" role="form">
	                <div class="form-group">
	                    <label for="username" class="control-label">Email</label>
	                    <input type="text" class="form-control" name="username" required placeholder="Email地址" autocomplete="off">
	                </div>
	                <div class="form-group">
	                    <label class="control-label">密码</label><span class="pull-right"><a href="#">忘记密码</a></span>
	                    <input type="password" class="form-control" name="password" required placeholder="密码">
	                </div>
	                <div class="form-group clearfix">
	                    <div class="checkbox pull-left">
	                        <label><input name="remember" type="checkbox" checked=""> 记住登录状态</label>
	                    </div>
	                    <button type="button" id="doLogin" class="btn btn-primary pull-right pl20 pr20">登录
	                    </button>
	                </div>
	            </form>
	            <p class="visible-xs-block h4">快速登录</p>
	            <div>
	                <p class="pull-left hidden-xs" style="margin-top: 5px;">快速登录</p>
	                <a href="${base }/beforeQQLogin" class="" title="QQ登录"><span class="icon-sn-qq"></span> <strong class="visible-xs-inline">QQ 账号</strong></a>
	            </div>
	        </div>
	        <div class="login-vline hidden-xs hidden-sm"></div>
	        <div class="col-md-4 col-md-pull-3 col-sm-12">
	            <h1 class="h4 text-muted login-title">注册新账号</h1>
	            <form role="form">
	                <div class="form-group">
	                    <label for="name" class="control-label">昵称</label>
	                     <span class="required">*</span>
	                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="常用昵称">
	                </div>
	                <div class="form-group">
                        <label for="email" class="control-label">邮箱</label>
                         <span class="required">*</span>
                        <input type="email" class="form-control" name="email" id="email"  placeholder="email地址" autocomplete="off">
	                    <!-- <div>
	                        <input type="email" class="form-control" name="email" id="email" required placeholder="email地址" autocomplete="off">
	                        <div class="input-group">
	                        	<input name="identifyCode" type="text" class="form-control" placeholder="验证码" required>
	                            <span class="input-group-btn">
	                            	<button class="btn btn-default" style="width:96px;" type="button" onclick="getIdentifyCode()">获取验证码</button>
	                            </span>
	                        </div>
	                    </div> -->
	                </div>
	                <div class="form-group">
	                    <label for="password" class="control-label">密码</label>
	                     <span class="required">*</span>
	                    <input type="password" class="form-control" name="reqPassword" placeholder="不少于 6 位">
	                </div>
	                <div class="form-group">
	                    <label for="password" class="control-label">确认密码</label>
	                    <span class="required">*</span>
	                    <input type="password" class="form-control" name="confirmpassword" placeholder="不少于 6 位">
	                </div>
	                <div class="form-group clearfix">
	                    <button type="button" id="doRegister" class="btn btn-primary pl20 pr20 pull-right" >注册</button>
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
