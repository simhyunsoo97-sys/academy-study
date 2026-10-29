package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {		
		try {
			File f1 = new File("test.txt");
			f1.createNewFile();	
			
			File f2 = new File("C:\\test\\test.txt");
			f2.createNewFile();
			
			File f3 = new File("C:\\temp1\\temp2");
			f3.mkdirs();
			
			//File f4 = new File("C:\\temp1\\temp2\\test.txt");
			File f4 = new File(f3, "test.txt");
			f4.createNewFile();
			f4.delete();
			
			System.out.println(f2.exists());
			System.out.println(f3.exists());
			System.out.println(f4.exists());
			System.out.println(f3.isFile());
			
			System.out.println(f1.getName());// 파일명
			System.out.println(f1.getAbsolutePath());// 절대경로
			System.out.println(f1.getParent());// 상대경로
			System.out.println(f1.length());// 파일용량
			System.out.println(f4.getParent());// 상위폴더
			
					
					
		} catch (IOException e) {		
			e.printStackTrace();
			
		}
	}

}
