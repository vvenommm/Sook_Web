<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Option.jsp</title>
<style type="text/css">
h1{
	color : #6495ED;
	text-align: center;
}
table{
	border : 5px solid #BECDFF;
	margin : 50px;
	width: 500px;
	height: 150px;
	text-align: center;
	color : #6478FF;
}
tr{
	border: 2px solid #C8D7FF;
	background-color: #F4FFFF;
}
td{
	text-align: center;
	color : #5A5AFF;
	
}
</style>

</head>
<body>
<h1> JSP : Java Server Page</h1>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String add = request.getParameter("add");
	
	String flowers[] = request.getParameterValues("flower");
	
	String flo = "";
	for(String flower : flowers){
		flo += flower + "<br>";
	}
%>

<table border="1">
	<tr>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>좋아하는 꽃들</th>
	</tr>
	
	<tr>
		<td><%= name %></td>
		<td><%= tel %></td>
		<td><%= add %></td>
		<td><%= flo %></td>
	</tr>

</table>



</body>
</html>
