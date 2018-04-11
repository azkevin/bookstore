<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
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
</head>
<body>
	<section class="navigation">			
		<div class="logo">
			<a href="${pageContext.request.contextPath}/"> <img width="139.5px" height="48.28px"
				src="${pageContext.request.contextPath}/res/logo/TabsVsSpacesLogoWhiteBookstore.png"></img>
			</a>
		</div>
		<nav>
			<ul class="nav-list">
				<li><a href="${pageContext.request.contextPath}/MainPage.jspx">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/AboutPage.jspx">About</a></li>
				<li><a href="${pageContext.request.contextPath}/LoginPage.jspx">Login</a></li>
				<li><a href="${pageContext.request.contextPath}/CartPage.jspx">Cart</a></li>
			</ul>
		</nav>
	</section>
</body>
</html>
</jsp:root>