package com.ko.home.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {

	@GetMapping("error400")
	public ModelAndView error400()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Prameter가 틀림");
		mv.setViewName("errors/error404");
		return mv;
	}
	
	@GetMapping("error500")
	public ModelAndView error500()throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Server Exception 발생");
		mv.setViewName("errors/error404");
		return mv;
	}
	
}
