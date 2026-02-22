package kr.co.spring_project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring_project.dto.returnbook.ReturnRequestDTO;
import kr.co.spring_project.entity.Borrowing;
import kr.co.spring_project.repository.ReturnRepository;
import kr.co.spring_project.service.ReturnService;

@Service
public class ReturnServiceImpl implements ReturnService{
	
	@Autowired
	private ReturnRepository returnRepository;

	@Override
	public void returnBook(ReturnRequestDTO returnRequestDTO) {
		Long bookId = returnRequestDTO.getBookId();
		
		Borrowing borrowing = returnRepository.existsByBook_BookIdAndIsBorrowedTrue(bookId).orElseThrow();
		borrowing.setBorrowed(false); // 상태 변경
//		반납 처리 로직
		returnRepository.save(borrowing);
	}

}
