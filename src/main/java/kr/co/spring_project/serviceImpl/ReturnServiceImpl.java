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

	    Borrowing borrowing = returnRepository.findByBook_BookIdAndIsBorrowedTrue(bookId)
	                            .orElseThrow(() -> new RuntimeException("대여 정보를 찾을 수 없습니다."));
	    borrowing.setBorrowed(false);
	    returnRepository.save(borrowing);
	}

}
