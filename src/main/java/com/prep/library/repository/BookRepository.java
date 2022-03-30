package com.prep.library.repository;

import com.prep.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /*void save(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(long id);*/
}
