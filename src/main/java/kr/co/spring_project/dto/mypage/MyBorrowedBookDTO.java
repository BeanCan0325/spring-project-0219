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
public class MyBorrowedBookDTO {

	 private Long borrowKey;   // 대여 PK (Borrowing.borrowKey)
	    private Long bookId;      // 도서 ID (Book.bookId)
	    private String title;     // 도서 제목
	    private String author;    // 저자
	    private String publisher; // 출판사
	    private LocalDateTime borrowedAt; //대출 날짜
}
