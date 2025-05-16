package com.practice.mockito.stubbing;

import java.time.LocalDate;

public class BookRequest {

    private String title;
    private int price;
    private String author;
    private String publisher;
    private LocalDate publishedDate;

    public BookRequest(String title, int price, String author, String publisher, LocalDate publishedDate) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
