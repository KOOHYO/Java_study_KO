package com.ko.home.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAdd(bankAccountDTO);
	}
}
