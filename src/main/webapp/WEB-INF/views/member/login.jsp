<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	
    
    <form action="./login.iu" method="post"><!-- /member/login -->
	    <div>
	        아이디를 입력하세요<br>
	        <input type="text" value="GD" name="userName"><input type="hidden">
	        <br>
	        <br>
	        비밀번호를 입력 하세요<br>
	        <input type="password" value="123" name="passWord">
	        <br>
	        <input type="submit" value="로그인">
	    <button type="button" onclick="location.href='/home'">Home</button>
	    </div>
    </form>
	
</body>
</html>