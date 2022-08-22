package com.ko.home.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	public void setAdd()throws Exception{
		
	}
	
}
