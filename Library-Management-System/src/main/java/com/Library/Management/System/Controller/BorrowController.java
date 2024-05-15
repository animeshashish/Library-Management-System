package com.Library.Management.System.Controller;

import com.Library.Management.System.entity.Borrowing;
import com.Library.Management.System.exception.BookNotAvailableException;
import com.Library.Management.System.exception.MemberNotRegisteredException;
import com.Library.Management.System.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    // creating post mapping that post the borrowing in database
    @PostMapping("/save")
    public Borrowing createBorrow(@RequestBody Borrowing borrowing) {
        return borrowService.createBorrow(borrowing);
    }

    // creating get mapping that retrieves all the borrowing from database
    @GetMapping("/get")
    public List<Borrowing> getBorrow() {
        return borrowService.getBorrow();
    }

    // creating get mapping that retrieve specific borrowing from database
    @GetMapping("/get/{id}")
    public Borrowing getSingleBorrow(@PathVariable("id") int id) {
        return borrowService.getBorrowById(id);
    }

    // creating delete mapping that deletes a specific borrowing
    @DeleteMapping("/delete/{id}")
    public void deleteBorrow(@PathVariable("id") int id) {
        borrowService.deleteBorrow(id);
    }

    // creating put method to update borrowing details
    @PutMapping("/update/{id}")
    public Borrowing updateBorrow(@PathVariable("id") int id, @RequestBody Borrowing borrowing) {
        return borrowService.updateBorrow(id, borrowing);
    }

    @PatchMapping("/borrow/{bookId}/{memberId}")
        ResponseEntity<Object> borrowBook(@PathVariable Integer bookId, @PathVariable Integer memberId) {
        String message = "";
        try {
            message = borrowService.borrowBook(bookId, memberId);
        } catch (BookNotAvailableException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with Book id" + bookId + " is not available");
        }

        return ResponseEntity.status(HttpStatus.OK).body(message);

    }
    @PatchMapping("/patch/{bookId}/{memberId}")
    ResponseEntity<Object> findMember(@PathVariable int bookId, @PathVariable int memberId) {
        String message = "";
        try {
            message = borrowService.findMember(bookId, memberId);
        }catch (MemberNotRegisteredException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with Book id" + bookId + " is not registered");
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @PatchMapping("/return/{bookId}/{memberId}")
    public String returnBook(@PathVariable int bookId, @PathVariable int memberId) {
        return borrowService.returnBook(bookId, memberId);
    }
}