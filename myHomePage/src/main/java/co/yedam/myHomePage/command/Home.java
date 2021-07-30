package co.yedam.myHomePage.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.myHomePage.common.Command;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "tiles:home/home"; // tiles로 보내기
	}

}
