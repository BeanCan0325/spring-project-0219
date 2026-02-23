package kr.co.spring_project.dto.mypage;

import java.time.LocalDateTime;

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
public class MyProfileDTO {

	private Long memberId;
	private String userId;
	private String userName;
	private String phoneNumber;
	private LocalDateTime createdAt;



}
