package com.ko.home.util;

public class Pager {

	/*멤버변수
	 * 
	 * 파라미터를 담을 변수
	 * JSP에서 꺼내서 사용할 변수
	 * Mapper에서 꺼내서 사용할 변수(스타트로우,라스트로우)
	 * perPage  : 한페이지에 출력할 글의 갯수
	 * perBlock : 한페이지에 출력할 번호의 갯수
	 * */
	
	private Long page;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	
	//이전블럭의 유무-이전블럭이 있으면 true, 없으면 false
	private boolean pre;
	//다음블럭의 유무-다음블럭이 있으면 true, 없으면 false
	private boolean next;
	
	//검색 컬럼의 종류
	private String kind;
	//검색어
	private String search;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}

	//1. Mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*perPage+1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	//2. JSP에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		//2. totalCount로 totalPage 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//2-1 totalPage 보다 page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		
		//3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//4. page로 curBlock 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6. curBlock이 마지막 Block일때(totalBlock과 같을 때)
		//	 lastNum을 totalPage수만큼 나오게끔 한다
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
		//7. 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre=true;
		}
		
		if(curBlock<totalBlock) {
			next=true;
		}
		
	}
	
	//null이 들어 올 상황이 있을 수 있으니 개터에 셋팅해야한다!
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		if(this.perBlock==null) {
			this.perBlock=5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
