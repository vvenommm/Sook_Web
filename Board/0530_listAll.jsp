<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//서블릿에서 공유 데이터 가져오기
	
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("board");
%>
[
	<%
		for(int i = 0; i < list.size(); i++){
			BoardVO vo = list.get(i);
			if(i>0) out.print(",");
			
	%>
	
		{
			"num" : "<%= vo.getNum() %>",
			"subject" : "<%= vo.getSubject() %>",
			"password" : "<%= vo.getPassword() %>",
			"writer" : "<%= vo.getWriter() %>",
			"hit" : "<%= vo.getHit() %>",
			"mail" : "<%= vo.getMail() %>",
			"wdate" : "<%= vo.getWdate() %>",
			"content" : "<%= vo.getContent() %>"
		}
	
	
	<%		
		}
	%>

]
