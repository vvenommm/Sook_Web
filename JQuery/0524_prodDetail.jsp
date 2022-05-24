<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String prod_id = request.getParameter("prodId");

	SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
	
	ProdVO vo = (ProdVO) client.queryForObject("prod.selectByProdId", prod_id);
%>

{
	"id" : "<%= vo.getProd_id() %>",
	"lgu" : "<%= vo.getProd_lgu() %>",
	"name" : "<%= vo.getProd_name() %>",
	"cost" : "<%= vo.getProd_cost() %>",
	"buyer" : "<%= vo.getProd_buyer() %>",
	"color" : "<%= vo.getProd_color() %>",
	"detail" : "<%= vo.getProd_detail() %>",
	"delivery" : "<%= vo.getProd_delivery() %>",
	"outline" : "<%= vo.getProd_outline() %>",
	"sale" : "<%= vo.getProd_sale() %>",
	"price" : "<%= vo.getProd_price() %>",
	"size" : "<%= vo.getProd_size() %>",
	"unit" : "<%= vo.getProd_unit() %>"
}
