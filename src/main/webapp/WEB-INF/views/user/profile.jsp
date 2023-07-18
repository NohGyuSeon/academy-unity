<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 프로필 페이지</title>
	<link rel="stylesheet" href="/css/profile.css">
	<script scr="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="content">
	<h1>프로필</h1>
	<div content="meta-data">
		<span>이메일: </span> <span>${principal.user.email}</span>
	</div>
	<div content="meta-data">
		<span>별명: </span> <span>${principal.user.username}</span>
	</div>
</div>
<div class="button-container">
	<button class="btn btn-edit" type="button" onclick="goToUpdateProfile(${principal.user.id})">프로필 수정</button>
	<button class="btn btn-logout" onclick="location.href='/logout'">로그아웃</button>
	<button class="btn btn-cancel" onclick="location.href='/user/main'">취소</button>
</div>
<script src="/js/profile.js"></script>
</body>
</html>
