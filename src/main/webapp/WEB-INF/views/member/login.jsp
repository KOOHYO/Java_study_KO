<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<li><a href="/bankbook/list.iu">상품리스트</a></li>
			<li><a href="/board/list.iu">게시판</a></li>
			<li><a href="/member/login.ko">로그인</a></li>
			<li><a href="/member/join.ko">회원가입</a></li>
		</ul>
	</div>
	<h1>Login Page</h1>
	
    
    <form action="./login.ko" method="post"><!-- /member/login -->
	    <div>
	        아이디를 입력하세요<br>
	        <!-- 계속 로그인 치기 귀찮으니 DB에있는 데이터 userName를 -->
	        <!-- value속성에 넣음 -->
	        <input type="text" value="GD" name="userName"><input type="hidden">
	        <br>
	        <br>
	        <!-- 계속 로그인 치기 귀찮으니 DB에있는 데이터 password를 -->
	        <!-- value속성에 넣음 -->
	        비밀번호를 입력 하세요<br>
	        <input type="password" value="123" name="passWord">
	        <br>
	        <input type="submit" value="로그인">
	    </div>
	    <button type="button" onclick="location.href='/'">Home</button>
    </form>
	
</body>
</html>