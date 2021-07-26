package co.yedam.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.dao.DAO;
import co.yedam.board.service.BoardService;
import co.yedam.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	String sql;

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVO> boardSelectList() {
		// 게시판 목록 조회
		List<BoardVO> list = new ArrayList<BoardVO>();
		sql = "select * from board order by bid desc";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(); 
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
//				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// 한 건 조회
		sql = "select * from board where bid=?";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				
				hitUpdate(vo.getbId());		// 조회 수 증가 (정확한 id를 전달해줘야 함)
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	private void hitUpdate(int id) {
		// 조회 수 증가
		sql = "update board set bhit=bhit+1 where bid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// 등록
		sql = "insert into board(bid, btitle, bcontent, bwriter, bDate) values (b_seq.nextval,?,?,?,?)";
		int n = 0;
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			psmt.setDate(4, vo.getbDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// 제목, 내용 수정
		sql = "update board set btitle=?, bcontent=? where bid=?";
		int n = 0;
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// 삭제
		sql = "delete from board where bid=?";
		int n = 0;
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
}
