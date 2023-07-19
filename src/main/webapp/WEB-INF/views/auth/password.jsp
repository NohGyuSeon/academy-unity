<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>비밀번호 찾기 페이지</title>
    <link rel="stylesheet" href="/css/password.css">
</head>
<body>
    <form class="email__input" action="/auth/password" method="post">
        <input type="email" id="find-input" name="email" placeholder="이메일" required="required" />
        <button class="btn find-btn" onclick="executeFind()">찾기</button>
    </form>
</body>
<script src="/js/password.js"></script>
</html>
