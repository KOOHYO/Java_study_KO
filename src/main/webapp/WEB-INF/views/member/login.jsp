<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-5">
		<div class="row">
			
			<h1>로그인</h1>
		    
		    <form action="./login.iu" method="post" id="login"><!-- /member/login -->
				  <div class="mb-3">
				  	<label for="userName" class="form-label">아이디 입력하세요</label>
				  	<input type="text" name="userName" class="form-control" id="userName" aria-describedby="emailHelp">
				  	<%-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> --%>
				  </div>
				  <div class="mb-3">
				    <label for="password" class="form-label">비밀번호를 입력하세요</label>
				    <input type="text" name="passWord" class="form-control" id="password">
				  </div>
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Check me out</label>
				  </div>
				  <div id="alert"></div>
				  <button type="button" class="btn btn-primary" id="btn">로그인</button>
		    </form>
		</div>
	</section>
    
	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/member.js"></script>
	<script>
		loginCheck();
	</script>
</body>
</html>