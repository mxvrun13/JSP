package co.micol.prj.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.comm.DataSource;
import co.micol.prj.service.UITestService;
import co.micol.prj.vo.UITestVO;

public class UITestServiceImpl implements UITestService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	UITestService map = sqlSession.getMapper(UITestService.class);
	
	@Override
	public UITestVO memberSelect(UITestVO vo) {
		return map.memberSelect(vo);
	}

}
