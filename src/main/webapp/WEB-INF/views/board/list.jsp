<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7">
		<div class="row">
			<h1>${board} List Page</h1>
			<table class="table">
  				<thead class="table-dark">
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
  				</thead>
  				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.num}</td>
							<td><a href="detail.ko?num=${dto.num}">${dto.title}</a></td>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
  				</tbody>
			</table>
		</div>
	</section>
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	  
	  <c:if test="${pager.pre}">
	    <li class="page-item"><a class="page-link" href="./list.ko?page=${pager.startNum-1}">Previous</a></li>
	  </c:if>
	  
	  <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<li class="page-item"><a class="page-link" href="./list.ko?page=${i}">${i}</a></li>
	  </c:forEach>
	    
<%-- 	    <c:choose>
	    	<c:when test="${pager.next}">
	    		<li class="page-item">
	    	</c:when>
	    	<c:otherwise>
	    		여기는 부트스트랩 class 속성 disabled를 이용해서 누르지못하게 막아줌
	    		<li class="page-item disabled">
	    	</c:otherwise>
	    </c:choose> --%>
	    
	    <%-- 삼항연산자를 사용해서 하는 표현식 --%>
	    <li class="page-item ${pager.next?'':'disabled'}">
	    <a class="page-link" href="./list.ko?page=${pager.lastNum+1}">Next</a></li>
	  </ul>
	</nav>
	
	<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>