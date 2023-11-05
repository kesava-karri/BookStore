package com.springboot_projects.bookstore.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.springboot_projects.bookstore.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private DynamoDBMapper mapper;

    public void saveBook(Book book) {
        mapper.save(book);
    }

    public Book fetchBookById(String bookId) {
        // load is used to fetch the record from the ddb table
        return mapper.load(Book.class, bookId);
    }

    public void updateBook(Book book) {
        // overwrites only if book already exist else creates a new book
        saveBook(book);
    }

    public void deleteBookById(String bookId) {
        Book book = new Book();
        book.setBookId(bookId);
        mapper.delete(bookId);
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = mapper.scan(Book.class, new DynamoDBScanExpression());
        return bookList;
    }
}
