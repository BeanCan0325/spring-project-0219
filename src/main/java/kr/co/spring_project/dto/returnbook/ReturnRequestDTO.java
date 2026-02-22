package kr.co.spring_project.dto.returnbook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnRequestDTO {

	private Long bookId;
	private int memberId;
	private String returnDate;
}
