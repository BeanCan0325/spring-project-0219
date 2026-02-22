package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.spring_project.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BorrowingController {
	
	private final BookService bookService;

		@PostMapping("/borrow")
		public String borrowBook(Long bookId) {
			borrowingService.borrow(bookId);
			
			return "redirect:/home";
		}
		
		@GetMapping("/list")
		public String list(Model model) {
//			List<BookResponseDTO> books = bookService.findAllBooks();
			
//			model.addAllAttributes("",books);
			
			return "list";
			
		}
}
