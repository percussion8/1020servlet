<%@page import="java.util.ArrayList"%>
<%@page import="green.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="green.vo.Member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 등록</title>
</head>
<body>
<jsp:include page="/Header.jsp" />
<h1>회원 등록</h1>
<form action="add" method="post">
이름 : <input type="text" name="name"><br> 이메일 : <input
type="text" name="email"><br> 암호 : <input type="text"
name="password"><br>
<input type="submit" value="가입">
<input type="reset" value="취소">

</form>

<jsp:include page="/Tail.jsp" />
</body>
</html>