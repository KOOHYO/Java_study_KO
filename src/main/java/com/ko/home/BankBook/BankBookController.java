package com.ko.home.BankBook;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//----------------------------  Comment  -----------------------
	
//	@PostMapping("commentAdd")
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		
//		return mv;
//		
//	}
	
	@PostMapping("commentAdd")
	@ResponseBody //??
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		
		//{}
		String jsonResult="{\"result\":\""+result+"\"}";
		
		return jsonResult;
		
	}
	
//	@GetMapping("commentList")
//	public ModelAndView getCommentList(CommentPager commentPager)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//	}
	
	@GetMapping("commentList")
	@ResponseBody
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		
		//json
		//DTO == {}
		//num=1 == {"num":1, "bookNum":123, "writer":"name"}
		//[{}]
		
		
		return ar;
	}
	
	//--------------------------------------------------------------
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;		
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public void Update(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setUpdate(bankBookDTO);
		if(result>0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println("Update 페이지 접속");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println("DTOOOOOOOOOOOOOOO");
		
		model.addAttribute("detail", bankBookDTO);
		
		return "bankbook/update";
	}

	@RequestMapping(value = "list.iu", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("List 페이지 접속");
		
		List<BankBookDTO> ar = bankBookService.getList();
		
		//return "bankbook/list"; 리턴URL과 요청URL이 똑같으면 리턴 생략가능(viod)
		
		model.addAttribute("list", ar);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Detail 페이지 접속");
		//스프링이 하는 과정을 우리가 직접 객체를 만들어서 보내도 됀다
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
	}
	
	// /bankbook/add GET/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("Add 페이지 접속");
		
		// servlet-context.xml을 보면
		// beans:property name="prefix" value="/WEB-INF/views/"이 보임
		// 여기에 /WEB-INF/views/는 RequestMapping
		// beans:property name="suffix" value=".jsp" 가 있기 때문에
		// bankbook/add 만 쓰면 됀다
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add.iu", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add 페이지 접속");
		System.out.println(bankBookDTO.getBookName());
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBook(bankBookDTO);
		if(result>0) {
			System.out.println("통장 개설 성공!");
		}else {
			System.out.println("통장 개설 실패!");
		}
		
		//return "bankbook/add";
		//상품 등록 후 리스트페이지로
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
}