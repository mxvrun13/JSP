package co.yedam.board.service;

import java.util.List;

import co.yedam.board.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> boardSelectList();	// 전체 조회
	BoardVO boardSelect(BoardVO vo);	// 한 건 조회
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);

}
