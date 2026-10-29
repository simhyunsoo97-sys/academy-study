package com.kh.example.chap01_byte.model.dao.run;

import com.kh.example.chap01_byte.model.dao.ByteDAO;

public class Run {
	public static void main(String[]args) {
		ByteDAO bDAO = new ByteDAO();
		bDAO.fileOpen();
		//bDAO.fileSave();
	}
}
