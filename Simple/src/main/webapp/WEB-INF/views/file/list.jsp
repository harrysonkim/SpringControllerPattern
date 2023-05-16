<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border : 1px solid #ccc;
	border-collapse: collapse;
}
</style>

</head>
<body>


<table>
	<tr>
		<th>제목</th>
		<th>파일 원본이름</th>
	</tr>
<c:forEach var="file" items="${fileList}">
	<tr>
		<td><a href="./download?fileno=${file.fileno }">${file.title}</a></td>
		<td><a href="../upload/${file.stored_name }" download="${file.origin_name}">${file.origin_name}</a></td>
	</tr>
</c:forEach>
</table>


</body>
</html>