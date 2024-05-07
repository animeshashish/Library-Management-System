package com.Library.Management.System.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
    @Column(name = "Title")
private String title;
    @Column(name = "Author")
private String author;
    @Column(name = "Isbn")
private String isbn;
    @Column(name = "Genre")
private String genre;
    @Column(name = "Quantity")
private int quantity;


    public Book(int id, String title, String author, String isbn, String genre, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.quantity = quantity;
    }


    public Book() { // Default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}



