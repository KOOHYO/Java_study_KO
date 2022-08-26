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
			
			<form action="./join.iu" method="POST" enctype="multipart/form-data">
				<h1>Join Page</h1>
				<h2>회원가입</h2>
		   		<div>
		        	아이디를 입력하세요<br>
		        	<input type="text" name="userName"><input type="button" value="중복확인"><br>
		       		비밀번호를 입력 하세요<br>
		        	<input type="password"><br> 
		        	비밀번호를 다시 입력하세요<br>
		        	<input type="password" name="passWord"><input type="button" value="비밀번호 확인"><br>
		    	</div>
		    	<br>
		    	<div>
			       이름을 입력하세요<br>
			       <input type="text" name="name"><br>
			       이메일을 입력하세요<br>
			       <input type="email" name="email"><br>
			       전화번호를 입력하세요<br>
			       <input type="text" name="phone"><br>
			       <br>
			       <hr>
			       <br>
			       <input type="submit" value="회원가입완료"><input type="button" value="회원가입취소">
			   </div>
			   <div>
			   		Photo<br>
		        	<input type="file" name="photo" id="files">
			   </div>
			   
			</form>
			
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>

</body>
</html>