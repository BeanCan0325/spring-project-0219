package kr.co.spring_project.dto.member;

import java.time.LocalDate;

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
	
    private String userId;          // members.user_id
    private String userName;        // members.user_name
    private String phoneNumber;     // members.phone_number
    private LocalDate birthDate;       // yyyy-MM-dd (입력용)
    
    private String password;
    private String passwordCheck;
    
}