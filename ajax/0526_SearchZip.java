package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchZip
 */
@WebServlet("/SearchZip.do")
public class SearchZip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchZip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 시 전송 데이터 받기 - dong
		String dong = request.getParameter("dong");
		
		//service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		
		//service 메소드 호출 - 결과값 받기
		List<ZipVO> list = service.selectByDong(dong);
		
		//결과값 출력 - view 페이지로 이동
		//resquest 객체에 결과 값을 저장
		request.setAttribute("dongList", list);
		request.getRequestDispatcher("0525/dong.jsp").forward(request, response);
		
	}

}
