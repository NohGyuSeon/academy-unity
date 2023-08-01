<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성 페이지</title>
    <link rel="stylesheet" href="/css/addBoard.css">
</head>

<body>
<div class="container">
    <main class="addBoardMain">
        <!--게시글 등록 섹션 시작-->
        <section class="addBoard">
            <!--게시글 등록 박스 시작-->
            <article class="addBoard__form__container">
                <!--게시글 등록 폼 시작-->
                <div class="addBoard__form">
                    <h2>게시글 등록</h2>

                    <!--게시글 입력 폼 시작-->
                    <form class="addBoard__input" action="/user/addBoard" method="POST">
                        <input type="text" name="title" placeholder="제목" required="required">
                        <textarea name="content" placeholder="내용" required="required"></textarea>
                        <select name="boardType" required="required">
                            <option value="" disabled selected>게시판 선택</option>
                            <option value="free">자유게시판</option>
                            <option value="qna">질문&답변</option>
                            <option value="technology">기술</option>
                            <option value="alert">제보/알림</option>
                        </select>
                        <select name="boardStatus" required="required">
                            <option value="" disabled selected>게시글 상태 선택</option>
                            <option value="write">작성</option>
                            <option value="hold">보류</option>
                        </select>
                        <button class="register-btn">등록</button>
                        <button class="cancel-btn" onclick="location.href='/'">취소</button>
                    </form>
                    <!--게시글 입력 폼 종료-->
                </div>
                <!--게시글 등록 폼 종료-->
            </article>
            <!--게시글 등록 박스 종료-->
        </section>
        <!--게시글 등록 섹션 종료-->
    </main>
</div>
</body>

</html>
