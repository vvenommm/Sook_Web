package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	//리스트 출력
	public List<BoardVO> selectAll() throws SQLException;
	
	//페이지별 리스트 출력
	public List<BoardVO> selectByPage(Map<String, Object> map) throws SQLException; //값으로 정수, 문자열 다 올 수 있기 때문에 Object로
	
	//전체 글 갯수 구하기
	public int searchCount(Map<String, Object> map) throws SQLException;
	
	//글쓰기
	public int posting(BoardVO vo) throws SQLException;
	
	//삭제
	public int deletePost(int num) throws SQLException;
	
	//수정
	public int editPost(BoardVO vo) throws SQLException;
	
	//조회수 증가
	public int updateHit(int num) throws SQLException;
	
	//댓글 목록 출력
	public List<ReplyVO> replyList(int bonum) throws SQLException;
	
	//댓글 저장
	public int replySave(ReplyVO vo) throws SQLException;
	
	//댓글 수정
	
	
	//댓글 삭제
	public int replyDelete(int renum) throws SQLException;
	
}
