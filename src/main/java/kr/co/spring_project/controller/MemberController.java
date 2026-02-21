package kr.co.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.spring_project.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	  private final MemberService memberService;
	
	  @GetMapping("/register/form")  
		public String registerForm() {  
			return "register";
		}
	
}
