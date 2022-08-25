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
		<h1 class="align-center">${board} List Page</h1>
		<div class="row mb-3">
		<div>
			<form action="./list.ko" class="row row-cols-lg-auto g-3 align-items-center">
			
			  <div class="col-12">
			    <label class="visually-hidden" for="kind">kind</label>
			    <select name="kind" class="form-select" id="kind">
			      <option value="Contents">Contents</option>
			      <option value="Title">Title</option>
			      <option value="Writer">Writer</option>
			    </select>
			  </div>
			
			  <div class="col-12">
			    <label class="visually-hidden" for="search">검색어</label>
			    <div class="input-group">
			      <input type="text" name="search" value="" class="form-control" id="search">
			    </div>
			  </div>
			
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">검색</button>
			  </div>
			</form>
		</div>

			<table class="table align-center">
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
	    <li class="page-item">
	    <a class="page-link" href="./list.ko?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
	  </c:if>
	  
	  <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<li class="page-item"><a class="page-link" href="./list.ko?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
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
	    <a class="page-link" href="./list.ko?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
	  </ul>
	</nav>
	
	<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>