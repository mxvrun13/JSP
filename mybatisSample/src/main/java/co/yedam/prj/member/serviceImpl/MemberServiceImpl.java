package co.yedam.prj.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.prj.common.DAO;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private SqlSession sqlSession = DAO.getInstance().openSession();
	
	@Override
	public List<MemberVO> memberSelectList() {
		return sqlSession.selectList("memberSelectList");
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return sqlSession.selectOne("memberSelect", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberInsert", vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return sqlSession.update("memberUpdate", vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return sqlSession.delete("memberDelete", vo);
	}

}
