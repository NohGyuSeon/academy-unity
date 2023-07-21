<%@ page import="java.util.List" %>
<%@ page import="com.daonplace.springbootweb.domain.user.User" %>
<%@ page import="com.daonplace.springbootweb.domain.user.board.Board" %>
<%@ page import="com.daonplace.springbootweb.domain.admin.Magazine" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인 페이지</title>
    <link rel="stylesheet" href="/css/main.css">
    <%--    css 수정 필요--%>
</head>

<body>
<div class="container">
    <main class="Main">
        <!--메인 페이지 섹션 시작-->
        <section class="main">
            <h1>관리자 페이지 입니다.</h1>

            <div class="buttons-container">
                <!-- 메거진 등록 버튼 -->
                <button class="btn add-board-btn" onclick="location.href='/admin/addMagazine'">메거진 등록</button>
            </div>

            <!-- 검색 기능 -->
            <div class="search-bar">
                <input type="text" id="search-input" placeholder="메거진 제목 검색">
                <button class="btn search-btn" onclick="executeSearch()">검색</button>
            </div>

            <!-- 메거진 리스트 -->
            <div class="board-list">
                <h2>메거진 리스트</h2>
                <ul id="board-list-container">
                    <%-- 서버에서 가져온 메거진 데이터를 반복하여 출력하는 로직 --%>
                    <% for (Magazine magazine : (List<Magazine>) request.getAttribute("magazines")) { %>
                    <% User user = (User) request.getAttribute("user"); %>
                    <li>
                        <h3> <a href="/admin/magazine/<%= user.getId() %>/<%= magazine.getId() %>"><%= magazine.getTitle() %></a></h3>
                        <p><%= magazine.getMagazineStatus() %></p>
                        <p><%= magazine.getContent() %></p>
                    </li>
                    <% } %>
                </ul>
            </div>

        </section>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/manage.js"></script>
</body>

</html>
