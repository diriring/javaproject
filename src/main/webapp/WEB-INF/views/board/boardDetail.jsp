<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-24
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:import url="../header/header_script.jsp"></c:import>
    <title>Title</title>
</head>
<body>

<c:import url="../header/header.jsp"></c:import>

<div class="container">

  <div class="container mt-5">
    <table class="table" id="detailResult">
      <colgroup>
        <col width="15%"/>
        <col width="55%"/>
        <col width="10%"/>
        <col width="10%"/>
        <col width="10%"/>
      </colgroup>
      <thead>
        <tr>
          <td>말머리</td>
          <td>제목</td>
          <td>작성자</td>
          <td>작성날짜</td>
          <td>조회수</td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${vo.categoryVO.categoryName}</td>
          <td>${vo.title}</td>
          <td>${vo.id}</td>
          <td><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd"/></td>
          <td>${vo.hit}</td>
        </tr>
        <tr>
          <td colspan="5">${vo.content}</td>
        </tr>
      </tbody>
    </table>
    <div>
      <c:if test="${vo.id eq member.id}">
        <a class="btn btn-outline-secondary" href="./boardUpdate?boardNum=${vo.boardNum}">글 수정</a>
        <button class="btn btn-outline-secondary" id="deleteBtn">글 삭제</button>
        <input type="hidden" id="boardNum" value="${vo.boardNum}">
      </c:if>
    </div>
  </div>
</div>

<script>
  $("#deleteBtn").on("click", function() {
    $.ajax({
      type: "POST",
      url: "/board/boardDelete",
      data: {
        boardNum: $("#boardNum").val()
      },
      success: function(result) {

        console.log(result);

        if (result.data == 1) {
          alert("삭제 성공");
          location.href="/board/boardList";

        } else {
          alert("삭제 실패");
          location.href="/board/boardList";
        }
      },
      error: function() {
        alert("에러");
      }
    });
  });
</script>
</body>
</html>
