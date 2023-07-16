<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 페이지</title>
    <link rel="stylesheet" href="/css/board.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container">
    <h1>게시글</h1>
    <div class="meta-data">
        <span>제목:</span> <span>${board.title}</span>
    </div>
    <div class="meta-data">
        <span>작성자:</span> <span>${user.username}</span>
    </div>
    <div class="meta-data">
        <span>카테고리:</span> <span>${board.boardType}</span>
        <span>상태:</span> <span>${board.boardStatus}</span>
    </div>
    <div class="content">${board.content}</div>
    <div class="button-container">
        <a class="btn btn-edit" href="/user/updateBoard/${user.id}/${board.id}">게시글 수정</a>
        <button class="btn btn-delete" onclick="confirmDelete(${user.id}, ${board.id})">게시글 삭제</button>
        <a class="btn btn-cancel" href="/user/main">취소</a>
    </div>
</div>
<script src="/js/board.js"></script>
</body>
</html>
