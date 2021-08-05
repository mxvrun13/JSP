package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session = request.getSession();
		String msg = session.getAttribute("name") + "님 정상 로그아웃 되었습니다.";
//		session.invalidate(); // 세션 완전히 제거
		session.removeAttribute("name"); // 유효 아이디는 존재
		session.removeAttribute("author");
		request.setAttribute("msg", msg);
		
		return "member/memberError";
	}

}
