package kr.co.spring_project.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.entity.Book;
import kr.co.spring_project.service.BookService;
import kr.co.spring_project.service.BorrowingService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BorrowingController {

    private final BookService bookService;
    private final BorrowingService borrowingService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam("bookId") Long bookId, HttpSession session) {
        ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
        borrowingService.borrowBook(loginUser.getMemberId(), bookId);
        return "redirect:/list";
    }
}