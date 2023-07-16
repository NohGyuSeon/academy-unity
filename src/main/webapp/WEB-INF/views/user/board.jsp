<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 페이지</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
      }

      .container {
        max-width: 800px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      }

      h1 {
        color: #333;
        text-align: center;
      }

      .meta-data {
        margin-bottom: 20px;
      }

      .meta-data span {
        font-weight: bold;
      }

      .content {
        white-space: pre-wrap;
      }

      .button-container {
        text-align: center;
      }

      .button-container .btn {
        margin: 10px;
        padding: 10px 30px;
        border-radius: 30px;
      }

      .btn-edit {
        background-color: #007bff;
        color: #fff;
      }

      .btn-delete {
        background-color: #dc3545;
        color: #fff;
      }

      .btn-cancel {
        background-color: #6c757d;
        color: #fff;
      }
    </style>
</head>
<body>
<div class="container">
    <h1>게시글</h1>
    <div class="meta-data">
        <span>제목:</span> <span><%= request.getAttribute("board.title") %></span>
    </div>
    <div class="meta-data">
        <span>작성자:</span> <span><%= request.getAttribute("board.writer") %></span>
    </div>
    <div class="content"><%= request.getAttribute("board.content") %></div>
    <div class="button-container">
        <a class="btn btn-edit" href="editForm.html">게시글 수정</a>
        <form action="board.html" method="post" style="display: inline;">
            <input type="hidden" name="_method" value="delete"/>
            <button type="submit" class="btn btn-delete">게시글 삭제</button>
        </form>
        <a class="btn btn-cancel" href="boards.html">취소</a>
    </div>
</div>
</body>
</html>
