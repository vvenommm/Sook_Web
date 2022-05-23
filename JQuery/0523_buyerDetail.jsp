<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//요청 시 데이터 받기 - id 값(sql 실행 시의 매개변수)
	String buyer_id = request.getParameter("id");
	
	//crud 처리 - SqlMapClient가 필요
	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	//mapper를 통해서 sql문 실행
	BuyerVO vo = (BuyerVO)client.queryForObject("buyer.selectDetails", buyer_id);

%>
{
	"id" : "<%= vo.getBuyer_id() %>",
	"lgu" : "<%= vo.getBuyer_lgu() %>",
	"nm" : "<%= vo.getBuyer_name() %>",
	"mail" : "<%= vo.getBuyer_mail() %>",
	"comtel" : "<%= vo.getBuyer_comtel() %>",
	"bank" : "<%= vo.getBuyer_bank() %>",
	"bankname" : "<%= vo.getBuyer_bankname() %>",
	"bankno" : "<%= vo.getBuyer_bankno() %>",
	"add1" : "<%= vo.getBuyer_add1() %>",
	"add2" : "<%= vo.getBuyer_add2() %>",
	"zip" : "<%= vo.getBuyer_zip() %>"
	
}
