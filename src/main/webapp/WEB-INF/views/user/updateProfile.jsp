<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 프로필 수정 페이지</title>
    <link rel="stylesheet" href="/css/updateProfile.css">
</head>
<body>
<div class="container">
    <main class="updateProfileMain">
        <!--사용자 프로필 수정 섹션 시작-->
        <section class="updateProfile">
            <!--사용자 프로필 수정 박스 시작-->
            <article class="updateProfile__form__container">
                <!--사용자 프로필 수정 폼 시작-->
                <div class="updateProfile__form">
                    <h2>사용자 프로필 수정</h2>
                    <!--사용자 프로필 입력 폼 시작-->
                    <form id="updateProfileForm" class="updateProfile__input">
                        <input type="hidden" id="userId" value="${principal.user.id}">
                        <div class="content-item__01">
                            <div class="item__title">이메일</div>
                            <div class="item__input">
                                <input type="text" name="email" placeholder="이메일"
                                       value="${principal.user.email}" required="required" />
                            </div>
                        </div>
                        <div class="content-item__02">
                            <div class="item__title">비밀번호</div>
                            <div class="item__input">
                                <input type="password" name="password" placeholder="비밀번호" required="required" />
                            </div>
                        </div>
                        <div class="content-item__03">
                            <div class="item__title">별명</div>
                            <div class="item__input">
                                <input type="text" name="username" placeholder="별명"
                                       value="${principal.user.username}" required="required" />
                            </div>
                        </div>
                        <button class="btn btn-edit" onclick="updateProfile(${userId}, event)">수정</button>
                        <button class="btn btn-cancel" type="button" onclick="goToProfile(${userId})">취소</button>
                    </form>
                    <!--사용자 프로필 입력 폼 종료-->
                </div>
            </article>
        </section>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/updateProfile.js"></script>
</body>
</html>
