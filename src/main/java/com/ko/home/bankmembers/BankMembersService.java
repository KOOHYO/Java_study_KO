package com.ko.home.bankmembers;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ko.home.util.FileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	//@Autowired
	//private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		
		//제일 먼저 회원가입을 먼저 해야한다!
		//userName에 FK가 있기때문
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String path = "resources/upload/member";
		String fileName = fileManager.saveFile(servletContext, path, photo);
		
		if(!photo.isEmpty()) {
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
		}
		
		//1. HDD에 파일을 저장
		//	 파일 저장시에 경로는 Tomcat기준이 아니라 OS의 기준으로 실행
		//  1) 파일저장 위치
		//		webapp/resources/upload/member
		
		//	2) 저장할 폴더의 실제경로 반환(OS 기준)
//		String realPath = servletContext.getRealPath("resources/upload/member");
//		System.out.println("realPath : "+realPath);
//		
//		//	3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//		
//		//*** File 첨부가 없을 때 구분
//		
//		//	1)
//		//if(photo.getSize()!=0) {}
//		//	2)
//		if(!photo.isEmpty()) {
//			
//			//	파일이 is 있습니까? 물어보는 것
//			//System.out.println(file.isDirectory());
//			//	존재합니까? 물어보는 것
//			//System.out.println(file.exists());
//			// 폴더가 없으니 폴더를 만들어야한다
//			if(!file.exists()) {
//				//mkdirs 메이크 디렉토리스폴더도 만들고 멤버변수도 만들고
//				file.mkdirs();
//			}
//			
//			// 4) 중복되지 않는 파일명 생성
//			//	  -- 시간, java api(UUID 유니크 유니버셜 아이..),...
//			//	(1)
//			String fileName = UUID.randomUUID().toString();
//			System.out.println("FileName : "+fileName);
//			
//			//	(2)
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//			
//			//subString 써도 되고 이렇게 해도 된다
//			fileName = fileName+"_"+photo.getOriginalFilename();
//			System.out.println(fileName);
//			
//			//5. HDD에 파일 저장
//			// 어느 폴더에 어떤 이름으로 저장할 File 객체 생성
//			file = new File(file, fileName);
//			
//			//	1) MultipartFile 클래스의 transferTo 메서드 사용
//			//	 (1) 쓰기 전에 파일경로와 파일명을 알아야함
//			photo.transferTo(file);
//			
//			//	2) FileCopyUtils 클래스의 copy 메서드 사용
//			
//			//2. 저장된 파일정보를 DB에 저장
//			BankMembersFileDTO membersFileDTO = new BankMembersFileDTO();
//			membersFileDTO.setFileName(fileName);
//			membersFileDTO.setOriName(photo.getOriginalFilename());
//			membersFileDTO.setUserName(bankMembersDTO.getUserName());
//			bankMembersDAO.setAddFile(membersFileDTO);
//		
//		}//isEmpty 끝
		
		return result;
	}
	
	//아이디검색
	public List<BankMembersDTO> getSearchByID(String userName)throws Exception{
		return bankMembersDAO.getSearchByID(userName);
	}
	
}
