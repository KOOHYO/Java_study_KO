package com.ko.home.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return"Qna";
	}
	
	@RequestMapping(value = "reply.ko", method = RequestMethod.GET)
	public void setReply (QnaDTO qnaDTO)throws Exception{
		
	}
	
}
