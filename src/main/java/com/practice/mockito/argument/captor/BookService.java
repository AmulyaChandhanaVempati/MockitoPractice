package com.practice.mockito.argument.captor;


public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void addBook(Book book) {
        if(book.getPrice()<=500){
            return;
        }
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

    public void updateBookPrice(String bookId, int updatedPrice) {
        if(bookId == null){
            return;
        }
        Book bookFromDb = bookRepository.findById(bookId);
        if(bookFromDb.getPrice()==updatedPrice){
            return;
        }
        if (bookFromDb != null) {
            bookFromDb.setPrice(updatedPrice);
            bookRepository.save(bookFromDb);
        }
    }
}
