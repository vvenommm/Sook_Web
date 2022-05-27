package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pass = request.getParameter("mem_pass");
		String mem_bir = request.getParameter("mem_bir");
		String mem_email = request.getParameter("mem_email");
		String mem_hp = request.getParameter("mem_hp");
		String mem_add1 = request.getParameter("mem_add1");
		String mem_add2 = request.getParameter("mem_add2");
		String mem_zip = request.getParameter("mem_zip");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(mem_id);
		vo.setMem_pass(mem_pass);
		vo.setMem_name(mem_name);
		vo.setMem_bir(mem_bir);
		vo.setMem_email(mem_email);
		vo.setMem_hp(mem_hp);
		vo.setMem_add1(mem_add1);
		vo.setMem_add2(mem_add2);
		vo.setMem_zip(mem_zip);
		
		
		//service 객체를 service 클래스의 get으로 생성(얻기)
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service 메소드 호출 - 결과값 받기
		String id = service.insertMember(vo);
		
		//결과값을 저장 request에 저장
		request.setAttribute("id", id);
		
		//view 페이지로 이동
		request.getRequestDispatcher("0525/insert.jsp").forward(request, response);
		
		
		
	}
	
}
