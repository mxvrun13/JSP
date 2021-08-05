package co.yedam.prj.command;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.board.service.SnsService;
import co.yedam.prj.board.serviceImpl.SnsServiceImpl;
//import co.yedam.prj.board.vo.SnsVO;
import co.yedam.prj.common.Command;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SnsService dao = new SnsServiceImpl();
//		List<SnsVO> list = new ArrayList<SnsVO>();
//		list = dao.snsSelectList();
		request.setAttribute("list", dao.snsSelectList());
		return "board/snsList";
	}

}
