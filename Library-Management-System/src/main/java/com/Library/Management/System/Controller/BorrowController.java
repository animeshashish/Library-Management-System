package com.Library.Management.System.Controller;

import com.Library.Management.System.entity.Borrowing;
import com.Library.Management.System.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public Borrowing createBorrow(@RequestBody Borrowing borrowing) {

        return  borrowService.createBorrow(borrowing);
    }
    @RequestMapping(value = "/borrow", method = RequestMethod.GET)
    public List<Borrowing> getBorrow() {
        return borrowService.getBorrow();
    }
    @RequestMapping(value = "/borrow/{id}", method = RequestMethod.DELETE)
    public void deleteBorrow(@PathVariable(value = "id") Long id) {
        borrowService.deleteBorrow(id);
    }
    @RequestMapping(value = "/borrow/{id}", method = RequestMethod.PUT)
    public Borrowing updateBorrow(@PathVariable(value = "id") Long id, @RequestBody Borrowing borrowing) {
        return borrowService.updateBorrow(id, borrowing);