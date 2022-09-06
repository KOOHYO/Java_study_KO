package com.ko.home.bankbook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;
import com.ko.home.BankBook.BankBookCommentDAO;
import com.ko.home.BankBook.BankBookCommentDTO;

public class BankBookCommentDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setCommentAddTest()throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setNum(null);;
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		
		assertEquals(1, result);
	}

}
