package com.ko.home.board.impl;

import java.util.List;

public interface BoardDAO {

	//추상클래스크는 public abstract 생략해도 자동으로 되어있다
	
	//글목록 X
	public List<BoardDTO> getList()throws Exception;
	
	//글상세보기 글번호
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//글쓰기 글제목, 글작성자, 글내용
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//글수정 글번호, 글제목, 글내용
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//글삭제 글번호
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
}
