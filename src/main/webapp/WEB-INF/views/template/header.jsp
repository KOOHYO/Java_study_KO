<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%-- Required meta tags --%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- Bootstrap CSS --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
            <a class="navbar-brand" href="#">Bank</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">홈</a>
                </li>
               <%-- if else 처럼쓰임 --%>
                <c:choose>
                	<%-- if --%>
                	<c:when test="${empty sessionScope.member}">
		                <li class="nav-item">
		                    <a class="nav-link active" href="/member/login.iu">로그인</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link" href="/member/join.iu">회원가입</a>
		                </li>
                	</c:when>
	                <%-- else --%>
	                <c:otherwise>
		                <li class="nav-item">
		                    <a class="nav-link" href="/member/logout.iu">로그아웃</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link active" href="/member/myPage.iu">마이페이지</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link active" href="/notice/list.ko">게시판</a>
		                </li>
	                </c:otherwise>
                </c:choose>
                
                <li class="nav-item">
                    <a class="nav-link" href="/member/search.iu">회원정보검색</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bankbook/list.iu">상품리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/qna/list.ko">QNA</a>
                </li>

                </ul>
            </div>
            </div>
        </nav>
    </header>