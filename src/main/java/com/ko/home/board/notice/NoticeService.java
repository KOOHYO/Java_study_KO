package com.ko.home.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.board.impl.BoardService;
import com.ko.home.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
//		System.out.println("Service : "+page);
//		
//		//이것도 바뀔 수 있으니 변수로!
//		Long perPage=10L;
//		//page			startRow			lastRow
//		//1				1					5
//		//2				6					10
//		//3				11					15
//		//4				31					40
//		//5				41					50
//		//6				51					60
//		//7				61					60
//		
//		
//		
//		Long startRow=(page-1)*perPage+1;
//		Long lastRow=page*perPage;
//		
////		System.out.println("StartRow : "+startRow);
////		System.out.println("LastRow : "+lastRow);
//		//Map은
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		//JSP에 페이지 번호를 출력 1 - ?
//		//1. 글의 총 갯수
//		Long totalCount = noticeDAO.getCount();
//		//2. 글의 총 갯수를 이용해서 총 페이지수 구하기
//		Long totalPage = totalCount/perPage;
//		
//		if(totalCount%totalPage!=0) {
//			//totalPage = totalPage+1;
//			totalPage++;
//		}
//		
//		//3.totalBlock 갯수 구하기
//		//	Block	 : 
//		//	perBlock : 한 페이지에 출력할 번호의 수
//			  
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		//4. page로 현재 Block 번호 찾기
//		//	 page		curBlock
//		//	 1			1
//		//	 2			1
//		//	 3			1
//		//	 4			1
//		//	 5			1
//		//	 6			2
//		//	 ...		2
//		//	 10			2
//		//	 11			3
//		
//		Long curBlock = page/perBlock;
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		//5. curBlock로 시작번호와 끝번호 알아 오기
//		//	 curBlock		startNum		lastNum
//		//	 1				1				5
//		//	 2				6				10
//		//	 3				11				15
//		//	 4				16				20
//		//	 5				21				25
//		
//		Long startNum =(curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
		
		//System.out.println("totalPage : "+totalPage);
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		
		
			//1. HDD에 파일 저장
			//	1) 파일 저장 위치
			//	   webapp/resources/upload/notice
			//	2) 저장할 폴더의 실제 경로 반환 (운영체제-OS 기준)
			String realPath = servletContext.getRealPath("resources/upload/notice");
			//realPath 확인
			System.out.println("realPath : "+realPath);
			
			//	3) 저장할 폴더의 정보를 가지는 자바 객체 생성
			File file = new File(realPath);
			
			
			//	   폴더가 없으면 에러가 발생하기 때문에 폴더를 생성
			System.out.println(file.exists());
			if(!file.exists()) {
				file.mkdirs();
			}
			
			for(MultipartFile photo :files) {
				if(photo.isEmpty()) {
					continue;
				}
				file = new File(realPath);
				//	4) UUID 클래스
				String fileName = UUID.randomUUID().toString();
				//	   파일명 확인
				System.out.println("FileName : "+fileName);
				fileName = fileName+"_"+photo.getOriginalFilename();
				System.out.println("FileName+확장자 : "+fileName);
				file = new File(file, fileName);
				photo.transferTo(file);
		}
		
		return 0; //noticeDAO.setAdd(boardDTO);
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
