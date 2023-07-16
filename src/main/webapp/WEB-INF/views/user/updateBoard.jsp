a<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                    <form class="updateBoard__input" action="/user/updateBoard" method="POST">
                        <input type="hidden" name="boardId" value="<%= request.getAttribute("boardId") %>">
                        <input type="text" name="title" placeholder="제목" value="<%= request.getAttribute("board.title") %>" required="required">
                        <textarea name="content" placeholder="내용" required="required"><%= request.getAttribute("board.content") %></textarea>
                        <select name="boardType" required="required">
                            <option value="" disabled selected>게시판 선택</option>
                            <option value="free" <% if (request.getAttribute("board.boardType").equals("free")) { %>selected<% } %>>자유게시판</option>
                            <option value="qna" <% if (request.getAttribute("board.boardType").equals("qna")) { %>selected<% } %>>질문&amp;답변</option>
                            <option value="parenting" <% if (request.getAttribute("board.boardType").equals("parenting")) { %>selected<% } %>>육아</option>
                            <option value="alert" <% if (request.getAttribute("board.boardType").equals("alert")) { %>selected<% } %>>제보/알림</option>
                        </select>
                        <select name="boardStatus" required="required">
                            <option value="" disabled selected>게시글 상태 선택</option>
                            <option value="write" <% if (request.getAttribute("board.boardStatus").equals("write")) { %>selected<% } %>>작성</option>
                            <option value="hold" <% if (request.getAttribute("board.boardStatus").equals("hold")) { %>selected<% } %>>보류</option>
                        </select>
                        <button class="update-btn">수정</button>
                        <button class="cancel-btn" onclick="location.href='/user/board/<%= request.getAttribute("userId") %>/<%= request.getAttribute("boardId") %>'">취소</button>
                    </form>
                    <!--게시글 입력 폼 종료-->
                </div>
            </article>
        </section>
    </main>
</div>
</body>
</html>
