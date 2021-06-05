package com.dharshiny.application.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookModel {
    
    @Id
    @Column(name = "book_id",nullable = false)
    private String bookId;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "genre")
    private String genre;

    public BookModel(){}

    public BookModel(String bookId, String quantity, String bookName, String genre) {
        this.bookId = bookId;
        this.quantity = quantity;
        this.bookName = bookName;
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}