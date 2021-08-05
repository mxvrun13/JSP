package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.comm.Command;
import co.yedam.prj.comm.DownloadFile;

public class FileDownload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "d://temp";
		String orgFileName = request.getParameter("orgFile");
		String downFileName = request.getParameter("downFile");
		DownloadFile downLoadFile = new DownloadFile(path, orgFileName, downFileName);
		boolean b = downLoadFile.isFileDown();
		if (!b) {
			request.setAttribute("messege", "다운 완");
		} else {
			request.setAttribute("messege", "대실패!");
		}
		return "fileList.do";
	}

}
