package com.practice.mockito.behavior.verification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

//    @Mock
//    BookRepository bookRepository;

    @Spy
    BookRepository bookRepository;

    @Test
    public void testAddBook(){
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        bookService.addBook(book1);
        Mockito.verify(bookRepository,Mockito.times(0)).save(book1);
    }

    @Test
    public void testSaveMethodWithBookRequest(){
       BookRequest bookRequest = new BookRequest("Mockito In Action", 600, "Amulya", "Chandhana", null);
        Book book1 = new Book(null, "Mockito In Action", 600, "Amulya", "Chandhana", null);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.times(1)).save(book1);
    }

    @Test
    public void testSaveMethodWithBookRequest1(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, "Amulya", "Chandhana", null);
        Book book1 = new Book(null, "Mockito In Action", 600, "Amulya", "Chandhana", null);
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.times(2)).save(book1);
    }

    @Test
    public void testSaveMethodWithBookRequest2(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, "Amulya", "Chandhana", null);
        Book book1 = new Book(null, "Mockito In Action", 500, "Amulya", "Chandhana", null);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.never()).save(book1);
    }

    @Test
    public void testUpdateBookPrice(){
        bookService.updateBookPrice(null,600);
        Mockito.verifyNoInteractions(bookRepository);
    }

    @Test
    public void testUpdateBookPrice1(){
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Mockito.when(bookRepository.findById("1234")).thenReturn(book1);
        bookService.updateBookPrice("1234",600);
        Mockito.verify(bookRepository).findById("1234");
        Mockito.verify(bookRepository).save(book1);
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    //order in which the methods are called
    @Test
    public void testUpdateBookPrice2(){
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", LocalDate.now());
        Mockito.when(bookRepository.findById("1234")).thenReturn(book1);
        bookService.updateBookPrice("1234",600);
        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findById("1234");
        inOrder.verify(bookRepository).save(book1);

    }

    //AtLeast or AtMost
    @Test
    public void testSaveMethodWithBookRequest3(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, "Amulya", "Chandhana", null);
        Book book1 = new Book(null, "Mockito In Action", 600, "Amulya", "Chandhana", null);
        bookService.addBook(bookRequest);
//        bookService.addBook(bookRequest);
//        bookService.addBook(bookRequest);
//        Mockito.verify(bookRepository,Mockito.times(2)).save(book1);
//        Mockito.verify(bookRepository,Mockito.atLeast(1)).save(book1);
//        Mockito.verify(bookRepository,Mockito.atMost(3)).save(book1);
        Mockito.verify(bookRepository,Mockito.atMostOnce()).save(book1);
        Mockito.verify(bookRepository,Mockito.atLeastOnce()).save(book1);
    }
}
