package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowingController {

		@PostMapping("/borrow")
		public String borrowBook(Long bookId) {
			
			return "redirect:/home";
		}
}
