package kr.co.spring_project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.dto.mypage.MyBorrowedBookDTO;
import kr.co.spring_project.service.MyPageService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {
	
	private final MyPageService myPageService;

	@GetMapping("/mypage")
	public String mypage(HttpSession session, Model model) {

		 ResLoginDTO loginUser = (ResLoginDTO) session.getAttribute("LOGIN_USER");

		if (loginUser == null) {
			return "redirect:/member/login/form";
		}
		
		 Long memberId = loginUser.getMemberId();

		List<MyBorrowedBookDTO> loans =
				myPageService.getMyBorrowedBooks(loginUser.getMemberId());

		System.out.println("memberId: " + loginUser.getMemberId());
		System.out.println("대출 개수: " + loans.size());
		model.addAttribute("loans", loans);

		
		return "mypage/index";
	}

}
