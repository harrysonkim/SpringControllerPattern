<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인페이지</h1>

로그인 상태 : ${sessionScope.login}<br>
로그인 상태 : ${login}<br>

<c:choose>
	<c:when test="${sessionScope.login eq null}">
		<a href="./login"><button>로그인</button></a>
		<a href="./join"><button>회원가입</button></a>
	</c:when>
	<c:when test="${sessionScope.login}">
		<a href="./mypage"><button>마이페이지</button></a>
		<a href="./logout"><button>로그아웃</button></a>
	</c:when>
	<c:otherwise>
		정상적인 접근이 아닙니다
	</c:otherwise>

</c:choose>

</body>
</html>