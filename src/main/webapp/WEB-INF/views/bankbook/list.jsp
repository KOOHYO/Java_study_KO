<%@page import="java.util.ArrayList"%>
<%@page import="com.ko.home.BankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

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

	<c:import url="../template/header.jsp"></c:import>
	
 	<h1>통장 리스트</h1>
	<section class="container-fluid con-lg-7">
		<div class="row">
			<!-- /book/list -->
			
			<!-- /book/detail   jsp:derail.jsp -->
			<!-- link 주소는 상대경로 작성 -->
			<!-- 이 페이지의 URL주소를 보고 경로를 결정 -->
			<!-- <a href="./detail">Detail</a> 이렇게 써도 됀다 -->
			
			<table class="table table-striped">
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
			<div>
				<c:if test="${not empty sessionScope.member}">
					<a href="./add.iu">통장등록</a>
				</c:if>
			</div>
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>