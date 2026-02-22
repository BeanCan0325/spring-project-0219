package kr.co.spring_project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.spring_project.entity.Book;
import kr.co.spring_project.entity.Borrowing;
import kr.co.spring_project.entity.Member;
import kr.co.spring_project.repository.BookRepository;
import kr.co.spring_project.repository.BorrowingRepository;
import kr.co.spring_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BorrowingService {
	private final BorrowingRepository borrowingRepository;
	private final MemberRepository memberRepository;
	private final BookRepository bookRepository;
	
	public void borrowBook(Long memberId, Long bookId) {
		
		// 검증 - 예외 - 생성 - 저장
		if (borrowingRepository.existsByBook_BookIdAndIsBorrowedTrue(bookId)) {
		throw new RuntimeException("이미 대여중인 도서입니다.");
		} else {
			
			Member member = memberRepository.findById(memberId).orElseThrow();
			Book book = bookRepository.findById(bookId).orElseThrow();
			
			Borrowing borrowing = new Borrowing();
			
			borrowing.setMember(member);
			borrowing.setBook(book);
			borrowing.setBorrowed(true);
			
		    borrowingRepository.save(borrowing);
		}
	}
	public List<Borrowing> getMyBorrowings(Long memberId) {
	    return borrowingRepository.findByMember_MemberIdAndIsBorrowedTrue(memberId);
	}
}
