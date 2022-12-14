package com.ko.home.BankBook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> getCommentList(CommentPager commentPager)throws Exception{
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		
		//json
		//DTO == {}
		//num=1 == {"num":1, "bookNum":123, "writer":"name"}
		//[{}]
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		
		return map;
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		return result;
	}
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdat(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		return result;
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
			System.out.println("?????? ??????");
		}else {
			System.out.println("?????? ??????");
		}
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println("Update ????????? ??????");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println("DTOOOOOOOOOOOOOOO");
		
		model.addAttribute("detail", bankBookDTO);
		
		return "bankbook/update";
	}

	@RequestMapping(value = "list.iu", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("List ????????? ??????");
		
		List<BankBookDTO> ar = bankBookService.getList();
		
		//return "bankbook/list"; ??????URL??? ??????URL??? ???????????? ?????? ????????????(viod)
		
		model.addAttribute("list", ar);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Detail ????????? ??????");
		//???????????? ?????? ????????? ????????? ?????? ????????? ???????????? ????????? ??????
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
		System.out.println("Add ????????? ??????");
		
		// servlet-context.xml??? ??????
		// beans:property name="prefix" value="/WEB-INF/views/"??? ??????
		// ????????? /WEB-INF/views/??? RequestMapping
		// beans:property name="suffix" value=".jsp" ??? ?????? ?????????
		// bankbook/add ??? ?????? ??????
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add.iu", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add ????????? ??????");
		System.out.println(bankBookDTO.getBookName());
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setBankBook(bankBookDTO);
		if(result>0) {
			System.out.println("?????? ?????? ??????!");
		}else {
			System.out.println("?????? ?????? ??????!");
		}
		
		//return "bankbook/add";
		//?????? ?????? ??? ?????????????????????
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
}