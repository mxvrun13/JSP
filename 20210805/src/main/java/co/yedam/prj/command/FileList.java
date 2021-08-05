package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.comm.Command;
import co.yedam.prj.image.service.FileInfoService;

public class FileList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FileInfoService dao = new FileInfoService();
		request.setAttribute("files", dao.fileSelectList());
		return "file/fileList";
	}

}
