package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class ListAll
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet - 전체리스트 출력
		
		
		//servlet 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//servlet 메소드 호출하기 - 결과 값 받기
		List<BoardVO> boardListAll = service.selectAll();
		
		//결과 값을 request에 저장
		request.setAttribute("boardListAll", boardListAll);
		
		//view페이지로 이동
		request.getRequestDispatcher("view/listAll.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doPost - 페이지별 리스트 출력
		
		
		
		
	}

}
