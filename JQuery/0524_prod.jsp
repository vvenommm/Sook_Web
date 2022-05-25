<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 시 전송 데이터 가져오기 = lgu
	String lprod_gu = request.getParameter("lgu");
	
	//crud 처리 : SqlMapClient 객체 생성해야 처리 가능
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

	
	//sql문 실행 : mapper를 통해서 실행
	List<ProdVO> list = client.queryForList("prod.selectByLgu", lprod_gu);


	//처리 결과로 응답 데이터 생성 - json
	//list에 결과 값이 없을 때에도 있어서 경우를 2가지로 나눌 예정
	//nullPointerException은 x.get blahblah처럼 값을 가져오지 못 했는데 .을 찍고 무언가 하려고 할 때 발생
	
	if(list != null && list.size() >0){//!=null을 쓰지 않으면 nullPointerException 에러 발생
%>

		{
			"sw" : "ok",
			"data" : [

<% 	for(int i=0; i<list.size(); i++){ 
		ProdVO vo = list.get(i);
		if(i>0) out.print(",");
%>					

{
	"id" : "<%= vo.getProd_id() %>",
	"name" : "<%= vo.getProd_name() %>"
}

<% } %>

	]
}       
<% }else { %>
		
		{
			"sw" : "no"
		}
	
<%
	}
%>
