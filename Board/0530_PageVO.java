package kr.or.ddit.board.vo;

public class PageVO {
	
	private int start; //현재 페이지 내 시작 글번호. 예) 2페이지에서 5번 글(시작)
	private int end; //현재 페이지 내 끝 글번호 예) 2페이지에서 8번 글(끝)
	
	private int startPage; //브라우저 내 시작 페이지
	private int endPage; //브라우저 내 끝 페이지
	private int totalPage; //db에 저장된 총 페이지?
	private int count;//db에 저장된 전체 글 개수 - 검색 키워드에 따라 달라짐
	
	//다른 페이지에서도 사용하기 때문에 static 작성
	private static int perList = 4; //한 페이지에 보이는 글 개수
	private static int perPage = 3; //현 페이지 위치
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static int getPerList() {
		return perList;
	}
	public static void setPerList(int perList) {
		PageVO.perList = perList;
	}
	public static int getPerPage() {
		return perPage;
	}
	public static void setPerPage(int perPage) {
		PageVO.perPage = perPage;
	}
	
}
