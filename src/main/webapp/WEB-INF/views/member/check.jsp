<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Check Page</h1>

	<div>
		전체동의 <input type="checkbox" name="box" id="all">
		동의1(필수) <input type="checkbox" name="box" class="ch req">
		동의2(필수) <input type="checkbox" name="box" class="ch req">
		동의3(필수) <input type="checkbox" name="box" class="ch req">
		동의4(선택) <input type="checkbox" name="box" class="ch">
	</div>

	<form action="./join.iu" method="get" id="frm">
		<button id="join">동의</button>
	</form>

<script src="/resources/js/member.js"></script>
<script>
	check();
</script>
</body>
</html>