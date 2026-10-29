package com.kh.example.chap03_assist.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferDAO {
	public void outputByte() {
		// 파일에 바이트 기반으로 데이터를 빠르게 쓰고 싶다
		// File Steam            Buffered Output
		try(FileOutputStream fos = new FileOutputStream("c_buffer.txt",true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			bos.write(65);
			byte[] bArr = {66, 67, 68, 69};
			bos.write(bArr);						
		} catch (FileNotFoundException e) {			
			e.printStackTrace();			
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	public void inputByte() {
		// 파일에 있는 데이터를 바이트 기반으로 빠르게 읽고 싶다
		// File Steam            Buffered Input
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c_buffer.txt"));) {
			byte[] bArr = bis.readAllBytes();
			for(byte b : bArr) {
				System.out.print((char)b);
			}
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void outputChar() {
		// 파일에 문자 기반으로 데이터를 빠르게 쓰고 싶다
		// File (Stream x)		Buffered Writer	
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"));) {
		// c_buffer.txt에 아래 내용 작성하기
		// 안녕하세요 
		// 반갑습니다
		// 건강하세요
		bw.write("안녕하세요\n");
		bw.write("반갑습니다\n");
		bw.write("건강하세요\n");
	} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	public void inputChar() {
		// 파일에 문자기반으로 데이터를 빠르게 읽고 싶다
		// File	(Stream x) 		buffered Reader
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
			String value;
			while((value=br.readLine()) != null) {
				System.out.println(value);
				
		}
	} catch (FileNotFoundException e) {
			e.printStackTrace();
	} catch (IOException e1) {
			e1.printStackTrace();
	}
		
	}
		//Scanner 없이 사용자에게 숫자를 입력받고 그 값의 3배가 된 값을 출력
	public void onlyIO() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("정수 하나 입력 : ");
			String value = br.readLine();
			int num = Integer.parseInt(value);
			System.out.println(num + "* 3 =" + (num*3));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}



