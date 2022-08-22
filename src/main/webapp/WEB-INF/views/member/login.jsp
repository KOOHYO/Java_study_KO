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
		    
		    <form action="./login.iu" method="post"><!-- /member/login -->
				  <div class="mb-3">
				  	<label for="exampleInputEmail1" class="form-label">아이디 입력하세요</label>
				  	<input type="text" name="userName" value="Koo" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				  	<%-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> --%>
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">비밀번호를 입력하세요</label>
				    <input type="text" name="passWord" value="123" class="form-control" id="exampleInputPassword1">
				  </div>
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Check me out</label>
				  </div>
				  <button type="submit" class="btn btn-primary">로그인</button>
		    </form>
		</div>
	</section>
    
	<c:import url="../template/footer.jsp"></c:import>
	
</body>
</html>