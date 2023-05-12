<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<hr>
<form action="/login/join" method="post">

	ID : <input type="text" name="id" id="id"><br>
	PW : <input type="text" name="pw" id="pw"><br>
	E-mail : <input type="text" name="email" id="email"><br>
	Phone : <input type="text" name="phone" id="phone"><br>
	
	<button>가입완료</button>

</form>

</body>
</html>