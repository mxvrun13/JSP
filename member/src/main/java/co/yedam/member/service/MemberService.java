package co.yedam.member.service;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); // 회원 전체 목록
	MemberVO memberSelect(MemberVO vo); // 한 건 조회
	int memberInsert(MemberVO vo); // 회원 추가
	int memberUpdate(MemberVO vo); // 회원 수정
	int memberDelete(MemberVO vo); // 회원 삭제
}
