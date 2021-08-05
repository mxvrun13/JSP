package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();

		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		int n = dao.boardUpdate(vo);
		String page="";
		if(n != 0) {
			page = "boardSelect.do";
		} else {
			page = "board/boardUpdateFail"; 
		}
		return page;
	}
}
