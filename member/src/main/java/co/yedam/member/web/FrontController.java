package co.yedam.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.member.command.Command;
import co.yedam.member.command.MainCommand;
import co.yedam.member.command.MemberInsert;
import co.yedam.member.command.MemberInsertForm;
import co.yedam.member.command.MemberListCommand;
import co.yedam.member.command.MemberSearchCommand;
import co.yedam.member.command.MemberSearchForm;


// @WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		// command 객체를 여기 등록
		map.put("/main.do", new MainCommand()); //홈
		map.put("/memberList.do", new MemberListCommand()); //회원 목록
		map.put("/memberSearch.do", new MemberSearchCommand()); //회원 검색
		map.put("/memberSearchForm.do", new MemberSearchForm()); //회원 검색 폼
		map.put("/memberInsert.do", new MemberInsert()); //회원가입
		map.put("/memberInsertForm.do", new MemberInsertForm()); //회원가입 폼
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// command 요청 분석 및 처리, view Page 선택하는 곳
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		// 실제 요청을 찾아 분석
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length()); // uri-context=요청페이지 ex)main.do
		
		Command command = map.get(path); // == Command command = new MainCommand();
		String viewPage = command.execute(request, response); // 실행될 결과를 보여줄 페이지
		
		if (!viewPage.endsWith(".do")) { // 보여줄 페이지 선택
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
