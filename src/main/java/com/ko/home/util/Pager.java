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
	private Long perPage;
	private Long startRow;
	private Long lastRow;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	//1. Mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*perPage+1;
	}
	
	//2. JSP에서 사용할 값 계산
	public void getNum()throws Exception{
		
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
		if(this.page==null) {
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
	
}
