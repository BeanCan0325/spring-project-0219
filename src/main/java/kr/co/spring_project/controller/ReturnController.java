package kr.co.spring_project.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.entity.Borrowing;
import kr.co.spring_project.dto.returnbook.ReturnRequestDTO;
import kr.co.spring_project.service.BorrowingService;
import kr.co.spring_project.service.ReturnService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReturnController {

    private final ReturnService returnService;
    private final BorrowingService borrowingService;

    @GetMapping("/return")
    public String returnPage(HttpSession session, Model model) {
        ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");
        List<Borrowing> borrowings = borrowingService.getMyBorrowings(loginUser.getMemberId());
        model.addAttribute("borrowings", borrowings);
        model.addAttribute("userName", loginUser.getUserName()); 
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(ReturnRequestDTO returnRequestDTO) {
        returnService.returnBook(returnRequestDTO);
        return "redirect:/return?success=true";
    }
}