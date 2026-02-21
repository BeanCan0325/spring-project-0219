package kr.co.spring_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	
	private String author;
	
	private String publisher;
=======
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private String author;
	private String status;
>>>>>>> master
}
