package kr.co.spring_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.spring_project.entity.Borrowing;

@Repository
public interface ReturnRepository extends JpaRepository<Borrowing, Long> {
	Optional<Borrowing> findByBook_BookIdAndIsBorrowedTrue(Long bookId);

}
