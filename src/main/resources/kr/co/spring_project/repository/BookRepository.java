package kr.co.spring_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.spring_project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	

}
