package com.kh.example.chap02_char.model.vo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileOpen() {
		// 파일로부터 문자단위로 데이터를 읽어오고 싶다
		try(FileReader fr = new FileReader("b_char.txt");) {
			// 1. 하나씩 읽어오기
			//int value;
			//while(fr.read() != -1) {
				//System.out.print((char)value);
			
			
			//2. 배열에 담기
			int size = (int)new File("b_char.txt").length();
			char[] chArr = new char[size];
			fr.read(chArr);
			for(char ch : chArr) {
				System.out.println(ch);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	
	public void fileSave() {
		try(FileWriter fw = new FileWriter ("b_char.txt", true);) {
			//파일에 문자 단위로 데이터를 작성하고 싶다
			
			fw.write("와, IO 재밌다~!");
			//fw.flush();
			
			fw.write(65);
			fw.write(' ');
			char[] cArr= {'c','1','a', 's', 's'};
			fw.write(cArr);
		} catch (IOException e) {			
			e.printStackTrace();			
		}						
	}
}
