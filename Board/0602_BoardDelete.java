package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/Delete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 시 전송 데이터 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		//service 객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//service 메소드 호출 - 결과값 받기
		int resultNum = service.deletePost(num);
		
		//request에 결과값 저장
		request.setAttribute("resultNum", resultNum);
		
		//view 페이지로 이동
		request.getRequestDispatcher("view/resultNum.jsp").forward(request, response); //resultNum.jsp는 수정, 삭제 시 성공 실패여부를 보기 위해 둘 다 사용될 파일
	}

}
