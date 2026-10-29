package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	private MemberMenu menu = new MemberMenu();
	private MemberService mService = new MemberService();

	public void insertMember() {
		Member m = menu.insertMember();

		int result = mService.insertMember(m);
		if (result > 0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}

	public void exiProgram() {
		mService.exitProgram();
	}

	public void selectAll() {
		ArrayList<Member> list = mService.selectAll();
		if (!list.isEmpty()) {
			menu.displayMember(list);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void selectMember() {
		int sel = menu.selectMember(); // 뭘로 조회할지(1 id, 2 gender)
		ArrayList<Member> list = null;
		switch(sel) {
		case 1:
			String id = menu.inputMemberId(); // 무슨 값으로 조회할지
			list = mService.selectMemberId(id);
			break;
		case 2:
			char gen = menu.inputGender(); // 무슨 값으로 조회할지
			list =mService.selectGender(gen);
			break;
		case 0: return;
		}
		
		if(!list.isEmpty()) {
			menu.displayMember(list);
		} else {
			menu.displayError("조회 결과가 없습니다.");
		}
	}

	public void updateMember() {
		String memberId = menu.inputMemberId(); // 누구를 수정할 것인지
		
		int check = mService.checkMember(memberId);
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			int sel = menu.updateMember();// 무엇을 수정할 것인지(번호)
			String updateStr = null;
			switch(sel) {
			case 1: updateStr = "member_pwd"; break;
			case 2: updateStr = "memail"; break;
			case 3: updateStr = "phone"; break;
			case 4: updateStr = "address"; break;
			case 0: return;			
			}
			
			String input = menu.inputUpdate(); // 어떻게 수정할 것인지
			
			int result = mService.updateMember(memberId, updateStr, input);
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 수정되었습니다.");
			} else {
				menu.displayError("데이터 수정 과정 중 오류 발생");
			}
		}
		
	}

	public void deleteMember() {
		String memberId = menu.inputMemberId();
		
		int check = mService.checkMember(memberId);
		if(check != 1) {
			menu.displayError("입력한 아이디가 존재하지 않습니다.");
		} else {
			String answer = menu.checkDelete();
			if(answer.equalsIgnoreCase("y")) {
				int result = mService.deleteMember(memberId);
				if(result > 0) {
					menu.displaySuccess(result + "개의 행이 삭제되었씁니다.");
				} else {
					menu.displayError("데이토 삭제 과정 중 오류 발생");
				}				
			} else if(answer.equalsIgnoreCase("N")) {
				menu.displaySuccess("탈퇴 진행을 취소합니다.");
			} else {
				menu.displayError("잘못된 입력입니다. Y또는 N을 입력해주세요.");
			}
		}
		
	}
}
