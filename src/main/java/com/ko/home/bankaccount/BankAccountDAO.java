package com.ko.home.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ko.home.bankmembers.BankMembersDTO;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.bankaccount.BankAccountDAO.";
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", bankAccountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
		      
	   }
	
}
