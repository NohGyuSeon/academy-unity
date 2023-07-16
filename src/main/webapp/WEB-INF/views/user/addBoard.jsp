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
                            <option value="parenting">육아</option>
                            <option value="alert">제보/알림</option>
                        </select>
                        <button class="register-btn">등록</button>
                        <button class="cancel-btn" onclick="location.href='/'">취소</button>
                    </form>
                    <!--게시글 입력 폼 종료-->
                </div>
            </article>
        </section>
    </main>
</div>
<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
<%--<script>--%>
<%--  $(document).ready(function() {--%>
<%--    // 등록 버튼 클릭 시 AJAX 요청 전송--%>
<%--    $(".register-btn").click(function(e) {--%>
<%--      e.preventDefault(); // 기본 동작 방지 (페이지 새로고침 등)--%>

<%--      // 입력된 데이터 가져오기--%>
<%--      var title = $("input[name='title']").val();--%>
<%--      var content = $("textarea[name='content']").val();--%>
<%--      var boardType = $("select[name='boardType']").val();--%>

<%--      // AJAX 요청 설정--%>
<%--      $.ajax({--%>
<%--        url: "/user/addBoard",--%>
<%--        type: "POST",--%>
<%--        data: {--%>
<%--          title: title,--%>
<%--          content: content,--%>
<%--          boardType: boardType--%>
<%--        },--%>
<%--        success: function(response) {--%>
<%--          // 요청이 성공적으로 처리된 경우--%>
<%--          if (response === "success") {--%>
<%--            console.log("게시글 등록 성공");--%>
<%--            // 페이지 리다이렉션--%>
<%--            window.location.href = "/user/main";--%>
<%--          } else {--%>
<%--            console.log("게시글 등록 실패");--%>
<%--            // 실패 처리 동작 구현--%>
<%--          }--%>
<%--        },--%>
<%--        error: function(xhr, status, error) {--%>
<%--          // 요청 처리 중 에러가 발생한 경우--%>
<%--          console.log("게시글 등록 실패");--%>
<%--          // 에러 처리 동작 구현--%>
<%--        }--%>
<%--      });--%>
<%--    });--%>
<%--  });--%>
<%--</script>--%>
<%--</body>--%>

<%--</html>--%>
