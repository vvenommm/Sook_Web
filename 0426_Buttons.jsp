<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buttons.jsp</title>
</head>
<body>
<h1>JSP : Java Server Page</h1>

<%
	//한글로 인코딩
	request.setCharacterEncoding("UTF-8");
	
	//전송 데이터 받기 - id, name
	String id = request.getParameter("id");
	String name = request.getParameter("name");
%>

<p>아이디 : <%= id %></p>
<p>이름 : <%= name %></p>

</body>
</html>
