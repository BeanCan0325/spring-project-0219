package kr.co.spring_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

import kr.co.spring_project.dto.returnbook.ReturnRequestDTO;
import kr.co.spring_project.service.ReturnService;

@Controller
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    // 반납 페이지로 이동
    @GetMapping("/return")
    public String returnPage() {
        return "return"; // return.jsp
    }

    // 반납 처리
    @PostMapping("/return")
    public String returnBook(ReturnRequestDTO returnRequestDTO, Model model) {
    	System.out.println("받은 bookId: " + returnRequestDTO.getBookId()); //추가
        returnService.returnBook(returnRequestDTO);
        model.addAttribute("msg", "반납이 완료되었습니다.");
        return "redirect:/return?success=true"; // 완료 후 다시 반납 페이지
    }
    
}