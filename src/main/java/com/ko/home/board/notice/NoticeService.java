package com.ko.home.board.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardService;

@Service
public class NoticeService implements BoardService{

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
