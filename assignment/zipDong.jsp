<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ZipVO> dongList = (List<ZipVO>)request.getAttribute("dongList");

	if(dongList != null && dongList.size() >0){
	
%>

[

	<%
		for(int i = 0; i<dongList.size(); i++){
			ZipVO vo = dongList.get(i);
			
			String dong = vo.getDong();
			if(i > 0) out.print(",");
			
	%>

		{
			"dong" : "<%= dong %>"
		}

	<%
		}
	%>

]
<%
	}else{	
%>

	{
		"sw" : "no"
	}

<%
	}
%>
