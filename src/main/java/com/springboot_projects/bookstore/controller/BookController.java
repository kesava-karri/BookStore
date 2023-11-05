package com.springboot_projects.bookstore.controller;

import com.springboot_projects.bookstore.model.Book;
import com.springboot_projects.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GetMapping(value = "/books/{bookId}")
    public Book getBookDeets(@PathVariable("bookId") String bookId) {
        return bookRepository.fetchBookById(bookId);
    }

    @PostMapping(value = "/books")
    public void saveBook(@RequestBody Book book) {
        // create new book
        bookRepository.saveBook(book);
    }

    @PutMapping(value = "/books")
    public void updateBook(@RequestBody Book book) {
        // update existing record
        bookRepository.updateBook(book);
    }

    @DeleteMapping(value = "/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") String bookId) {
        bookRepository.deleteBookById(bookId);
    }
}
