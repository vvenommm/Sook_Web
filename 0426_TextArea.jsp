<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Text Area.jsp</title>

<style type="text/css">
h1{
	margin-left : 300px;

}
table {
	border-collapse: collapse;
	border : 3px solid green;
	width: 300px;
	margin-left : 300px;
	
}
td {
	border : 3px solid green;
	padding : 10px;
}
#info{
 	height: 50px; 
	overflow : auto;
}

</style>

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
	
	//userInfo 내용 속에는 Enter(\r\n)가 포함되어 있으나 출력 시 적용이 되지 않음
	//\r은 브라우저에서 기능을 하지 못 함 / \n은 브라우저에서 <br>로 바뀌어야 함
	
	String info = "";
	info = area.replaceAll("\r", "").replaceAll("\n", "<br>");
	
%>

<table border = "1">
	<tr>
	<td>이름</td>
	<td><%= name %></td>
	</tr>

	<tr>
	<td>메일</td>
	<td><%= mail %></td>
	</tr>
	<tr>
	<td>자기소개</td>
	<td id = "info"><%= info %></td>
	</tr>
</table>

</body>
</html>
