<%@page import="java.util.ArrayList"%>
<%@page import="com.ko.home.BankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장 리스트</h1>
	<!-- /book/list -->
	
	<!-- /book/detail   jsp:derail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<!-- 이 페이지의 URL주소를 보고 경로를 결정 -->
	<!-- <a href="./detail">Detail</a> 이렇게 써도 됀다 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>통장번호</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${requestScope.list}" var="dto">
					<tr>
					<!-- 파라미터 보낼때 띄어쓰기 하지말기 예를들어 detail?bookNum=... -->
						<td><a href="detail.iu?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${not empty sessionScope.member}">
		<a href="./add.iu">통장등록</a>
	</c:if>
	
</body>
</html>