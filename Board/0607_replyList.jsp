<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서 공유 데이터 가져오기
	List<ReplyVO> replyList = (List<ReplyVO>)request.getAttribute("replyList");

	Gson gson = new Gson();
	String result = gson.toJson(replyList);
	
	out.print(result);
	out.flush();
%>
