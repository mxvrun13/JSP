package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class BoardSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한 건 조회
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo = dao.boardSelect(vo);
		request.setAttribute("board", vo);
		return "board/boardSelect";
	}

}
