package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.board.service.SnsService;
import co.yedam.prj.board.serviceImpl.SnsServiceImpl;
import co.yedam.prj.board.vo.SnsVO;
import co.yedam.prj.common.Command;

public class SnsSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SnsService dao = new SnsServiceImpl();
		SnsVO vo = new SnsVO();
		vo.setSNo(1);
		request.setAttribute("sns", dao.snsSelect(vo));
		return "board/snsSelect";
	}

}
