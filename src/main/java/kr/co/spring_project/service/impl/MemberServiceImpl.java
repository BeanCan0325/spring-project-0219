package kr.co.spring_project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void register(ReqRegisterDTO dto) {
        Member member = Member.builder()
                .userId(dto.getUserId())
                .password(dto.getPassword())
                .userName(dto.getUserName())
                .phoneNumber(dto.getPhoneNumber())
                .birthDate(dto.getBirthDate())
                .build();
        memberRepository.save(member);
    }

    @Override
    public ResLoginDTO login(ReqLoginDTO dto) {
        Member member = memberRepository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다."));

        if (!member.getPassword().equals(dto.getPassword())) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다.");
        }

        return new ResLoginDTO(member.getMemberId(), member.getUserId(), member.getUserName());
    }
}