package kr.co.spring_project.service;

import org.springframework.stereotype.Service;

import kr.co.spring_project.repository.BookRepository;
import kr.co.spring_project.repository.BorrowingRepository;
import kr.co.spring_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowingService {
	private final BorrowingRepository borrowingRepository;
	private final MemberRepository memberRepository;
	private final BookRepository bookRepository;
	
	public void borrowBood(Long memberId, Long BookId) {
		
		// 검증 - 예외 - 생성 - 저장
		if (borrowingRepository.existByBook_BookIdAndIsBorrowedTrue(BookId)) {
			throw new RuntimeException("이미 대여중인 도서입니다.");
		} else {
			
			Member member = memberRepository.findByUserId(userId).
			memberRepository.isBorrowed = true;
			borrowingRepository.member(member_Id);
			
		}
	}
}
