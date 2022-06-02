<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 공유 데이터 가져오기
	int resultNum = (Integer)request.getAttribute("resultNum");
	if(resultNum > 0){
%>
		{
			"sw" : "성고오옹"
		}
<%
	}else{
%>
		{
			"sw" : "실패요오옹"
		}
<%		
	}
%>
