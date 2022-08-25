package com.ko.home.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	//@Test
	public void setAdd()throws Exception{
		for(int i=0; i<100; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("Test"+i);
			qnaDTO.setContents("hi"+i);
			qnaDTO.setWriter("Koo"+i);
			
			int result = qnaDAO.setAdd(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(500);	
			}
		}
		System.out.println("포문 끝!");
	}

}
