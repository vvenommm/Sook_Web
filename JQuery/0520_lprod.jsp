<%@page import="lprodVO.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="iBatisConfig.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	1. 요청 시 데이터를 받아서
	2. crud 처리 - SqlMqpClient 필요
	3. sql문 실행 - Mapping으로 sql문 실행 필요
	4. list 결과인 응답 데이터 생성 - JsonObject 배열
	
	* queryforlist는 결과값이 여러개일 때, 1개일 때는 queryforobject로

--%>
<% 

SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

List<LprodVO> list = client.queryForList("lprod.selectAll");

%>
[

	<%
		for(int i = 0; i < list.size(); i++){
			LprodVO vo = list.get(i);
			if(i>0) out.print(",");
	%>
	
		{
			"id" : "<%= vo.getLprod_id() %>",
			"gu" : "<%= vo.getLprod_gu() %>",
			"nm" : "<%= vo.getLprod_nm() %>"
		}
	
	<%		
		}
	%>
]
