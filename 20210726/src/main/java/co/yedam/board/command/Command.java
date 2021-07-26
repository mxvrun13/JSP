package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 페이지 리턴
	public String execute(HttpServletRequest request, HttpServletResponse response);
	
}
