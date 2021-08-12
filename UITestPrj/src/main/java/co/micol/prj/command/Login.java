package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.service.UITestService;
import co.micol.prj.serviceImpl.UITestServiceImpl;
import co.micol.prj.vo.UITestVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UITestService dao = new UITestServiceImpl();
		UITestVO vo = new UITestVO();
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberSelect(vo);
		String page = "";
		
		if(vo.getId() != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("password", vo.getPassword());
			session.setAttribute("author", vo.getAuthor());
			request.setAttribute("member", vo);
			page = "home/loginForm";
		}
		return page;
	}

}
