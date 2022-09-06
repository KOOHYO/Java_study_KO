package com.ko.home.bankbook;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.BankBook.BankBookCommentDAO;
import com.ko.home.BankBook.BankBookCommentDTO;
import com.ko.home.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	//@Test
	public void setCommentAddTest()throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1659514911403L);
		bankBookCommentDTO.setWriter("GD");
		bankBookCommentDTO.setContents("반갑습니다");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void getCommentListTest()throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1659514911403L);
		commentPager.setPage(1L);
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		
		assertNotNull(ar);
	}

}
