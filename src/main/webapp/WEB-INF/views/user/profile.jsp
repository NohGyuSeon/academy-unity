<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!--프로필 섹션-->
<section class="profile">
	<!--유저정보 컨테이너-->
	<div class="profileContainer">

<!--로그아웃, 회원정보변경 모달-->
<div class="modal-info" onclick="modaalInfo()">
	<div class="modal">
		<button class="btn" onclick="location.href='/user/updateProfile/${user.id}'">회원정보 변경</button>
		<button class="btn" onclick="location.href='/logout'">로그아웃</button>
		<button class="btn" onclick="location.href='/'">취소버튼</button>
	</div>
</div>
<!--로그아웃, 회원정보변경 모달 end-->

<script src="/js/profile.js"></script>

<%@ include file="../layout/footer.jsp"%>
