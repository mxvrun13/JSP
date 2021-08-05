package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.prj.common.Command;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 과정을 처리하는 곳
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(); // 세션 객체 호출
		System.out.println(session.getId()+"-------------------------");  // 세션 유효 아이디
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		String page = "";
		if(vo.getName() != null) {  // == vo.getName() != null
			session.setAttribute("name", vo.getName()); // 왼쪽 변수에 오른쪽 값을 담음
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			page = "member/loginSuccess";
		} else {
			String msg = "존재하지 않는 아이디 또는 비밀번호가 틀립니다.";
			request.setAttribute("msg", msg);
			page = "member/memberError";
		}
		return page;
	}

}
