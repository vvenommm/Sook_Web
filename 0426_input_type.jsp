<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input_type.jsp</title>
<style>
h1{
	color : #FF5A5A;
}
p {
	width: 200px;
	height : 50px;
	border : 1px dotted #D5C2EE;
	font-size:  : 1.5em;
	float : left;
	margin: 20px;
}
#p1{
	width : 80%;
}
br{
	clear : both;
}
p .pp{
	background-color: #dda0dd;
}


</style>

</head>
<body>
<h1>JSP : Java Server Page</h1>
<p id = "p1">request 객체를 이용하여 클라이언트의 전송 데이터를 받아서 처리한다.</p>

<%
	//한글 인코딩 처리를 먼저 하기
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	String userPass = request.getParameter("pass");
	String userGender = request.getParameter("gender");
	String foods[] = request.getParameterValues("like");
	
	String str = "";
	for(String f : foods){
		str += f + "&nbsp;"; //공백을 넣기 위해 써줘야 함
	}
%>

<br>

<div>
	<p class = "pp">아이디</p>
	<p class = "pp"><%= userId %></p>
	
	<br>
	
	<p class = "pp">이름</p>
	<p class = "pp"><%= userName %></p>
	
	<br>
	
	<p class = "pp">비밀번호</p>
	<p class = "pp"><%= userPass %></p>
	
	<br>
	
	<p class = "pp">성별</p>
	<p class = "pp"><%= userGender %></p>

	<br>

	<p class = "pp">좋아하는 음식</pp>
<%-- 	<p class = "pp"><%= foods %></p> --%>
	<p class = "pp"><%= str %></p> <%-- 좋아하는 음식 배열에 있는 값 출력 --%>
</div>

</body>
</html>
