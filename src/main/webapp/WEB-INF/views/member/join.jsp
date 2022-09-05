<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  </head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid con-lg-7">
		<div class="row">
			
			<form action="./join.iu" method="POST" enctype="multipart/form-data" id="joinform">
				<h1>Join Page</h1>
				<h2>회원가입</h2>
		   		<div>
		        	아이디를 입력하세요<br>
		        	<input type="text" name="userName" id="id"><button type="button" id="idbtn">비밀번호 확인</button><br>
					<div id="d1"></div>
		       		비밀번호를 입력 하세요<br>
		        	<input type="password" id="pw"><br>
					<div id="d2"></div>
		        	비밀번호를 다시 입력하세요<br>
		        	<input type="password" name="passWord" id="pw2"><button type="button" id="pwbtn">비밀번호 확인</button><br>
					<div id="d3"></div>
		    	</div>
		    	<br>
		    	<div>
			       이름을 입력하세요<br>
			       <input type="text" name="name" id="name"><br>
				   <div id="d4"></div>
			       이메일을 입력하세요<br>
			       <input type="email" name="email" id="email"><br>
				   <div id="d5"></div>
			       전화번호를 입력하세요<br>
			       <input type="text" name="phone" id="phone"><br>
				   <div id="d6"></div>
			       <br>
			       <hr>
			       <br>
				   <button type="button" id="joinbtn">회원가입 완료</button><button type="button">회원가입 취소</button>
			   </div>
			   <div>
			   		Photo<br>
		        	<input type="file" name="photo" id="files">
			   </div>
			   
			</form>
			
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/member.js"></script>
	<script>
		joinCheck();
	</script>
</body>
</html>