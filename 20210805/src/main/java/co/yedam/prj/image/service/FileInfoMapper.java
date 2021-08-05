package co.yedam.prj.image.service;

import java.util.List;

import co.yedam.prj.image.vo.FileInformationVO;

public interface FileInfoMapper {
	
	List<FileInformationVO> fileSelectList();
	FileInformationVO fileSelect(int key);
	int fileInsert(FileInformationVO vo);
	int fileUpdate(FileInformationVO vo);
	int fileDelete(int key);
	
}
