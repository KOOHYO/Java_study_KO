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
	public void getListTest()throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList(mep);
//		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetail()throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(21L);
		boardDTO = noticeDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
	@Test
	public void getCount()throws Exception {
		long count = noticeDAO.getCount();
		assertEquals(104, count);
	}
	
	//@Test
	public void setAdd()throws Exception {
		
		for(int i=0; i<100; i++) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTitle("Test"+i);
			boardDTO.setContents("hi"+i);
			boardDTO.setWriter("GD"+i);
			
			int result = noticeDAO.setAdd(boardDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
			
		}
		
		System.out.println("포문 끝");
		
	}
	
	@Test
	public void setUpdate() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(2L);
		boardDTO.setTitle("Test");
		boardDTO.setContents("hi");
		
		int result = noticeDAO.setUpdate(boardDTO);
		assertEquals(0, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(41L);
		
		int result = noticeDAO.setDelete(boardDTO);
		assertEquals(0, boardDTO);
	}
	
}
