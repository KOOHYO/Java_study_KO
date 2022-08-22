package com.ko.home.bankAccount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.bankmembers.BankMembersDAO.";
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", bankAccountDTO);
	}
}
