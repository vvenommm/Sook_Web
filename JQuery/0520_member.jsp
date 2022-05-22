
<%@page import="iBatisConfig.SqlMapClientFactory"%>
<%@page import="memberVO.MemberVO"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 시 데이터를 받아서
	//crud 처리
	//처리 결과로 응답 데이터 생성
%>

<%
//요청 시 데이터를  받아서
SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

List<MemberVO> list = client.queryForList("member.selectAll");

//crud 처리한다
//처리 결과로 응답 데이터를 생성 - jason Object 배열
%>

[
	<% 
		for(int i = 0; i < list.size(); i++){
			MemberVO vo = list.get(i);
			if(i > 0) out.print(",");
	%>
	
		{
			"id" : "<%= vo.getMem_id() %>",
			"name" : "<%= vo.getMem_name() %>",
			"hp" : "<%= vo.getMem_hp() %>",
			"email" : "<%= vo.getMem_email() %>",
			"addr1" : "<%= vo.getMem_add1() %> <%= vo.getMem_add2() %>",
			"bir" : "<%= vo.getMem_bir() %>"
		}	
	
	
	<% 
		}
	%>
]
