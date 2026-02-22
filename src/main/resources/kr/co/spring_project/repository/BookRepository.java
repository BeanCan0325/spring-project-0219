package kr.co.spring_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.spring_project.entity.Member;

public interface BookRepository extends JpaRepository<Member, Long>{
	

}
