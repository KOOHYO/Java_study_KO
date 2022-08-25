package com.ko.home.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.board.impl.BoardDTO;
import com.ko.home.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글목록
	@RequestMapping(value = "list.ko", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		System.out.println("Notice 리스트 접속");
		ModelAndView mv = new ModelAndView();
		System.out.println(pager);
		
//		System.out.println("Page : "+page);
		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//글상세 글번호가 파라미터로 넘어옴
	//여기서 String 말고 void로 해도 가능!
	@RequestMapping(value = "detail.ko", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		System.out.println("Notice 디테일 접속");
		boardDTO = noticeService.getDetail(boardDTO);
		
		model.addAttribute("boardDTO", boardDTO);
		
		return "board/detail";
	}
	
	//글작성
	//여기서 String 말고 void로 하면 add.ko.jsp를 찾아가니 
	//이것은 servlet-context.xml에 InternalResourceViewResolver를 보면 알 수 있음!
	//안됌 그러므로 String아니면 ModelAndView를 써야함!!
	@RequestMapping(value = "add.ko", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/add";
	}
	
	//글작성 글제목, 글작성자, 글내용 파라미터로 넘어옴
	@RequestMapping(value = "add.ko", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		
		mv.setViewName("redirect:./list.ko");
		
		return mv;
	}
	
	//글수정 여기서 메서드 안쓰면 GET이다!!
	@RequestMapping(value = "update.ko", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		System.out.println("Notice 업데이트 접속");
		boardDTO = noticeService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", mv);
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@RequestMapping(value = "update.ko", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:../board/detail.ko?num="+boardDTO.getNum();
	}
	
	//글삭제
	//글수정 여기서 메서드 안쓰면 GET이다!!
	@RequestMapping(value = "delet.ko")
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:../board/list.ko";
	}
	
}
