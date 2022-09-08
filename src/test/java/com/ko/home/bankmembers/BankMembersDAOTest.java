package com.ko.home.bankmembers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ko.home.MyAbstractTest;

public class BankMembersDAOTest extends MyAbstractTest{

	//객체 생성 후 주입시켜야 옴!
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void getMyPage()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("koo");
		
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		
		assertNotNull(bankMembersDTO);
	}
	
	@Test
	public void getLoginTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("koo");
		bankMembersDTO.setPassWord("4567");
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		assertNotNull(bankMembersDTO);
	}
	
	//@Test 어노테이션 꼭 줘야함!
	@Test
	public void setJoinTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("koo");
		bankMembersDTO.setPassWord("4567");
		bankMembersDTO.setName("효경");
		bankMembersDTO.setEmail("koo@naver.com");
		bankMembersDTO.setPhone("010-5555-5255");
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		assertEquals(0, result);
	}
	
	@Test
	public void getSearchByID()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("GD");
		bankMembersDTO.setPassWord("123");
		bankMembersDTO.setName("지디");
		bankMembersDTO.setEmail("GD@naver.com");
		bankMembersDTO.setPhone("010-2222-2222");

		ArrayList<BankMembersDTO> bankMembersDTOs = new ArrayList<BankMembersDTO>();
		bankMembersDTOs.add(0, bankMembersDTO);

		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID(bankMembersDTOs.toString());
		assertEquals(bankMembersDTOs, ar);
	}
	
}
