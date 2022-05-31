package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardListAll = null;
		
		try {
			boardListAll = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardListAll;
	}
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		List<BoardVO> boardPage = null;
		
		try {
			boardPage = dao.selectByPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardPage;
	}
	
	@Override
	public int searchCount(Map<String, Object> map) {
		int cnt = 0;
		
		try {
			cnt = dao.searchCount(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
