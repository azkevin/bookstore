<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="StyleSheet" href="res/mc.css" type="text/css"
	media="screen, print" />
<script type="text/javascript" src="res/mc.js">;</script>
</head>
<body>
	<section class="navigation">			
		<div class="logo">
			<a href="${pageContext.request.contextPath}/?category=All"> <img width="139.5px" height="48.28px"
				src="${pageContext.request.contextPath}/res/logo/TabsVsSpacesLogoWhiteBookstore.png"></img>
			</a>	
		</div>
		
		<nav>
			<ul class="nav-list">
				<li id="user_details">
					<c:if test="${not empty username}">
						Hello, ${username.getFirstName()}
					</c:if>
					<c:if test="${empty username}">
						Welcome!
					</c:if>
				</li>
			
				<li><a href="${pageContext.request.contextPath}/?category=All">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/AboutPage.jspx">About</a></li>
				
				<c:if test="${not empty username}">
					<li><a href="${pageContext.request.contextPath}/LogoutPage.jspx">Logout</a></li>
				</c:if>
				<c:if test="${empty username}">
					<li><a href="${pageContext.request.contextPath}/LoginPage.jspx">Login</a></li>
				</c:if>
				<c:choose>
					<c:when test="${empty username}">
						<li><a href="${pageContext.request.contextPath}/LoginPage.jspx" onclick="return pleaseSignIn()">Cart</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/?cartPage=cartPage">Cart</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</section>
</body>
</html>
</jsp:root>