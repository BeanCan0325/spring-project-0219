package kr.co.spring_project.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResLoginDTO {

	private Long memberId;
	private String userId;
	private String userName;
	
}
