package com.practice.mockito.stubbing;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testCalculateTotalCostOfBooks() {
        Book book1 = new Book("1234", "Mockito In Action", 500, "Amulya", "Chandhana", null);
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, "Amulya Vempati", "Chandhana", null);

        List<String> books = new ArrayList<>();
        books.add(book1.getBookId());
        books.add(book1.getBookId());

        // Stubbing the behavior of the mock object
        Mockito.when(bookRepository.findBookById("1234"))
                .thenReturn(book1)
                .thenReturn(book1);
       // Mockito.when(bookRepository.findBookById("1235")).thenReturn(book2);

//        Mockito.doReturn(book1).when(bookRepository).findBookById("1234");
//        Mockito.doReturn(book2).when(bookRepository).findBookById("1235");

        int actualCost = bookService.getTotalCostOfBooks(books);
        assertEquals(1000, actualCost);
    }

    //stubbing of void method using doNothing with when().method()
    @Test
    public void testSaveMethod(){
        Book book1 = new Book(null, "Mockito In Action", 500, "Amulya", "Chandhana", null);
        doNothing().when(bookRepository).save(book1);
        bookService.addBook(book1);
    }

    //sometimes stubbing creates problem(potential stubbing problem) with void methods
    @Test
    public void testSaveMethodWithBookRequest(){
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, "Amulya", "Chandhana", null);
        Book book1 = new Book(null, "Mockito In Action", 500, "Amulya", "Chandhana", null);

        doNothing().when(bookRepository).save(book1);
        bookService.addBook(bookRequest);
    }

}
