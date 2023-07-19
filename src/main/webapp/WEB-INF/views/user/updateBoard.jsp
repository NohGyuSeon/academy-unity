<%@ page import="com.daonplace.springbootweb.domain.user.board.Board" %>
<%@ page import="com.daonplace.springbootweb.domain.user.board.BoardType" %>
<%@ page import="com.daonplace.springbootweb.domain.user.board.BoardStatus" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정 페이지</title>
    <link rel="stylesheet" href="/css/updateBoard.css">
</head>
<body>
<div class="container">
    <main class="updateBoardMain">
        <!--게시글 수정 섹션 시작-->
        <section class="updateBoard">
            <!--게시글 수정 박스 시작-->
            <article class="updateBoard__form__container">
                <!--게시글 수정 폼 시작-->
                <div class="updateBoard__form">
                    <h2>게시글 수정</h2>
                    <!--게시글 입력 폼 시작-->
                    <form id="updateBoardForm" class="updateBoard__input">
                        <input type="hidden" id="userId" value="${principal.user.id}">
                        <input type="hidden" id="boardId" value="${board.id}">
                        <input type="text" name="title" placeholder="제목" value="${board.title}" required="required">
                        <textarea name="content" placeholder="내용" required="required">${board.content}</textarea>
                        <% Board board = (Board) request.getAttribute("board"); %>
                        <% BoardType[] boardTypes = BoardType.values(); %>
                        <% BoardStatus[] boardStatuses = BoardStatus.values(); %>
                        <select name="boardType" required="required">
                            <option value="" disabled selected>게시판 선택</option>
                            <% for (BoardType boardType : boardTypes) { %>
                            <option value="<%= boardType.name() %>" <% if (board.getBoardType() == boardType) { %>selected<% } %>>
                                <%= boardType.name() %>
                            </option>
                            <% } %>
                        </select>
                        <select name="boardStatus" required="required">
                            <option value="" disabled selected>게시글 상태 선택</option>
                            <% for (BoardStatus boardStatus : boardStatuses) { %>
                            <option value="<%= boardStatus.name() %>" <% if (board.getBoardStatus() == boardStatus) { %>selected<% } %>>
                                <%= boardStatus.name() %>
                            </option>
                            <% } %>
                        </select>
                        <button class="btn update-btn" onclick="updateBoard(${userId}, ${boardId}, event)">수정</button>
                        <button class="btn btn-cancel" type="button" onclick="goToBoard(${userId}, ${boardId})">취소</button>
                    </form>
                    <!--게시글 입력 폼 종료-->
                </div>
            </article>
        </section>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/updateBoard.js"></script>
</body>
</html>
