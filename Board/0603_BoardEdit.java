package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/Edit.do")
public class BoardEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//요청 시 전송 데이터 받기
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setSubject(request.getParameter("subject"));
		vo.setWriter(request.getParameter("writer"));
		vo.setPassword(request.getParameter("password"));
		vo.setMail(request.getParameter("mail"));
		vo.setContent(request.getParameter("content"));
		
		//service 객체 생성
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service 메소드 호출 -> 결과 값 받기
		int resultNum = service.editPost(vo);
		
		//request에 결과 값 저장
		request.setAttribute("resultNum", resultNum);
		
		//view 페이지 이동
		request.getRequestDispatcher("view/resultNum.jsp").forward(request, response);
		
	}

}
