package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	//리스트 출력
	public List<BoardVO> selectAll() throws SQLException;
	
	
	//페이지별 리스트 출력
	public List<BoardVO> selectByPage(Map<String, Object> map) throws SQLException; //값으로 정수, 문자열 다 올 수 있기 때문에 Object로
	
	//전체 글 갯수 구하기
	public int searchCount(Map<String, Object> map) throws SQLException;
	
	
	//수정
	
	
	//삭제
	
	
	//글쓰기
	
	
	//조회수 증가
	
	
	//댓글 저장
	
	
	//댓글 수정
	
	
	//댓글 삭제
	
	
}
