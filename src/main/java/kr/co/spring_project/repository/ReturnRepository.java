package kr.co.spring_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.spring_project.entity.Book;

@Repository
public interface ReturnRepository extends JpaRepository<Book, Integer> {

}
