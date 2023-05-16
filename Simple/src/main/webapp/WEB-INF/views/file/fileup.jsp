<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
<form action="./fileup" method="post" enctype="multipart/form-data">

<label for="title">제목</label>
<input type="text" name="title" id="title"><br>

<label for="file">첨부파일</label>
<input type="file" name="file" id="file"><br><br>

<label for="data1">테스트</label>
<input type="file" name="data" id="data1"><br>
<label for="data2">테스트</label>
<input type="file" name="data" id="data2"><br>
<label for="data3">테스트</label>
<input type="file" name="data" id="data3"><br>

<label for="dataMul">테스트</label>
<input type="file" name="dataMul" id="data3=Mul" multiple="multiple"><br>

<button>전송</button>

</form>
</body>
</html>