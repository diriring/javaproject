<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-24
  Time: 오전 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../header/header_script.jsp"></c:import>

    <!-- Summernote -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

    <title>Title</title>
</head>
<body>

<c:import url="../header/header.jsp"></c:import>

<div class="container">

  <div class="row">
      <div class="row mt-5">
        <div class="input-group mb-3">
          <span class="input-group-text">글 제목</span>
          <input type="text" name="title" id="title" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1" onkeyup="saveValue(this);">
          <span class="input-group-text">작성자</span>
          <input type="text" name="id" id="id" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" value="${member.id}" readonly="readonly">
          <span class="input-group-text">말머리</span>
          <select class="form-select" id="categoryNum">
            <option value="1">자유토크</option>
            <option value="2">보드게임 소개</option>
            <option value="3">보드게임 파티 모집</option>
            <option value="4">보드게임 카페 추천</option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="input-group">
          <textarea name="content" class="form-control" aria-label="With textarea" id="content"></textarea>
        </div>
      </div>

      <div class="my-5">
        <button type="button" id="addBtn" class="btn btn-primary">글 등록</button>
        <a href="./boardList" class="btn btn-outline-danger">돌아가기</a>
      </div>
  </div>
</div>

<script src="/js/summernote.js"></script>
<script src="/js/boardWrite.js"></script>
</body>
</html>
