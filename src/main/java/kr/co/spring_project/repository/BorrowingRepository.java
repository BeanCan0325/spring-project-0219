package kr.co.spring_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.spring_project.entity.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
	
	List<Borrowing> findByMember_MemberIdAndIsBorrowedTrue(Long memebrId);
//	📋List<>를 쓰는 이유: 결과값이 무조건 하나인가? 아니면 여러 개일 수 있는가
	
	boolean existByBook_BookIdAndIsBorrowedTrue(Long bookId);

}
