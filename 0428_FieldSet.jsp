<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FieldSet.jsp</title>
<style type="text/css">
body{
	padding : 50px;
}
h1{
	color : #6495ED;
	text-align: center;
}
table{
	border : 5px solid #BECDFF;
	text-align: center;
}
#t1{
	width: 250px;
}
#t2 .th{
 	width: 300px;
}
tr{
	border: 2px solid #C8D7FF;
	background-color: #F4FFFF;
}
#h{
	width: 50px;
}
#a{
	width: 400px;
}
#info {
	text-overflow: scroll;
	
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
	String start1 = request.getParameter("start1");
	String end1 = request.getParameter("end1");
	String area1 = request.getParameter("area1");
	
	String start2 = request.getParameter("start2");
	String end2 = request.getParameter("end2");
	String area2 = request.getParameter("area2");
	
	String start3 = request.getParameter("start3");
	String end3 = request.getParameter("end3");
	String area3 = request.getParameter("area3");
	
	String info1 = "";
	info1 = area1.replaceAll("\r", "").replaceAll("\n", "<br>");
	
	String info2 = "";
	info2 = area2.replaceAll("\r", "").replaceAll("\n", "<br>");

	String info3 = "";
	info3 = area3.replaceAll("\r", "").replaceAll("\n", "<br>");
	
%>

<table id = "t1" border = "1">
	<caption>인적사항</caption>
	<tr>
		<th>이름</th>	
		<td><%= name %></td>	
	</tr>

	<tr>
		<th>주소</th>	
		<td><%= add %></td>	
	</tr>

	<tr>
		<th>전화번호</th>	
		<td><%= tel %></td>	
	</tr>
</table>

<br><br>

<table id = "t2"  border = "1">
	<caption>경력사항</caption>
	<tr>
		<th id = "h" rowspan = "3">기간</th>
		<th class = "a">경력1</th>
		<th class = "a">경력2</th>
		<th class = "a">경력3</th>
	</tr>
	<tr>
		<td><%= start1 %><br>~<br><%= end1 %></td>	 
		<td><%= start2 %><br>~<br><%= end2 %></td>	
		<td><%= start3 %><br>~<br><%= end3 %></td>	
	</tr>

	<tr>
		<td class = "info"><%= info1 %></td>	
		<td class = "info"><%= info2 %></td>	
		<td class = "info"><%= info3 %></td>	
	</tr>
</table>

</body>
</html>
