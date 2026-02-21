package kr.co.spring_project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.spring_project.dto.returnbook.ReturnRequestDTO;
import kr.co.spring_project.entity.Book;
import kr.co.spring_project.repository.ReturnRepository;
import kr.co.spring_project.service.ReturnService;

@Service
public class ReturnServiceImpl implements ReturnService{
	
	@Autowired
	private ReturnRepository returnRepository;

	@Override
	public void returnBook(ReturnRequestDTO returnRequestDTO) {
		int bookId = returnRequestDTO.getBookId();
		
		Book book = returnRepository.findById(bookId).orElseThrow();
		book.setStatus("반납완료"); // 상태 변경
//		반납 처리 로직
		returnRepository.save(book);
	}

}
