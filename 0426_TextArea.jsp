<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area.jsp</title>

</head>
<body>
<h1>JSP : Java Server Page</h1>

<%
	//한글로 인코딩
	request.setCharacterEncoding("UTF-8");
	
	//전송 데이터 받기 - id, name
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	String area = request.getParameter("area");
%>



</body>
</html>
