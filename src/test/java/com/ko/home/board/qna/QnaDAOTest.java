package com.ko.home.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void setReply()throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("Test");
		qnaDTO.setContents("안녕");
		qnaDTO.setWriter("GD");
		int reselt = qnaDAO.setReply(qnaDTO);
		assertEquals(0, qnaDTO);
	}

}
