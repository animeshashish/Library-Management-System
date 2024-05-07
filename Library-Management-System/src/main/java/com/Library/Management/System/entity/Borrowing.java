package com.Library.Management.System.entity;

import jakarta.persistence.*;

import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "Borrowing")

public class Borrowing {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int book_id;
   private int member_id;
    private Date borrow_date;
   private Date return_date;

    public Borrowing(int id, int book_id, int member_id, Date borrow_date, Date return_date) {
        this.id = id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    public Borrowing() { // default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
