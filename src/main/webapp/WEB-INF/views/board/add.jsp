<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%-- JQuery --%>
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  	
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  	
  	<%-- SummerNote --%>
  	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  </head>
<body>
<c:import url="../template/header.jsp"></c:import>
<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7">
		<h1 class="align-center">${board} Add Page</h1>
		<div class="row">
		
			<form action="./add.ko" method="post" enctype="multipart/form-data">
			
				<div class="mb-3">
				  <label for="title" class="form-label">Title</label>
				  <input type="text" name="title" class="form-control" id="title" placeholder="제목 입력">
				</div>
				<div class="mb-3">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" name="writer" class="form-control" id="writer" placeholder="작성자 입력">
				</div>
				<div class="mb-3">
				  <label for="contents" class="form-label">Contents</label>
				  <textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
				</div>
				
				<div id="addFiles">
					<button type="button" class="btn btn-success" id="fileAdd">파일 추가</button>
				</div>
				
				<div class="mb-3">
					<button class="btn btn-success">글 추가</button>
				</div>
				
			</form>
			
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<%-- Bootstrap --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
	$("#contents").summernote();
</script>

<script src="/resources/js/board_file.js"></script>
</body>
</html>