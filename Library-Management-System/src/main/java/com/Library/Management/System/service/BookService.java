package com.Library.Management.System.service;

import com.Library.Management.System.Repository.BookRepository;
import com.Library.Management.System.entity.Book;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {
    @Autowired
    BookRepository bookRepository;


// creating/saving a specific record using save() method
    public  Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // getting all book record using findAll() method
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // getting a specific  record by using the findById() method
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    // Deleting a specific record using deleteById() method
    public void deleteBook(int id) {

        bookRepository.deleteById((id));
    }

    // updating a record
    public Book updateBook(int id, Book book) {
        Book book1 = bookRepository.findById(id).get();
        book1.setAuthor(book.getAuthor());
        book1.setGenre(book.getGenre());
        book1.setIsbn(book.getIsbn());
        book1.setQuantity(book.getQuantity());

        return bookRepository.save(book1);
    }



}
