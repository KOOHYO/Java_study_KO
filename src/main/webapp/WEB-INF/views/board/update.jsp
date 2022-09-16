<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  
	<%-- SummerNote JQuery --%>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>

	<%-- SummerNote --%>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  	s<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  </head>
<body>
<c:import url="../template/header.jsp"></c:import>
<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7">
		<div class="row">
			<h1 class="align-center">${board} Update Page</h1>
			<form action="./detail.ko" method="post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${boardDTO.num}" >
				<div class="mb-3">
				  <label for="title" class="form-label">Title</label>
				  <input type="text" name="title" value="${boardDTO.title}" class="form-control" id="title" placeholder="제목 입력">
				</div>
				<div class="mb-3">
				  <label for="writer" class="form-label">Writer</label>
				  <input type="text" name="writer" value="${boardDTO.writer}" disabled="disabled" class="form-control" id="Writer" placeholder="작성자 입력">
				</div>
				<div class="mb-3">
				  <label for="contents" class="form-label">Contents</label>
				  <textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
				</div>
				
				<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
					<div class="mb-3">
						<span class="form-control">${fileDTO.oriName}</span>
						<button type="button" class="btn btn-success fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
					</div>
				</c:forEach>

				<div id="addFiles">
					<button type="button" class="btn btn-danger" id="fileAdd">파일 추가</button>
				</div>
				
				<div class="mb-3">
					<button class="btn btn-success">업데이트</button>
				</div>
			</form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board_file.js"></script>
<script>
	setCount(${update.boardFileDTOs.size()});
	$("#contents").summernote();
</script>
</body>
</html>