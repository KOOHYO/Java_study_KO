package com.ko.home.bankmembers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankMembersDAO {
	
	//멤버변수 SqlSession 선언 후 주입
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.bankmembers.BankMembersDAO.";
	
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", bankMembersFileDTO);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMyPage", bankMembersDTO);
	}
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	//아이디검색
	public List<BankMembersDTO> getSearchByID(String userName)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getSearchByID", userName);
	}
	
}
