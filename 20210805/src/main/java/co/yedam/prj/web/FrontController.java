package co.yedam.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.comm.Command;
import co.yedam.prj.command.CyperText;
import co.yedam.prj.command.FileDownload;
import co.yedam.prj.command.FileList;
import co.yedam.prj.command.FileUpload;
import co.yedam.prj.command.FileUploadForm;
import co.yedam.prj.command.Home;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       

    public FrontController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/fileUploadForm.do", new FileUploadForm());
		map.put("/fileUpload.do", new FileUpload());
		map.put("/fileList.do", new FileList());
		map.put("/fileDownload.do", new FileDownload());
		map.put("/cyperText.do", new CyperText());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
