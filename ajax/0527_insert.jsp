<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 저장된 공유 데이터 가져오기
	String id = (String)request.getAttribute("id");
	if(id != null){
		
%>

{	"sw" : "<%= id %>님 환영합니다."}

<% }else{ %>

{	"sw" : "가입실패"}

<%
	}
%>
