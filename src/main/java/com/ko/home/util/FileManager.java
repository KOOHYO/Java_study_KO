package com.ko.home.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileManager {

	// 주의! : 다른곳에서 파일 매니저 객체를 만들면 
	//		  어노테이션 오토와이어드 주입이 안됀다!
	//1.
	@Autowired
	private ServletContext servletContext;
	
	//save
	//2.
	//public void saveFile(ServletContext servletContext, String path)throws Exception{
	public void saveFile(String path)throws Exception{
		//1. 실제 경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
	}
	
}
