<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  </head>
<body>
	
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid con-lg-7">
		<div class="row">

			<h1>Update Page</h1>
			<form action="./update.iu" method="post">
				<input type="hidden" name="bookNum" readonly="readonly" value="${detail.bookNum}">
				<div>
					Name : <input type="text" name="bookName" value="${detail.bookName}">
				</div>
				<div>
					Rate : <input type="text" name="bookRate" value="${detail.bookRate}">
				</div>
				<br>
				<br>
				<input type="submit" value="수정" >
				<!-- 이걸 많이 씀!! <button type="submit">수정</button> -->
			</form>
			
		</div>
	</section>
		
	<c:import url="../template/footer.jsp"></c:import>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>