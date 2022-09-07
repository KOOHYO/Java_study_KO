<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ko.home.BankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 요청이 발생하면 생성, 응답이 나가면 소멸 : Requst --> 
<%-- BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); --%>
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
	
	<h1>통장 상세정보</h1>
	<section class="container-fluid con-lg-7">
		<div class="row">
			<table border="1">
				<thead>
					<tr>
						<th>BookNum</th>
						<th>BookName</th>
						<th>BookRate</th>
						<th>BookSale</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${requestScope.detail.getBookNum()}</td><!-- 속성명 잘 보기! -->
						<td>${requestScope.detail.bookName}</td>
						<td>${detail.bookRate}</td>
						<td>${detail.bookSale}</td>
					</tr>
				</tbody>
			</table>
			
			<div>
				<c:if test="${empty sessionScope.member}">
				<a href="../member/login.iu">로그인</a>
				<a href="../member/join.iu">회원가입하기</a>
				</c:if>
			</div>
		
			<div>
				<c:if test="${not empty sessionScope.member}">
				<a href="./update.iu?bookNum=${detail.bookNum}">통장수정</a>
				<a href="./delete.iu?bookNum=${detail.bookNum}">통장삭제</a>
				<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">통장가입하기</a>
				</c:if>
			</div>
			
			<div>
				<a href="./list.iu">통장리스트</a>
			</div>

			<!-- Comment -->
			<div class="row">
				<div class="mb-3">
					<label for="writer" class="form-label">USERNAME</label>
					<input type="text" class="form-control" id="writer" placeholder="Enter Your USERNAME">
				</div>
				<div class="mb-3">
					<label for="contents" class="form-label">CONTENTS</label>
					<textarea class="form-control" id="contents" rows="3"></textarea>
				</div>
				<div class="mb-3">
					<button type="button" id="commentAdd" data-book-num="${detail.bookNum}">댓글작성</button>
				</div>
			</div>
			<!-- Comment -->

			<!-- CommentList 출력 -->
			<div>
				<table id="commentList">

				</table>
				<button id="more" class="btn btn-danger">더보기</button>
			</div>
			<!-- CommentList 출력 -->

			<div>
				<button type="button" style="display: none;" class="btn btn-primary" id="up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button>

				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
					<div class="modal-content">
					  <div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">update</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					  </div>
					  <div class="modal-body">
						<form>
						  <div class="mb-3">
							<label for="recipient-name" class="col-form-label">Writer</label>
							<input type="text" class="form-control" id="recipient-name">
						  </div>
						  <div class="mb-3">
							<label for="message-text" class="col-form-label">Contents</label>
							<textarea class="form-control" id="message-text"></textarea>
						  </div>
						</form>
					  </div>
					  <div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Send message</button>
					  </div>
					</div>
				  </div>
				</div>
			</div>

		</div>
	</section>
		
	<c:import url="../template/footer.jsp"></c:import>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/bankbookCommetn.js"></script>
</body>
</html>