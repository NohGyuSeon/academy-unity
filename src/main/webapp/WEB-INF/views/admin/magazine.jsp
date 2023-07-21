<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메거진 상세 페이지</title>
    <link rel="stylesheet" href="/css/board.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%--    css 수정 필요--%>
</head>
<body>
<div class="container">
    <h1>게시글</h1>
    <div class="meta-data">
        <span>제목:</span> <span>${magazine.title}</span>
    </div>
    <div class="meta-data">
        <span>상태:</span> <span>${magazine.magazineStatus}</span>
    </div>
    <div class="content">${magazine.content}</div>
    <div class="button-container">
        <button class="btn btn-edit" type="button" onclick="goToUpdateMagazine(${user.id}, ${magazine.id})">메거진 수정</button>
        <button class="btn btn-delete" onclick="confirmDelete(${user.id}, ${magazine.id})">메거진 삭제</button>
        <button class="btn btn-cancel" onclick="location.href='/admin/manage'">취소</button>
    </div>
</div>
<script src="/js/magazine.js"></script>
</body>
</html>
