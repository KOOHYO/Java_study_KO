<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4">
		<div class="row">
			<form action="./search.iu" method="post">
			
				<h1>회원정보 검색</h1>
			
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">아이디 입력하세요</label>
					<input type="text" name="userName" class="form-control" aria-describedby="emailHelp">
					<%-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> --%>
				</div>
				<button type="submit" class="btn btn-primary">회원정보검색</button>
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
</body>
</html>