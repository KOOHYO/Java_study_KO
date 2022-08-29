package com.ko.home.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class FileManager {

	// 주의! : 다른곳에서 파일 매니저 객체를 만들면 
	//		  어노테이션 오토와이어드 주입이 안됀다!
	@Autowired
	private ServletContext servletContext;
	
	//save
	public void saveFile()throws Exception{
		String realPath =
	}
	
}
