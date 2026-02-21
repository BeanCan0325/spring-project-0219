package kr.co.spring_project.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.spring_project.dto.member.ReqLoginDTO;
import kr.co.spring_project.dto.member.ReqRegisterDTO;
import kr.co.spring_project.dto.member.ResLoginDTO;
import kr.co.spring_project.entity.Member;
import kr.co.spring_project.repository.MemberRepository;
import kr.co.spring_project.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public void register(ReqRegisterDTO request) {
	    // 비밀번호 및 ID 검증
	    if (!request.getPassword().equals(request.getPasswordCheck())) {
	        throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
	    }

	    if (memberRepository.existsByUserId(request.getUserId())) {
	        throw new IllegalArgumentException("이미 사용중인 아이디 입니다.");
	    }

	    String encodedPassword = passwordEncoder.encode(request.getPassword());

	    Member member = new Member();
	    member.setUserId(request.getUserId());
	    member.setUserName(request.getUserName());
	    member.setPhoneNumber(request.getPhoneNumber());
	    member.setBirthDate(request.getBirthDate().atStartOfDay());
	    member.setPassword(encodedPassword);

	    memberRepository.save(member);
	}

	@Override
	public ResLoginDTO login(ReqLoginDTO request) {
		// 로그인 구현 예정
		return null;
	}
	
}