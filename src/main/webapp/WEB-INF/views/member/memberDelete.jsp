<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-23
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="../header/header_script.jsp"></c:import>
    <title>Title</title>
</head>
<body>

<c:import url="../header/header.jsp"></c:import>

<div class="container">

  <blockquote class="blockquote">
    <h1 class="my-4">회원탈퇴</h1>
    <footer class="blockquote-footer">탈퇴 하시려면 비밀번호를 입력해주세요.</footer>
  </blockquote>

  <div class="mb-3">
    <label for="password" class="form-label">비밀번호</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력해주세요.">
  </div>

  <div class="mb-3">
    <button type="button" id="deleteBtn" class="btn btn-primary mb-3">회원 탈퇴</button>
  </div>
</div>

<script src="/js/memberDelete.js"></script>
</body>
</html>
