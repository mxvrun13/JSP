package co.yedam.prj.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DownloadFile {

	private String path; // 파일이 실제 들어있는 물리적 공간 주소
	private String orgFileName; // 원본 파일명
	private String downFileName;

	public DownloadFile(String path, String orgFileName, String downFileName) {

		this.path = path;
		this.orgFileName = orgFileName;
		this.downFileName = downFileName;

	}
	
	public boolean isFileDown() {
		
		boolean bool = true;
		File file = new File(path+File.separator+downFileName);
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			FileOutputStream outFile = new FileOutputStream("d://temp/download//"+orgFileName); //d:/temp/파일명
			byte b[] = new byte[4096];
			int data = 0;
			while ((data = in.read(b, 0, b.length)) != -1) {
				outFile.write(b, 0, data);
			}
			outFile.flush();
			outFile.close();
			in.close();
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
		
	}

}
