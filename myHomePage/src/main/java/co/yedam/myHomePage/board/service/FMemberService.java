package co.yedam.myHomePage.board.service;

import co.yedam.myHomePage.fmember.vo.FMemberVO;

public interface FMemberService {

	FMemberVO login(FMemberVO vo);

	int memberInsert(FMemberVO vo);

	int memberDelete(FMemberVO vo);
}
