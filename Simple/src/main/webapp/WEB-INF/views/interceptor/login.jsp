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
<form class="form" action="/interceptor/login" method="post">
<div class="form-control">
<div class="d-grid gap-2 col-6 mx-auto">

<h1 class="text-center">인터셉터 테스트</h1>
<h1 class="text-center">로그인</h1>

<div class="form-floating mb-3">
  <input type="text" class="form-control" name="userId" id="userId" placeholder="ID">
  <label for="floatingInput">ID</label>
</div>

<div class="form-floating">
  <input type="password" class="form-control" name="userPw" id="userPw" placeholder="Password">
  <label for="floatingPassword">Password</label>
</div>

<div class="container">
<div class="row">

<div class="form-check form-switch col">
  <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
  <label class="form-check-label" for="flexSwitchCheckChecked">로그인 상태 유지</label>
</div>

<div class="text-end col">
	<a>아이디 찾기</a>	|	
	<a>비밀번호 찾기</a>
</div>

</div>
</div>

 <button class="btn btn-primary">로그인</button>

</div>

</div>

</form>
</div>

</body>
</html>