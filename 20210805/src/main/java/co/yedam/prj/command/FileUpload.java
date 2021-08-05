package co.yedam.prj.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.prj.comm.Command;
import co.yedam.prj.image.service.FileInfoService;
import co.yedam.prj.image.vo.FileInformationVO;

public class FileUpload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		FileInfoService dao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();
		int maxFileSize = 1024 * 1024 * 100;
		System.out.println(request.getParameter("subject"));
		try {
			// 보낼 때 multipart로 보냈기 때문에 리퀘스트도 이렇게 받는듯...
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy());
			String upfileName = part.getFilesystemName("fileName");
			String orgFileName = part.getOriginalFileName("fileName");

			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgFileName);
			vo.setDownFile(upfileName);

			int n = dao.fileInsert(vo);
			if (n != 0) {
				request.setAttribute("messege", vo.getFileName() + " 파일 업로드 완");
			} else {
				request.setAttribute("messege", orgFileName + "파일 업로드 실패");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file/fileUploadResult";
	}

}
