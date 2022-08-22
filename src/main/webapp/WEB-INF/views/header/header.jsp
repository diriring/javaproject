<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">보드게임</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/view/boardList.php">자유게시판</a>
          </li>
          <li class="nav-item dropdown">

<%--            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--              환영합니다.--%>
<%--            </a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--              <li><a class="dropdown-item" id="logout" href="#">로그아웃</a></li>--%>
<%--              <li><a class="dropdown-item" href="/view/myPage.php">마이페이지</a></li>--%>
<%--            </ul>--%>
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              메뉴
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/view/login.php">로그인</a></li>
              <li><a class="dropdown-item" href="/member/memberJoin">회원가입</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>