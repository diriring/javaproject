<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022-08-24
  Time: 오전 9:34
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

    <blockquote class="blockquote">
        <h1 class="my-4">자유 게시판</h1>
        <footer class="blockquote-footer">보드게임에 관해 자유롭게 의견을 나눠주세요.</footer>
    </blockquote>

    <form action="./boardList" method="get">
        <div class="col-2 d-inline-block">
            <select class="form-select" name="kind" id="kind" aria-label="Default select example">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="id">작성자</option>
            </select>
        </div>
        <div class="col-3 d-inline-block">
            <div class="input-group mb-3">
                <input type="text" name="search" id="search" class="form-control" placeholder="검색어를 입력하세요." value="${pager.search}">
                <button class="btn btn-outline-secondary" type="submit">검색</button>
            </div>
        </div>
    </form>
    <table class="table table-striped table-hover table-bordered text-center">
        <colgroup>
            <col width="20%"/>
            <col width="50%"/>
            <col width="10%"/>
            <col width="10%"/>
            <col width="10%"/>
        </colgroup>
        <thead>
        <tr>
            <th>말머리</th>
            <th>글 제목</th>
            <th>작성자</th>
            <th>작성날짜</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody id="listResult">
            <c:forEach items="${list}" var="vo">
                <tr>
                    <td>${vo.categoryVO.categoryName}</td>
                    <td><a href="./boardDetail?boardNum=${vo.boardNum}">${vo.title}</a></td>
                    <td>${vo.id}</td>
                    <td><fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${vo.hit}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    <div class="row justify-content-between">
        <div class="col-3">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="./boardList?pn=${pager.pre?pager.startNum-1:1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                        <c:choose>
                            <c:when test="${pager.pn eq i}">
                                <li class="page-item active" aria-current="page">
                                    <a class="page-link" href="./boardList?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="./boardList?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="./boardList?pn=${pager.next?pager.lastNum+1:pager.lastNum}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-9">
            <div class="d-grid  justify-content-end">
                <a href="./boardWrite" class="btn btn-outline-primary">글쓰기</a>
            </div>
        </div>
    </div>

<%--    <div class="row">--%>

<%--        <div class="col-1">--%>
<%--            <a class="btn btn-outline-primary d-block text-right" href="./boardWrite">글 쓰기</a>--%>
<%--        </div>--%>
<%--    </div>--%>

</div>



</body>
</html>
