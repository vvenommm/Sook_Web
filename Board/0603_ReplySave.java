package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

@WebServlet("/ReplySave.do")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//데이터 받아오기
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = (String)request.getParameter("name");
		String cont = (String)request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		// service 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();

		// service 메소드 호출하기 -> 결과값 받기
		int resultNum = service.replySave(vo);
		System.out.println(resultNum);

		// request에 결과값 저장하기
		request.setAttribute("resultNum", resultNum);

		// view 페이지로 이동
		request.getRequestDispatcher("view/resultNum.jsp").forward(request, response);
	}

}
