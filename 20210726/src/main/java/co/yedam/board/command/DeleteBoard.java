package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class DeleteBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 삭제
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();

		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n = dao.boardDelete(vo);
		String page="";
		if(n != 0) {
			page = "boardList.do";
		} else {
			page = "board/boardDeleteFail"; 
		}
		return page;
	}

}
