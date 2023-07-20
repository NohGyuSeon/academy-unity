<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>비밀번호 수정 페이지</title>
    <link rel="stylesheet" href="/css/passwordUpdate.css">
</head>
<body>
<div class="search-bar">
    <input type="password" id="update-password1" name="password" placeholder="비밀번호1" required="required" />
    <input type="password" id="update-password2" name="password" placeholder="비밀번호2" required="required" />
    <button class="btn find-btn" onclick="matchPassword(${user.id})">변경</button>
</div>
</form>
</body>
<script src="/js/passwordUpdate.js"></script>
</html>
