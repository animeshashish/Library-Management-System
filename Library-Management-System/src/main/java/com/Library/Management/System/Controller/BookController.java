package com.Library.Management.System.Controller;

import com.Library.Management.System.entity.Book;
import com.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
@Autowired
BookService bookService;
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {

        return  bookService.createBook(book);
    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
    @RequestMapping(value = "/books/{id}", method =RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
    }
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable(value = "id") Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
}
