<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	<%-- js 파일을 따로 안만드는 이유는 js에서 El을 쓸 수 없기 때문 --%>
	//let result = ${result};
	let message = "${message}";
	//alert(result);
	alert(message);
	location.href="${url}";
</script>

</body>
</html>