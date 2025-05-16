package com.practice.mockito.stubbing;

import java.util.List;
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        // 500 , apply 10% discount -> 10% 500 is 50. 500-50 = 450
        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (price * discountRate / 100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }

    public int getTotalCostOfBooks(List<String> booIds){
        int totalCost = 0;
        for (String bookId : booIds) {
            Book book = bookRepository.findBookById(bookId);
            if (book != null) {
                totalCost += book.getPrice();
            }
        }
        return totalCost;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest) {
        if(bookRequest.getPrice()<=500){
            return;
        }
        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublisher(bookRequest.getPublisher());
        book.setTitle(bookRequest.getTitle());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }


}
