package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

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
		request.setCharacterEncoding("utf-8");
		
		//요청 시 전송 데이터 받기 - page 받기(ajax로 넘겨받기)
		int page = Integer.parseInt(request.getParameter("page")); //" 1" 공백이 있을 경우 number format exception 발생. 숫자로만 들어왔는지 확인해야 함
		String stype = request.getParameter("stype"); //최초 실행 시 값 X
		String sword = request.getParameter("sword"); //최초 실행 시 값 X
		
		//service 객체 얻어오기
		IBoardService service = BoardServiceImpl.getInstance();
				
		//servlet 메소드 호출하기 - 결과 값 받기
		PageVO vo = service.pageInfo(page, stype, sword);
		
		//service의 메소드 - list
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		List<BoardVO> pageList = service.selectByPage(map); 
		
			
		//결과 값을 request에 저장
		request.setAttribute("pageList", pageList);
		request.setAttribute("PageVO", vo);
				
		//view페이지로 이동
		request.getRequestDispatcher("view/listPage.jsp").forward(request, response);
		
	}

}
