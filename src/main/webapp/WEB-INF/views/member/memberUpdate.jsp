<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-23
  Time: 오전 10:12
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
        <h1 class="my-4">회원 정보 수정</h1>
        <footer class="blockquote-footer">회원 정보를 수정하실 수 있습니다.</footer>
    </blockquote>

    <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력해주세요." value="${memberVO.name}">
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">E-Mail</label>
        <div class="input-group">
            <input type="email" class="form-control" name="email" id="email" placeholder="이메일을 입력해주세요." value="${memberVO.email}">
            <button type="button" id="emailCheckBtn" class="btn btn-outline-secondary">중복확인</button>
        </div>
    </div>

    <div class="mb-3">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" class="form-control" name="phone" id="phone" placeholder="전화번호를 입력해주세요." value="${memberVO.phone}">
    </div>

    <div class="mb-3">
        <input type="hidden" id="id" value="${member.id}">
        <button type="button" id="updateBtn" class="btn btn-primary mb-3">수정</button>
    </div>

</div>

<script src="/js/memberUpdate.js"></script>

</body>
</html>
