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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        <td>${boardVO.categoryVO.categoryName}</td>
        <td>${boardVO.title}</td>
        <td>${boardVO.id}</td>
        <td><fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd"/></td>
        <td>${boardVO.hit}</td>
      </tr>
      <tr>
        <td id="content" colspan="5">${boardVO.content}</td>
      </tr>
      </tbody>
    </table>
    <input type="hidden" id="boardNum" value="${boardVO.boardNum}">
    <div>
      <c:if test="${boardVO.id eq member.id}">
        <a class="btn btn-outline-secondary" href="./boardUpdate?boardNum=${boardVO.boardNum}">글 수정</a>
        <button class="btn btn-outline-secondary" id="deleteBtn">글 삭제</button>
      </c:if>
    </div>

    <div class="mt-3">
      <c:if test="${not empty member.id}">
        <input type="hidden" id="sessionId" value="${member.id}">
        <textarea id="replyContent" class="form-control" rows="3"></textarea>
        <div class="mb-3">
          <button type="button" class="btn btn-outline-secondary mt-3" id="replyAddBtn">등록</button>
        </div>
      </c:if>
    </div>

    <table class="table">
      <colgroup>
        <col width="55%"/>
        <col width="15%"/>
        <col width="15%"/>
        <col width="15%"/>
      </colgroup>
      <thead>
      <tr>
        <td>댓글 ${fn:length(list)}개</td>
        <td>작성자</td>
        <td>작성 날짜</td>
        <td></td>
      </tr>
      </thead>
      <tbody id="replyResult">
        <c:forEach items="${list}" var="reply">
          <tr>
            <td id="${reply.replyNum}"><pre>${reply.content}</pre></td>
            <td>${reply.id}</td>
            <td><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd"/></td>
            <td>
              <c:if test="${reply.id eq member.id}">
                <button type="button" class="btn btn-outline-secondary mx-2 replyUpdateBtn" data-num="${reply.replyNum}">수정</button>
                <button type="button" class="btn btn-outline-secondary mx-2 replyDelBtn" data-num="${reply.replyNum}">삭제</button>
              </c:if>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>


  </div>
</div>
</div>

<!-- 댓글 수정 모달 -->
<div class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" id="updateModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">댓글 수정</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>수정 할 내용을 입력해주세요.</p>
        <input type="hidden" id="replyNum" value="">
        <textarea id="modalText" class="form-control" rows="3"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" id="modalUpdateBtn" class="btn btn-primary">수정</button>
      </div>
    </div>
  </div>
</div>

<script src="/js/boardDetail.js"></script>
</body>
</html>
