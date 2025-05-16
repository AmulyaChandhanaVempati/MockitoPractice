package com.practice.mockito.exception.handling;


import java.sql.SQLException;
import java.util.List;

public interface BookRepository {


    List<Book> findAllBook() throws SQLException;

    void save(Book book) throws SQLException;
}
