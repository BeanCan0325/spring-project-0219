package kr.co.spring_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.spring_project.dto.mypage.MyBorrowedBookDTO;
import kr.co.spring_project.entity.Borrowing;
import kr.co.spring_project.repository.BorrowingRepository;
import kr.co.spring_project.service.MyPageService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageServiceImpl implements MyPageService{

	private final BorrowingRepository borrowingRepository;

	@Override
	public List<MyBorrowedBookDTO> getMyBorrowedBooks(Long memberId) {

		List<Borrowing> borrowings =
				borrowingRepository.findByMember_MemberIdAndIsBorrowedTrue(memberId);

		return borrowings.stream()
				.map(b -> new MyBorrowedBookDTO(
						b.getBorrowKey(),
						b.getBook().getBookId(),
						b.getBook().getTitle(),
						b.getBook().getAuthor(),
						b.getBook().getPublisher(),
						b.getBorrowedAt()
						))
				.toList();
	}


}
