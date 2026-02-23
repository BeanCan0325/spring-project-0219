package kr.co.spring_project.service;

import java.util.List;

import kr.co.spring_project.dto.mypage.MyBorrowedBookDTO;

public interface MyPageService {

	List<MyBorrowedBookDTO> getMyBorrowedBooks(Long memberId);
}
