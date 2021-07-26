package co.yedam.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.command.BoardList;
import co.yedam.board.command.BoardSelect;
import co.yedam.board.command.Command;
import co.yedam.board.command.DeleteBoard;
import co.yedam.board.command.HomeCommand;
import co.yedam.board.command.InsertForm;
import co.yedam.board.command.UpdateBoard;
import co.yedam.board.command.UpdateForm;
import co.yedam.board.command.InsertBoard;


@WebServlet("*.do") // 매핑 방법 - init (*.do), servlet 매핑
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       

    public FrontController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		// 사용할 Command 정의 (생성 개념)
		map.put("/home.do", new HomeCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/boardSelect.do", new BoardSelect());
		map.put("/insertForm.do", new InsertForm());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/updateForm.do", new UpdateForm());
		map.put("/updateBoard.do", new UpdateBoard());
		map.put("/deleteBoard.do", new DeleteBoard());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 수행 부분을 분석하고, 실행하고, return 페이지를 돌려준다
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/"+viewPage+".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
