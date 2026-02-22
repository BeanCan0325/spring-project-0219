package kr.co.spring_project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import kr.co.spring_project.entity.Book;
import kr.co.spring_project.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}