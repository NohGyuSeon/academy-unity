<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>비밀번호 찾기 페이지(정답 입력)</title>
    <link rel="stylesheet" href="/css/passwordHint.css">
</head>
<body>
<p>${user.hint}</p>
<div class="search-bar">
    <input type="text" id="find-answer" name="answer" placeholder="정답" required="required" />
    <button class="btn find-btn" onclick="searchAnswer(${user.id})">찾기</button>
</div>
</form>
</body>
<script src="/js/passwordHint.js"></script>
</html>
