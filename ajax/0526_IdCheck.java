package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 시 전송 데이터 받기
		String userId = request.getParameter("id");
		
		//service 객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		//sercice 메소드 호출 하기 : 결과값 받기
		String result = service.selectById(userId);
		
		//결과값 출력
		//view를 통해 페이지 이동하는 방법
		// 1) redirect : 응답을 함으로써 request와 response는 사라짐. 그래서 새로운 request와 response로 재요청을 함
		// 2) forward : view로 페이지 이동이라 client는 이동했는지 모름. request, response를 공유하기 때문에 이동한 view에서도 사용(공유) 가능. 응답을 한 번 하면 request와 response는 역할이 끝나고, client는 다시 재요청을 하게 됨. 그래서 매개변수로 공유시킴
		//결과값이 사라지냐 계속 사용할 수 있느냐, forward는 서버 내에서 이동, redirect는 서버 밖으로 나갔다가 다시 들어옴. 수행 결과를 공유해서 사용할거면 forward 방법으로.
		
		request.setAttribute("resultSelById", result); //map처럼 ("키 이름", 키 값)으로 작성
		
		request.getRequestDispatcher("0525/idCheck.jsp").forward(request, response);
	}

}
