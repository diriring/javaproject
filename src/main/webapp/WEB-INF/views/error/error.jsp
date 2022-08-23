<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-23
  Time: 오후 4:15
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
<div class="container text-center">
    <h1 class="mt-5">Error Page</h1>
    error code : ${code}<br>
    error msg : ${msg}
    <div>
        <a class="btn btn-outline-primary my-3" href="/">홈으로</a>
    </div>
</div>

</body>
</html>
