package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient client;
	private static BoardDaoImpl dao;

	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	//모든 글
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return client.queryForList("board.selectAll");
	}
	
	//페이지 정돈
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) throws SQLException {
		return client.queryForList("board.selectByPage", map); //map을 넣어줘야 함!
	}
	
	//글 조건에 맞게 찾기
	@Override
	public int searchCount(Map<String, Object> map) throws SQLException {
		return (int)client.queryForObject("board.selectCount", map); //map 넣어줘야 dynamic Condition 사용 가능
	}
	
	//글작성
	@Override
	public int posting(BoardVO vo) throws SQLException {
		return (int)client.insert("board.posting", vo);
	}
	
	//글삭제
	@Override
	public int deletePost(int num) throws SQLException {
		return (int)client.delete("board.deletePost", num);
	}
	
	//글수정
	@Override
	public int editPost(BoardVO vo) throws SQLException {
		return client.update("board.editPost", vo);
	}
	
	//조회수 증가
	@Override
	public int updateHit(int num) throws SQLException {
		return client.update("board.updateHit", num);
	}
	
	//댓글 저장(작성)
	@Override
	public int replySave(ReplyVO vo) throws SQLException {
		return (int) client.insert("reply.replySave", vo);
	}

}
