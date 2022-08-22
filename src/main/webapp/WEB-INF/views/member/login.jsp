<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-22
  Time: 오후 5:39
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
    <h1 class="my-4">로그인</h1>
    <footer class="blockquote-footer">로그인 후 이용해주세요.</footer>
  </blockquote>
  <form action="#" method="POST">
    <div class="mb-3">
      <label for="id" class="form-label">ID</label>
      <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력해주세요.">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">비밀번호</label>
      <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호를 입력해주세요.">
    </div>
    <div class="mb-3">
      <button type="button" id="loginBtn" class="btn btn-primary mb-3">로그인</button>
    </div>
  </form>
</div>

<script src="/js/login.js"></script>
</body>
</html>
