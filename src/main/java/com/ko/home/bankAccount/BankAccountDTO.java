package com.ko.home.bankAccount;

import com.ko.home.BankBook.BankBookDTO;

public class BankAccountDTO {
	private Long accountNum;
	private String userName;
	private Long bookNum;
	private Long accountDate;
	private BankBookDTO bankBookDTO;
	
	public BankBookDTO getBankBookDTO() {
		return bankBookDTO;
	}
	public void setBankBookDTO(BankBookDTO bankBookDTO) {
		this.bankBookDTO = bankBookDTO;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Long getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Long accountDate) {
		this.accountDate = accountDate;
	}
	
}
