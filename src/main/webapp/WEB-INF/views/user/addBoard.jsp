<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Board</title>
    <link rel="stylesheet" href="/css/addBoard.css">
</head>

<body>
<div class="container">
    <main class="Main">
        <!--메인 페이지 섹션 시작-->
        <section class="main">
            <h1>게시글 등록</h1>

            <!-- 게시글 등록 폼 -->
            <form action="/user/addBoard" method="post">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title" required>
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea id="content" name="content" required></textarea>
                </div>
                <button class="btn" type="submit">등록</button>
                <button class="btn" onclick="location.href='/user/main'">취소</button>
            </form>
        </section>
    </main>
</div>
<script src="/js/addBoard.js"></script>
</body>

</html>
