package com.pragma.library.service;

import com.pragma.library.model.Book;
import com.pragma.library.model.Loan;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        return books.stream()
               .filter(book -> book.title().equals(title))
               .findFirst()
               .orElse(null);
    }
}