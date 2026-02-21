package kr.co.spring_project.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqRegisterDTO {

	private String userId;
	private String userName;
	private String email;
	private String password;
	private String passwordCheck;
	

}
