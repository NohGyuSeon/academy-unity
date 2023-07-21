<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메거진 작성 페이지</title>
    <link rel="stylesheet" href="/css/addBoard.css">
    <%--    css 수정 필요--%>
</head>

<body>
<div class="container">
    <main class="addBoardMain">
        <!--메거진 등록 섹션 시작-->
        <section class="addBoard">
            <!--메거진 등록 박스 시작-->
            <article class="addBoard__form__container">
                <!--메거진 등록 폼 시작-->
                <div class="addBoard__form">
                    <h2>메거진 등록</h2>

                    <!--메거진 입력 폼 시작-->
                    <form class="addBoard__input" action="/admin/addMagazine" method="POST">
                        <input type="text" name="title" placeholder="제목" required="required">
                        <textarea name="content" placeholder="내용" required="required"></textarea>
                        <select name="boardStatus" required="required">
                            <option value="" disabled selected>메거진 상태 선택</option>
                            <option value="publish">발행</option>
                            <option value="hold">보류</option>
                        </select>
                        <button class="register-btn">등록</button>
                        <button class="cancel-btn" onclick="location.href='/admin/manage'">취소</button>
                    </form>
                    <!--메거진 입력 폼 종료-->
                </div>
                <!--메거진 등록 폼 종료-->
            </article>
            <!--메거진 등록 박스 종료-->
        </section>
        <!--메거진 등록 섹션 종료-->
    </main>
</div>
</body>

</html>
