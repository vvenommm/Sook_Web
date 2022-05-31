package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
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
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return client.queryForList("board.selectAll");
	}
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) throws SQLException {
		return client.queryForList("board.selectByPage", map); //map을 넣어줘야 함!
	}
	
	@Override
	public int searchCount(Map<String, Object> map) throws SQLException {
		return (int)client.queryForObject("board.searchCount", map); //map 넣어줘야 dynamic Condition 사용 가능
	}

}
