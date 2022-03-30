package com.prep.library.service;

import com.prep.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book book);
    List<Book> findAll();
    Optional<Book> findById(long id);
}
