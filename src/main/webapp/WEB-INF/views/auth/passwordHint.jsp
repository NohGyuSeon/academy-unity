<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.daonplace.springbootweb.domain.user.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>비밀번호 찾기 페이지(비밀번호 힌트 입력)</title>
    <link rel="stylesheet" href="/css/passwordHint.css">
</head>
<body>
<% User user = (User) request.getAttribute("user"); %>
<p><%= user.getHint() %></p>
<%-- 사용자로부터 힌트(hint) 를 가져와서 뿌리고, 아래 입력 창에서 answer를 입력하여 매핑 시, 비번 응답 --%>
<div class="search-bar">
    <input type="hidden" id="userId" value="${user.id}">
    <input type="text" id="find-answer" name="answer" placeholder="정답" required="required" />
    <button class="btn find-btn" onclick="searchAnswer(${userId})">찾기</button>
</div>
</form>
</body>
<script src="/js/passwordHint.js"></script>
</html>
