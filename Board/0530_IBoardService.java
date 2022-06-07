package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {

	// 리스트 출력
	public List<BoardVO> selectAll();

	// 페이지별 리스트 출력
	public List<BoardVO> selectByPage(Map<String, Object> map); // 값으로 정수, 문자열 다 올 수 있기 때문에 Object로

	// 전체 페이지 구하기
	public int totalPage(String stype, String sword);

	// 전체 글 갯수 구하기
	public int searchCount(Map<String, Object> map);

	// 페이지별 정보 구하기
	public PageVO pageInfo(int page, String stype, String sword);

	// 글쓰기
	public int posting(BoardVO vo);

	// 삭제
	public int deletePost(int num);

	// 수정
	public int editPost(BoardVO vo);

	// 조회수 증가
	public int updateHit(int num);

	// 댓글 목록 출력
	public List<ReplyVO> replyList(int bonum);

	// 댓글 저장
	public int replySave(ReplyVO vo);

	// 댓글 수정

	// 댓글 삭제
	public int replyDelete(int renum);
}
