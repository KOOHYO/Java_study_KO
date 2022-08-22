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
	<h1>MyPage</h1>
	
	<p>ID : ${dto.userName}</p>
	<p>Name : ${dto.name}</p>
	<p>Email : ${dto.email}</p>
	<p>Phone : ${dto.phone}</p>
	
	
	<c:forEach items="${dto.bankAccountDTOs}" var="dto">
		<p>${pageScope.dto.accountNum}</p>
		<p>${dto.bankBookDTO.bookName}</p>
		<p>${dto.accountDate}</p>	
	</c:forEach>
	
</body>
</html>