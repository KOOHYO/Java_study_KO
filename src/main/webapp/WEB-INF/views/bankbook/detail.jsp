<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ko.home.BankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 요청이 발생하면 생성, 응답이 나가면 소멸 : Requst --> 
<%-- BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); --%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
<body>
	
	<c:import url="./template/header.jsp"></c:import>
	
	<section class="container-fluid con-lg-7">
		<div class="row">
			<h1>통장 상세정보</h1>
		
			<table class="table table-striped">
				<thead>
					<tr>
						<th>BookNum</th>
						<th>BookName</th>
						<th>BookRate</th>
						<th>BookSale</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.detail.getBookNum()}</td><!-- 속성명 잘 보기! -->
						<td>${requestScope.detail.bookName}</td>
						<td>${detail.bookRate}</td>
						<td>${detail.bookSale}</td>
					</tr>
				</tbody>
			</table>
			
			<div>
				<c:if test="${empty sessionScope.member}">
				<a href="../member/login.iu">로그인</a>
				<a href="../member/join.iu">회원가입하기</a>
				</c:if>
			</div>
			
			<div>
				<c:if test="${not empty sessionScope.member}">
				<a href="./update.iu?bookNum=${detail.bookNum}">통장수정</a>
				<a href="./delete.iu?bookNum=${detail.bookNum}">통장삭제</a>
				<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">통장가입하기</a>
				</c:if>
			</div>
			
			<div>
				<a href="./list.iu">통장리스트</a>
			</div>
		</div>
	</section>
	
	<c:import url="./template/footer.jsp"></c:import>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>