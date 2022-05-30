<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//서블릿에서 공유 데이터 가져오기
	
	List<BoardVO> boardListAll = (List<BoardVO>)request.getAttribute("boardListAll");

	//gson 객체 생성
	Gson gson = new Gson();
	
	//Object를 매개변수로 하는 toJson메소드를 사용 -> 리턴=String
	String result = gson.toJson(boardListAll);
	
	//아래 주석처리한 것들이 자동으로 만들어짐!
	//key이름은 VO에 있는 필드명으로 생성
	out.print(result);
	out.flush();
	
	
%>



<%--
gson 방법 사용을 위해 주석처리
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
 --%>
 
 
 
