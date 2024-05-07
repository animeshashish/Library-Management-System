package com.Library.Management.System.service;

import com.Library.Management.System.Repository.BorrowRepository;
import com.Library.Management.System.entity.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BorrowService {@Autowired
    BorrowRepository borrowRepository;

    // CREATE
    public Borrowing createBorrow(Borrowing borrowing) {
        return borrowRepository.save(borrowing);
    }

    // READ
    public List<Borrowing> getBorrow() {
        return borrowRepository.findAll();
    }

    // DELETE
    public void deleteBorrow(long id) {
        borrowRepository.deleteById((int) id);
    }

    // UPDATE

    public Borrowing updateBorrow(long id, Borrowing borrowing) {
        Borrowing borrowing1 = borrowRepository.findById((int) id).get();
        borrowing1.setBook_id(borrowing.getBook_id());
        borrowing1.setMember_id(borrowing.getMember_id());
        borrowing1.setBorrow_date(borrowing.getBorrow_date());
        borrowing1.setReturn_date(borrowing.getReturn_date());

        return borrowRepository.save(borrowing1);
    }

}
