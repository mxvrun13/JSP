package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.vo.UITestVO;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UITestVO vo = new UITestVO();
		HttpSession session = request.getSession();
		vo.setId((String) session.getAttribute("id"));
		request.setAttribute("member", vo);
		session.invalidate();
		return "home/logout";
	}
}
