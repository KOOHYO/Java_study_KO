package com.ko.home.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ko.home.bankmembers.BankMembersDTO;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAdd(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.setAdd(bankAccountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		return bankAccountDAO.getListByUserName(bankMembersDTO);
		      
	}

}
