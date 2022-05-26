<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//view 페이지에서는 출력을 위한 로직만
//서블릿에서 request에 저장한 데이터를 가져온다.
String result = (String)request.getAttribute("resultSelById");

if(result == null){
	//중복 없는 id이므로 사용 가능
	
}else{
	//중복인 di이므로 다른 아이디 사용해야 함
	
}
%>
