<%@ page import="com.daonplace.springbootweb.domain.admin.Magazine" %>
<%@ page import="com.daonplace.springbootweb.domain.admin.MagazineStatus" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메거진 수정 페이지</title>
    <link rel="stylesheet" href="/css/updateBoard.css">
    <%--    css 수정 필요--%>
</head>
<body>s
<div class="container">
    <main class="updateBoardMain">
        <!--메거진 수정 섹션 시작-->
        <section class="updateBoard">
            <!--메거진 수정 박스 시작-->
            <article class="updateBoard__form__container">
                <!--메거진 수정 폼 시작-->
                <div class="updateBoard__form">
                    <h2>메거진 수정</h2>
                    <!--메거진 입력 폼 시작-->
                    <form id="updateMagazineForm" class="updateBoard__input">
                        <input type="hidden" id="userId" value="${principal.user.id}">
                        <input type="hidden" id="magazineId" value="${magazine.id}">
                        <input type="text" name="title" placeholder="제목" value="${magazine.title}" required="required">
                        <textarea name="content" placeholder="내용" required="required">${magazine.content}</textarea>
                        <% Magazine magazine = (Magazine) request.getAttribute("magazine"); %>
                        <% MagazineStatus[] magazineStatuses = MagazineStatus.values(); %>
                        <select name="boardStatus" required="required">
                            <option value="" disabled selected>메거진 상태 선택</option>
                            <% for (MagazineStatus magazineStatus : magazineStatuses) { %>
                            <option value="<%= magazineStatus.name() %>" <% if (magazine.getMagazineStatus() == magazineStatus) { %>selected<% } %>>
                                <%= magazineStatus.name() %>
                            </option>
                            <% } %>
                        </select>
                        <button class="btn update-btn" onclick="updateMagazine(${userId}, ${magazineId}, event)">수정</button>
                        <button class="btn btn-cancel" type="button" onclick="goToMagazine(${userId}, ${magazineId})">취소</button>
                    </form>
                    <!--메거진 입력 폼 종료-->
                </div>
                <!--메거진 수정 폼 종료-->
            </article>
            <!--메거진 수정 박스 종료-->
        </section>
        <!--메거진 수정 섹션 종료-->
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/updateMagazine.js"></script>
</body>
</html>
