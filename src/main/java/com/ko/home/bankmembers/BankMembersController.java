package com.ko.home.bankmembers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class BankMembersController {

	@Autowired
	private BankMembersService bankMembersService;

	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
//		List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO);
		
		mv.setViewName("member/myPage");
		mv.addObject("dto", bankMembersDTO);
		
		return mv;
	}
	
	//로그인
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login()throws Exception{
		System.out.println("로그인 접속 (GET)");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, BankMembersDTO bankMembersDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("DB로그인 접속 (POST)");
		
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		
		session.setAttribute("member", bankMembersDTO);
		
		int result=0;
		String message="로그인 실패";
		// 현재 위치는 /member/login.iu
		String url = "./login.iu";
		if(bankMembersDTO!=null) {
			result=1;
			message="로그인 성공";
			url="../";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	//로그아웃
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("check.iu")
	public String getCheck()throws Exception{
		System.out.println("체크 페이지 접속");
		
		return "member/check";
	}
	
	//회원가입
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join()throws Exception {
		System.out.println("회원가입 접속 (GET)");
		
		return "member/join";
	}
	
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session)throws Exception {
		System.out.println("회원가입 접속 (POST)");
		System.out.println(photo);
		
		System.out.println("uploard 파일명 : "+photo.getOriginalFilename());
		System.out.println("uploard 파라미터명 : "+photo.getName());
		System.out.println("uploard 파일의 크기"+photo.getSize()+" byte");
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
		if(result>0) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패..");
		}
		
		return "redirect:./login.iu";
		
	}
	
	
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public void search()throws Exception{
		System.out.println("아이디 검색중 (GET)");
		
		//return "member/search";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public ModelAndView search(String userName)throws Exception{
		System.out.println("아이디 검색중 (POST)");
		ModelAndView mv = new ModelAndView();
		
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(userName);
		
		//경로와 데이터를 함께 보낼때
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		
		return mv;
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public void list()throws Exception{
		
	}
	
}
