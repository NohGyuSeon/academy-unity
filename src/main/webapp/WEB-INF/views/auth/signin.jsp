<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="/css/style.css">
<%--    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"--%>
<%--          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />--%>
</head>

<body>
<div class="container">
    <main class="loginMain">
        <!--로그인 섹션 시작-->
        <section class="login">
            <!--로그인 박스 시작-->
            <article class="login__form__container">
                <!--로그인 폼 시작-->
                <div class="login__form">
                    <h2><img src="/images/logo.jpg" alt=""></h2>

                    <!--로그인 인풋 시작-->
                    <form class="login__input" action="/auth/signin" method="POST">
                        <input type="text" name="email" placeholder="이메일" required="required"/>
                        <input type="password" name="password" placeholder="비밀번호" required="required">
                        <button>로그인</button>
                    </form>
                    <!--로그인 인풋 종료-->
                    
                    <!--또는 시작-->
                    <div class="login__horizon">
                        <div class="br"></div>
                        <div class="or">또는</div>
                        <div class="br"></div>
                    </div>
                    <!--또는 종료-->

                    <!--Oauth 소셜로그인 시작-->
                    <!--보류-->
                    <!--Oauth 소셜로그인 종료-->
                </div>

                <!--비밀번호 찾기 시작-->
                <div class="password__reset">
                    <a href="/password">비밀번호 찾기</a>
                </div>
                <!--비밀번호 찾기 종료-->

                <!--계정이 없으신가요? 시작-->
                <div class="login__register">
                    <span>계정이 없으신가요?</span>
                    <a href="/auth/signup">회원가입</a>
                </div>
                <!--계정이 없으신가요? 종료-->

            </article>
        </section>
    </main>
</div>
</body>

</html>