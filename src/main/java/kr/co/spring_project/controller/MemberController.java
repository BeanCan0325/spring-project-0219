package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.spring_project.dto.member.ReqLoginDTO;
import kr.co.spring_project.dto.member.ReqRegisterDTO;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	  private final MemberService memberService;
	
	  @GetMapping("/register")  
		public String registerForm() {  
			return "register";
		}
	  
	  @PostMapping("/register")
	  public String register(ReqRegisterDTO dto) {
	    return "redirect:/";
	  }
	  
//	  로그인 구현
	  
	  @GetMapping("/login")
	  public String loginForm() {
	      return "login";
	  }
	  
	  @PostMapping("/login")
	  public String login(ReqLoginDTO dto, HttpSession session) {
	      ResLoginDTO loginUser = memberService.login(dto);

	      session.setAttribute("LOGIN_USER", loginUser);
	      return "redirect:/";
	  }
	  
//	  로그아웃 구현
	  
	  @PostMapping("/member/logout")
	  public String logout(HttpSession session) {
	      session.invalidate();
	      return "redirect:/";
	  }
	  
}
