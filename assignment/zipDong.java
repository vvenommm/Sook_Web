package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/zipDong.do")
public class zipDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 시 전송 데이터 받기
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("gugun");
		
		Map<String, String> voMap = new HashMap<String, String>();
		voMap.put("sido", sido);
		voMap.put("gugun", gugun);
		
		 
		 //service 객체 얻기
		 IMemberService service = MemberServiceImpl.getInstance();
		 
		 List<ZipVO> dongList = service.selectDongList(voMap);
		 
		 request.setAttribute("dongList", dongList);
		 
		 request.getRequestDispatcher("assignment/zipDong.jsp").forward(request, response);
	}

}
