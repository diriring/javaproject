<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-23
  Time: 오전 9:45
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
    <h1 class="my-4">마이페이지</h1>
    <footer class="blockquote-footer">환영합니다, ${member.id}님.</footer>
  </blockquote>

  <input type="hidden" id="sessionId" value="${member.id}">

  <table class="table table-bordered text-center">
    <colgroup>
      <col width="35%"/>
      <col width="65%"/>
    </colgroup>
    <thead>
    <tr>
      <td colspan="2">회원정보</td>
    </tr>
    <tr>
      <td>아이디</td>
      <td>${memberVO.id}</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${memberVO.name}</td>
    </tr>
    <tr>
      <td>이메일</td>
      <td>${memberVO.email}</td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td>${memberVO.phone}</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
  </table>

  <a class="btn btn-outline-primary" href="./memberUpdate">회원 정보 수정</a>
  <a class="btn btn-outline-primary" href="./memberDelete">회원 탈퇴</a>

</div>
</body>
</html>
