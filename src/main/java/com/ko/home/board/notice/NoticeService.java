package com.ko.home.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardService;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		System.out.println("Service : "+page);
		
		//이것도 바뀔 수 있으니 변수로!
		Long perPage=10L;
		//page			startRow			lastRow
		//1				1					5
		//2				6					10
		//3				11					15
		//4				31					40
		//5				41					50
		//6				51					60
		//7				61					60
		
		
		
		Long startRow=(page-1)*perPage+1;
		Long lastRow=page*perPage;
		
//		System.out.println("StartRow : "+startRow);
//		System.out.println("LastRow : "+lastRow);
		//Map은
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		
		//JSP에 페이지 번호를 출력 1 - ?
		//1. 글의 총 갯수
		//2. 글의 총 갯수를 이용해서 총 페이지수 구하기
		Long totalCount = noticeDAO.getCount();
		Long totalPage = totalCount%perPage;
		
		if(totalPage!=0) {
			totalPage = totalPage+1;
		}
		
		System.out.println("totalPage : "+totalPage);
		
		return noticeDAO.getList(map);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

}
