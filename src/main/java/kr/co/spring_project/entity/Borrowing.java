package kr.co.spring_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Borrowing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrowKey;
	
	
	@ManyToOne
	@JoinColumn(name ="member_id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name ="book_id")
//	⭐객체 안에 있는 필드로 검색할 때는 언더바를 사용해서 경로를 표시하는 로직을 사용
	private Book book;
	
	private boolean isBorrowed;
	
}
