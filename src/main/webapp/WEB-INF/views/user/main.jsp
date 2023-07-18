<%@ page import="java.util.List" %>
<%@ page import="com.daonplace.springbootweb.domain.user.User" %>
<%@ page import="com.daonplace.springbootweb.domain.user.board.Board" %>
<%@ page import="com.daonplace.springbootweb.domain.user.board.BoardStatus" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인 페이지</title>
    <link rel="stylesheet" href="/css/main.css">
</head>

<body>
<div class="container">
    <main class="Main">
        <!--메인 페이지 섹션 시작-->
        <section class="main">
            <h1>빛깔 웹페이지에 오신걸 환영합니다!</h1>

            <div class="buttons-container">
                <!-- 게시글 등록 버튼 -->
                <button class="btn add-board-btn" onclick="location.href='/user/addBoard'">게시글 등록</button>

                <!-- 사용자 프로필 버튼 -->
                <button class="btn profile-btn" onclick="location.href='/user/profile/${user.id}'">사용자 프로필</button>
            </div>

            <div class="search-container">
                <!-- 드롭박스 -->
                <select class="dropdown">
                    <option value="전체">전체</option>
                    <option value="자유게시판">자유게시판</option>
                    <option value="질문&답변">질문&답변</option>
                    <option value="육아">육아</option>
                    <option value="제보/알림">제보/알림</option>
                </select>

<%--                <select name="boardStatus" required="required">--%>
<%--                    <option value="" disabled selected>게시글 상태 선택</option>--%>
<%--                        <% for (BoardStatus boardStatus : boardStatuses) { %>--%>
<%--                    <option value="<%= boardStatus.name() %>" <% if (board.getBoardStatus() == boardStatus) { %>selected<% } %>>--%>
<%--                        <%= boardStatus.name() %>--%>
<%--                    </option>--%>
<%--                        <% } %>--%>

                <!-- 검색 기능 -->
                <div class="search-bar">
                    <input type="text" id="search-input" placeholder="게시글 제목 검색">
                    <button class="btn search-btn" onclick="executeSearch()">검색</button>
                </div>
            </div>

            <!-- 게시글 리스트 -->
            <div class="board-list">
                <h2>게시글 리스트</h2>
                <ul id="board-list-container">
                    <%-- 서버에서 가져온 게시글 데이터를 반복하여 출력하는 로직 --%>
                    <% for (Board board : (List<Board>) request.getAttribute("boards")) { %>
                    <% User user = (User) request.getAttribute("user"); %>
                    <li>
                        <h3> <a href="/user/board/<%= user.getId() %>/<%= board.getId() %>"><%= board.getTitle() %></a></h3>
                        <p><%= board.getBoardType() %> | <%= board.getBoardStatus() %></p>
                        <p><%= board.getContent() %></p>
                    </li>
                    <% } %>
                </ul>
            </div>

        </section>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/main.js"></script>
</body>

</html>
