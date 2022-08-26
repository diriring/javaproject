<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a class="nav-link active" aria-current="page" href="/board/boardList">자유게시판</a>
          </li>
          <li class="nav-item dropdown">

            <c:choose>
                <c:when test="${not empty member}">
                    <p class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            ${member.id}님
                    </p>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" id="logout" href="#">로그아웃</a></li>
                        <li><a class="dropdown-item" href="/member/myPage">마이페이지</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <p class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        메뉴
                    </p>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/member/login">로그인</a></li>
                        <li><a class="dropdown-item" href="/member/memberJoin">회원가입</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>

<script>
    $("#logout").on("click", function () {
        console.log("로그아웃 클릭");
        $.ajax({
            type: "GET",
            url: "/member/logout",
            success: function() {
                localStorage.clear();
                location.href = "/";
            },
            error: function() {
                alert("에러");
            }
        });
    });
</script>