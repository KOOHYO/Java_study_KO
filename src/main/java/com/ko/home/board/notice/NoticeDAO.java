package com.ko.home.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ko.home.bankmembers.BankMembersFileDTO;
import com.ko.home.board.impl.BoardDAO;
import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardFileDTO;
import com.ko.home.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.ko.home.board.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	@Override
	public Long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}

	@Override
	public int setAddFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setAddFile", boardFileDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

}
