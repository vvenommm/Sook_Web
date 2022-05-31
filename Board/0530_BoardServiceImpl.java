package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;
	private static IBoardService service;
	int count;
	
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
		int count = 0;
		
		try {
			count = dao.searchCount(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int totalPage(String stype, String sword) {
		
		//전체 글 개수 구하기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		
		count = this.searchCount(map);
		System.out.println("전체 글 개수 : " + count);
		
		//전체 페이지 수 구하기
		int totalPage = (int)Math.ceil((double)count / PageVO.getPerList());
		System.out.println("전체 페이지 수 : " + totalPage);
		return totalPage;
	}
	
	@Override
	public PageVO pageInfo(int page, String stype, String sword) {
		
		//전체 글 개수 구하기
		int totalPage = this.totalPage(stype, sword);
		
		//map - stype, sword : map에 추가(초기 실행 시에는 값 X)
		//start, end
		//page 1 -> 1(start), 4(end)
		//page 2 -> 5, 8
		int start = (page-1) * PageVO.getPerList() + 1;
		int end = start + PageVO.getPerList() - 1;
		
		if(end > count) {
			end = count;
		}
		
		//시작페이지 끝페이지
		int perPage = PageVO.getPerPage();
		int startPage = ((page-1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		PageVO vo = new PageVO();
		vo.setStart(start);
		vo.setEnd(end);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setTotalPage(totalPage);
		
		return vo;
	}

}
