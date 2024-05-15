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

   // creating post mapping that post the book in database
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return  bookService.createBook(book);
    }

    // creating get mapping that retrieves all the books from database
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    // creating get mapping that retrieves a specific book from database
    @GetMapping("/books/{id}")
    public Book getSingleBook(@PathVariable ("id") int id) {
        return bookService.getBookById(id);
    }

    // creating delete mapping that deletes a specific book
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id) {
       bookService.deleteBook(id);
    }

   // creating put mapping that updates a specific record
    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }
}
