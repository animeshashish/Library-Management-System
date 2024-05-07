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

// CREATE
    public  Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // READ
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    // Delete
    public void deleteBook(long id) {
        bookRepository.deleteById((int) id);
    }

    // UPDATE
    public Book updateBook(long id, Book book) {
        Book book1 = bookRepository.findById((int) id).get();
        book1.setAuthor(book.getAuthor());
        book1.setGenre(book.getGenre());
        book1.setIsbn(book.getIsbn());
        book1.setQuantity(book.getQuantity());

        return bookRepository.save(book1);
    }

}
