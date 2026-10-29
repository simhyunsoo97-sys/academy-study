package com.kh.example.chap01_byte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		FileInputStream fis = null;
		try {
			// 파일로부터 byte단위로 데이터를 읽어오고 싶다
			 fis = new FileInputStream("a_byte.txt");
			
			// 1. byte배열에 저장한 후 출력하기
			int size = (int)new File("a_byte.txt").length();
			byte[] bArr = new byte[size];
			fis.read(bArr);
			//for(int i = 0; i < bArr.length; i++) {
				//System.out.println((char)bArr[i]);
				
			//}
			for(byte b : bArr) {
				System.out.print((char)b);
			}
			System.out.println();
			
			// 2. byte배열 리턴 받기
			byte[] bArr2 = fis.readAllBytes();
			for(byte b : bArr2) {
				System.out.println((char)b);
		}
			
			// 앞서 stream으로 파일 내용을 다 읽고 커서가 트너에 도달했기 때문에
			// 더이상 읽을 것이 없어 축가로 나오지 않음
			
			// 3. 데이터 하나하나 읽어오기
			System.out.println("3. 데이터 하나하나 읽어오기");
			int value;
			while((value=fis.read()) != -1) {
				System.out.print((char)value);
			}
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void fileSave() {
		FileOutputStream fos = null;
		try {
			// 파일에 byte단위로 데이터를 작성하고 싶다
			fos = new FileOutputStream("a_byte.txt");
			
			fos.write(97);
			
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			
			fos.write(bArr, 1, 3);
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
}