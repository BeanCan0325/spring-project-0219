package kr.co.spring_project.service;

import kr.co.spring_project.dto.member.ReqLoginDTO;
import kr.co.spring_project.dto.member.ReqRegisterDTO;
import kr.co.spring_project.dto.member.ResLoginDTO;

public interface MemberService {
	
	void register(ReqRegisterDTO request);
	
	ResLoginDTO login(ReqLoginDTO request);

}
