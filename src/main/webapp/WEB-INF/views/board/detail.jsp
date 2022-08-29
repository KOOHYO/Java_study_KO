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
  </head>
<body>
<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7">
		<h1>${board} Dtail Page</h1>
		<div class="row">
				<table class="table">
  				<thead class="table-dark">
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>글내용</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
  				</thead>
  				<tbody>
						<tr>
							<td>${boardDTO.num}</td>
							<td>${boardDTO.title}</td>
							<td>${boardDTO.contents}</td>
							<td>${boardDTO.writer}</td>
							<td>${boardDTO.regDate}</td>
							<td>${boardDTO.hit}</td>
						</tr>
  				</tbody>
			</table>
		</div>
	</section>
	<br>
		<a href="./update.ko?num=${boardDTO.num}">글 수정하기</a>
		<a href="./delete.ko?num=${boardDTO.num}">글 삭제하기</a>
		<a href="./reply.ko?writer=${boardDTO.num}">Reply</a>
		<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			<p>
			<a href="../resources/upload/${board}/${fileDTO.fileName}">${fileDTO.oriName}</a>
			</p>
		</c:forEach>
		<%-- <a class="btn btn-secondary disabled" role="button" aria-disabled="true">글상세보기</a> --%>
	<br>
<%-- Bootstrap --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>