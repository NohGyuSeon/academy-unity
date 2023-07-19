<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>회원가입 페이지</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <main class="loginMain">
        <!--회원가입 섹션 시작-->
        <section class="login">
            <article class="login__form__container">
                <!--회원가입 폼 시작-->
                <div class="login__form">
                    <!--로고 시작-->
                    <h2><img src="/images/logo.jpg" alt=""></h2>
                    <!--로고 종료-->
                    <!--회원가입 인풋 시작-->
                    <form class="login__input" action="/auth/signup" method="post">
                        <input type="email" name="email" placeholder="이메일" required="required" />
                        <input type="password" name="password" placeholder="비밀번호" required="required" />
                        <input type="text" name="username" placeholder="별명" required="required" maxlength="30"/>
                        <input type="text" name="hint" placeholder="비밀번호 힌트" required="required" maxlength="30"/>
                        <input type="text" name="answer" placeholder="힌트 정답" required="required" maxlength="30"/>
                        <button>가입</button>
                    </form>
                    <!--회원가입 인풋 종료-->
                </div>
                <!--회원가입 폼 종료-->
                <!--계정이 있으신가요? 시작-->
                <div class="login__register">
                    <span>계정이 있으신가요?</span>
                    <a href="/auth/signin">로그인</a>
                </div>
                <!--계정이 있으신가요? 종료-->
            </article>
        </section>
    </main>
</div>
</body>
</html>
