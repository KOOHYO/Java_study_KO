package com.ko.home.board.notice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetail() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		noticeDAO.getDetail(boardDTO);
		
	}
	
	@Test
	public void setAdd()throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("Test");
		boardDTO.setContents("hi");
		boardDTO.setWriter("GD");
		
		int result = noticeDAO.setAdd(boardDTO);
		assertEquals(0, result);
	}
	
}
