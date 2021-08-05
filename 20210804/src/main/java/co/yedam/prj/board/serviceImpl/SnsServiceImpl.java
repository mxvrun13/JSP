package co.yedam.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.prj.board.service.SnsMapper;
import co.yedam.prj.board.service.SnsService;
import co.yedam.prj.board.vo.CommentsVO;
import co.yedam.prj.board.vo.SnsVO;
import co.yedam.prj.common.DataSource;

public class SnsServiceImpl implements SnsService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession();  //MyBatis를 통해 DB에 연결
	private SnsMapper map = sqlSession.getMapper(SnsMapper.class);  // Mapper Interface를 사용

	@Override
	public List<SnsVO> snsSelectList() {
		return map.snsSelectList();
	}

	@Override
	public List<SnsVO> snsSelect(SnsVO vo) {
		return map.snsSelect(vo);
	}

	@Override
	public CommentsVO commentsSelect(CommentsVO vo) {
		return map.commentsSelect(vo);
	}

	@Override
	public int snsInsert(SnsVO vo) {
		return map.snsInsert(vo);
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		return map.commentsInsert(vo);
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		return map.snsUpdate(vo);
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		return map.commentsUpdate(vo);
	}

	@Override
	public int snsDelete(SnsVO vo) {
		return map.snsDelete(vo);
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		return map.commentsDelete(vo);
	}

}
