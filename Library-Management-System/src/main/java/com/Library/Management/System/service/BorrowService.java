package com.Library.Management.System.service;

import com.Library.Management.System.Repository.BookRepository;
import com.Library.Management.System.Repository.BorrowRepository;
import com.Library.Management.System.Repository.MemberRepository;
import com.Library.Management.System.entity.Book;
import com.Library.Management.System.entity.Borrowing;
import com.Library.Management.System.entity.Member;
import com.Library.Management.System.exception.BookNotAvailableException;
import com.Library.Management.System.exception.MemberNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class BorrowService {
    @Autowired
    BorrowRepository borrowRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    MemberRepository memberRepository;

    // creating/saving a specific record using save() method
    public Borrowing createBorrow(Borrowing borrowing) {
        return borrowRepository.save(borrowing);
    }

    // getting all borrow record using findAll() method
    public List<Borrowing> getBorrow() {
        return borrowRepository.findAll();
    }

    // getting a specific  record by using the findById() method
    public Borrowing getBorrowById(int id) {
        return borrowRepository.findById(id).get();
    }

    // deleting a specific record by using deleteById() method
    public void deleteBorrow(int id) {
        borrowRepository.deleteById(id);
    }

    // updating a record

    public Borrowing updateBorrow(int id, Borrowing borrowing) {
        Borrowing borrowing1 = borrowRepository.findById(id).get();
        borrowing1.setBookId(borrowing.getBookId());
        borrowing1.setMemberId(borrowing.getMemberId());
        borrowing1.setBorrowDate(borrowing.getBorrowDate());
        borrowing1.setReturnDate(borrowing.getReturnDate());

        return borrowRepository.save(borrowing1);
    }

    public String borrowBook(Integer bookId, Integer memberId) {

        // check if book is available
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isEmpty()) {
            throw new BookNotAvailableException("Book with Book id" + bookId + " is not available");
        }

        // borrow a book
        Borrowing borrow = new Borrowing();
        borrow.setBookId(bookId);
        borrow.setMemberId(memberId);
        borrow.setBorrowDate(new Date());
        borrowRepository.save(borrow);

        // update the book quantity
        int numberOfRowUpdated = bookRepository.updateBookQuantity(bookId);
        if (numberOfRowUpdated > 0) {
            return "Book borrowed successfully";
        } else {
            return "Book could not be borrowed";
        }

    }

    public String findMember(Integer bookId, Integer memberId) {
        // check weather member is registered or not
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isEmpty()) {
            throw new MemberNotRegisteredException("Member with Member id" + memberId + " is not registered");
        }
        Borrowing br = new Borrowing();
        br.setBookId(bookId);
        br.setMemberId(memberId);
        br.setBorrowDate(new Date());
        br.setReturnDate(new Date());
        borrowRepository.save(br);

        // update book quantity
        int quantityUpdated = bookRepository.updateBookQuantity(memberId);
        if (quantityUpdated>0)
        {
            return "Book borrowed successfully";
        }else {
            return "Book could not be borrowed";
        }
    }
public String returnBook(Integer bookId, Integer memberId) {

    // return a book
    Borrowing br = new Borrowing();
    br.setBookId(bookId);
    br.setMemberId(memberId);
    br.setBorrowDate(new Date());
    br.setReturnDate(new Date());
    borrowRepository.save(br);

    // update the book quantity
    int quantityUpdated = bookRepository.updateBookQuantity(bookId);
    if (quantityUpdated > 0) {
        return "Book return successfully";
    } else {
        return "Book could not be returned";
    }
}

}
