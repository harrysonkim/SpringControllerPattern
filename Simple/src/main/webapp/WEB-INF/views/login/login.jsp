<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
<form class="form" action="/login/login" method="post">
<div class="form-signin m-auto">
<div class="d-grid gap-2 col-4 mx-auto">
<div class="mt-5 mb-5"></div>

<h1 class="text-center mt-5 mb-5">점집닷컴</h1>

<div class="form-floating mb-3">
  <input type="text" class="form-control" name="user_nick" name="user_email" id="user_email" placeholder="Email">
  <label for="floatingInput">Email</label>
</div>

<div class="form-floating">
  <input type="password" class="form-control" name="user_pw" id="user_pw" placeholder="Password">
  <label for="floatingPassword">Password</label>
</div>

<div class="container">
<div class="row">

<div class="form-check form-switch col">
  <input class="form-check-input mb-3" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
  <label class="form-check-label" for="flexSwitchCheckChecked">로그인 상태 유지</label>
</div>

</div>
</div>

<button class="btn btn-primary btn-lg">로그인</button>
</div>
</div>
</form>

<a href="/user/join"><button class="btn btn-outline-secondary btn-lg" type="button">회원가입</button></a>

<div class="nav justify-content-center col">
	<div class="nav-item"><a class="nav-link" href="#">아이디 찾기</a></div>	
	<div class="nav-item"><a class="nav-link disabled" href="#">|</a></div>	
	<div class="nav-item"><a class="nav-link" href="#">비밀번호 찾기</a></div>
</div>

<!-- 네이버 로그인 -->

<div class="container">
  <a href="#"><img height="50" src="/resources/img/btnG_iconCircle.png"/></a>
  <a href="#"><img height="50" src="/resources/img/kakao_logo_round.png"/></a>
</div>
</div>


</body>
</html>