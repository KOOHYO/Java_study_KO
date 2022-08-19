<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거지우기!!!!!!!! --%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
	<link rel="stylesheet" href="./resources/css/test.css">
	<style>
		li{
			color: blue;
		}
	</style>
</head>
<body>

	<!--nav-->
	<!--Group-->
	<div>
		<ul>
			<li><a href="/bankbook/list.iu">상품리스트</a></li>
			<li><a href="/board/list.iu">게시판</a></li>
			<li><a href="/member/login.ko">로그인</a></li>
			<li><a href="/member/join.ko">회원가입</a></li>
		</ul>
	</div>

	<img src="./resources/images/cat.jpg" alt="고양이사진">

	<iframe width="560" height="315" src="https://www.youtube.com/embed/HtwHfeJqlL4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

	<h1>Index Page</h1>

	<!-- 순서가 있는 List -->
	<ol>
		<li style="color: red;">1</li>
		<li>2</li>
		<li>3</li>
	</ol>
	<!-- 순서가 없는 List -->
	<ul>
		<li>SKT</li>
		<li>LG</li>
		<li>KT</li>
	</ul>

</body>
</html>
