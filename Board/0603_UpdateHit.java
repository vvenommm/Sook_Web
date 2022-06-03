package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/UpdateHit.do")
public class UpdateHit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		//service 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service 메소드 호출하기 -> 결과값 받기
		int resultNum = service.updateHit(num);
		
		//request에 결과값 저장하기
		request.setAttribute("resultNum", resultNum);
		
		//view 페이지로 이동
		request.getRequestDispatcher("view/resultNum.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
