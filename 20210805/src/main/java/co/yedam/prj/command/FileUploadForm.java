package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.comm.Command;

public class FileUploadForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "file/fileUploadForm";
	}

}
