<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.PageVO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//서블릿에서 공유 데이터 가져오기
	
	List<BoardVO> pageList = (List<BoardVO>)request.getAttribute("pageList"); //boardList.java에 있는 request.setAttribute 키이름
	PageVO vo = (PageVO)request.getAttribute("PageVO");
	
	JsonObject obj = new JsonObject();
	obj.addProperty("totalPage", vo.getTotalPage());
	obj.addProperty("startPage", vo.getStartPage());
	obj.addProperty("endPage", vo.getEndPage());
	
	Gson gson = new Gson();
	JsonElement jPageList = gson.toJsonTree(pageList);
	
	obj.add("data", jPageList);
	
	out.print(obj);
	out.flush();

%>
