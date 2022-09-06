package com.ko.home.BankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.BankBook.BankBookCommentDAO.";
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getList(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getList", bankBookCommentDTO);
	}
	
	public int setUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookCommentDTO);
	}
	
	public int setDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookCommentDTO);
	}
	
}
