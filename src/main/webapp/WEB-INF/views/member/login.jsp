<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>bank!</title>
    <nav class="navbar navbar-dark bg-dark">
        <!-- Navbar content -->
    </nav>
  </head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<!-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 -->
	<section class="container-fluid">
		<div class="row">
			
			<h1>로그인</h1>
		    
		    <form action="./login.ko" method="post"><!-- /member/login -->
				  <div class="mb-3">
				  	<label for="exampleInputEmail1" class="form-label">아이디 입력하세요</label>
				  	<input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				  	<!-- <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div> -->
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">비밀번호를 입력하세요</label>
				    <input type="text" name="passWord" class="form-control" id="exampleInputPassword1">
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
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>