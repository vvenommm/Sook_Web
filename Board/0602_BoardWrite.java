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

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/Write.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//요청 시 전송 데이터 받기
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setSubject(subject);
		vo.setWriter(writer);
		vo.setMail(mail);
		vo.setPassword(password);
		vo.setContent(content);
		vo.setWip(request.getRemoteAddr());
		
		//서비스 객체 생성
		IBoardService service = BoardServiceImpl.getInstance();
		
		//서비스 메소드 호출 후 결과값 받기
		int resultNum = service.posting(vo);
		
		//결과 값을 request에 저장
		request.setAttribute("resultNum", resultNum);
		
		//view페이지로 이동
		request.getRequestDispatcher("view/resultNum.jsp").forward(request, response);
		
	}

}
