package kr.co.spring_project.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.co.spring_project.dto.member.ReqLoginDTO;
import kr.co.spring_project.dto.member.ReqRegisterDTO;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.entity.Member;
import kr.co.spring_project.repository.MemberRepository;
import kr.co.spring_project.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void register(ReqRegisterDTO request) {
		// 1. 비밀번호 & 비밀번호 확인 검증
		if(!request.getPassword().equals(request.getPasswordCheck())) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	
		if(memberRepository.existsByUserId(request.getUserId())) {
			System.out.println("이미 사용중인 아이디 입니다.");
		}
	
		String encodedPassword = passwordEncoder.encode(request.getPassword());

		
		
		Member member = new Member();
		member.setUserId(request.getUserId());
		member.setUserName(request.getUserName());
		member.setPhoneNumber(request.getPhoneNumber());
		member.setBirthDate(null);
		member.setPassword(encodedPassword);
		
		memberRepository.save(member);
	}

	@Override
	public ResLoginDTO login(ReqLoginDTO request) {
		// 로그인 구현 예정
		return null;
	}
	
}