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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>我的666</title>
	
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
		.active{
			color: #fff;
   			background-color: #080808 !important;
		}
		.main{
		    /* width: 1500px; */
   			margin: 0 auto;
		}
		.main .persional_property{
			clear: both;
	    	margin: 10px 0;
		}
		.main .persional_property  .person_info_con{
			background: #fff;
		    border: 1px solid #dcdcdc;
		    margin: 10px auto 0;
		    overflow: hidden;
		    position: relative;
		}
		.main .persional_property  .person-photo {
		    width: 150px;
		    height: 200px;
		    float: left;
		    margin: 15px 30px 15px 20px;
		}
		.main .persional_property .person-info {
		    float: left;
		    width: 750px;
		    margin-top: 30px;
		}
		.main .persional_property .person-photo img {
		    width: 150px;
		    height: 150px;
		    border: none;
		}
	</style>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
	        <div class="container">
	          <div class="navbar-header">
	            <a class="navbar-brand brand" href="#">老哥666</a>
	          </div>
	          <div id="navbar" class="navbar-collapse collapse">
	            <ul class="nav navbar-nav">
	              <li><a href="${base }/index.do">首页</a></li>
	              <li><a href="#about">聊天室</a></li>
	              <li><a id="promiseMe" href="#">点赞</a></li>
	              <li><a id="buildpage" href="#">FreeMaker</a></li>
	              <li><a class="active" href="#contact">个人中心</a></li>
	              <li><a class="gap">|</a></li>
	              <c:choose>  
			   <c:when test="${user.openID != '' && user.openID != null && user.openID != undefind}">
	               <li><a href="#">${user.nickName }</a></li>
	               <li><a href="${base }/logout">登出</a></li>
			   </c:when>  
			   <c:otherwise>  
	               <li><a style="width:50px;height:50px;" title="QQ登录" href="${base }/beforeQQLogin.do"><img class="img-responsive" alt="" src="${imgPath }/qqlogin.png" /></a></li>
	               <li><a href="#">登录</a></li>
	               <li><a href="#">注册</a></li>
			   </c:otherwise>  
			</c:choose>
	            </ul> 
	        </div>
	      </nav>
	      
	<div class="container main">
		<div class="persional_property">
        <div class="person_info_con"><i class="icon-edit icon-large person-info-edit"></i><a name="M_base"></a>
          <dl class="person-photo">
              <dt><a href="javascript:;"><img src="${user.headImg }" class="header"><span class="edit_person_pic"></span></a></dt>
          </dl>
          <dl class="person-info">
            <dt class="person-nick-name">
        		<span>${user.nickName }</span>
            </dt>
            <dd class="person-detail"> 
            	<span class="info_null">未填写行业</span><span>|</span><span>|</span>${user.nickName }<span>|</span>中国<span>|</span>${user.gender }<span>|</span><span class="info_null">未填写生日</span> </dd>
            <dd class="person-sign">个人简介</dd>
            <dd style="margin: 10px 0px"> 
	            <div class="person-status clearfix">
	            </div>
          </dd>
          </dl>
        
        </div>
      </div>
	</div>
</body>
</html>
