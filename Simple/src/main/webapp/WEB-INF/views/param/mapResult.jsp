<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>맵을이용한 파라미터 처리 폼 결과</h1>
<hr>

<h3>AddAttribute</h3>
data1 : ${m.data1 }<br>
data2 : ${m.data2 }<br>
data3 : ${m.data3 }<br>
data4 : ${m.data4 }<br>

username : ${m.username }<br>
userage : ${m.userage }<br>

<hr>

<h3>AddAllAttributes</h3>
data1 : ${data1 }<br>
data2 : ${data2 }<br>
data3 : ${data3 }<br>
data4 : ${data4 }<br>

username : ${username }<br>
userage : ${userage }<br>

<a href="./map"><button type="button">폼으로</button></a>
</body>
</html>