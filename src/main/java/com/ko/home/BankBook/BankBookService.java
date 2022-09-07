package com.ko.home.BankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ko.home.util.CommentPager;
@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	
	//----------------------------  Comment  -----------------------
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	//--------------------------------------------------------------
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
	
	return bankBookDAO.setUpdate(bankBookDTO);
	};
	
	public int setBankBook(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setBankBook(bankBookDTO);
	};
	
	public List<BankBookDTO> getList()throws Exception{
		return bankBookDAO.getList();
	};
	
	public int setChangeSale (BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	};

	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	};
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	};

}
