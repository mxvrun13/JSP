package co.yedam.servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public First() {
        super();
    }
    
    // 요청 방식 - get, post
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append("나의 이름을 찍어보자"); // 응답 객체에 write - append 출력
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
