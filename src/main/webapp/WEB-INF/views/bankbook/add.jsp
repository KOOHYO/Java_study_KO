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
<body>

	<section class="container-fluid con-lg-7">
		<div class="row">
			
		</div>
	</section>
	<h1>BankBook Add</h1>
	<br>
	<form action="./add.iu" method="post">
		현재 날짜를 입력하세요
		<br>
		<input type="text" name="bookNum">
		<br>
		통장 이름을 입력하세요
		<br>
		<input type="text" name="bookName">
		<br>
		이자율을 입력하세요
		<br>
		<input type="text" name="bookRate">
		<br>
		판매여부 
		<input type="button" name="bookSale" value="가능">
		<br>
		<br>
		<input type="submit" value="통장개설 완료"><input type="reset" value="초기화">
		<!-- 위에 말고 밑에는 가능 <butoon type="submit">Add</button> -->
		
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>