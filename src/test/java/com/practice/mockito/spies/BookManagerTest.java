package com.practice.mockito.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    BookManager bookManager;

    @Spy
    BookService bookService;

    // spy is a partical mock
    @Test
    public void testMockitoSpy(){
        //we need to mock findById method because it's communicating to database or currently not implemented
        // we need to call getAppliedDiscount method to calculate the discounted price
        Book book = new Book("1", "Mockito In Action", 500, "Amulya", "Chandhana", null);
        Mockito.doReturn(book).when(bookService).findById("1");

        //When we call when and then return on a spy object then it will actually call the method
        //so we should avoid using when and thenReturn with spy
        //Mockito.when(bookService.findById("1")).thenReturn(book);

        int actualDiscount = bookManager.applyDiscountOnBook("1", 10);
        assertEquals(450, actualDiscount);
    }

}
