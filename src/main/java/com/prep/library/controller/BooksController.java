package com.prep.library.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.prep.library.entity.Book;
import com.prep.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
	@Autowired
	BookService bookService;
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	@GetMapping("/books/{id}")
	public Optional<Book> getBookById(@PathVariable long id) {
		return bookService.findById(id);
	}
		
	@PostMapping("/books")
	public void addBook(@RequestParam long id, @RequestParam String name, @RequestParam String author){
		bookService.save(new Book(id,name,author));
	}
}