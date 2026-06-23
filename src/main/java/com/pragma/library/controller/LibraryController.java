package com.pragma.library.controller;

import com.pragma.library.model.Book;
import com.pragma.library.model.User;
import com.pragma.library.service.BookService;
import com.pragma.library.service.LoanService;
import com.pragma.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final BookService bookService;
    private final UserService userService;
    private final LoanService loanService;

    @Autowired
    public LibraryController(BookService bookService, UserService userService, LoanService loanService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loanService = loanService;
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("/books/{title}")
    public void removeBook(@PathVariable String title) {
        Book book = bookService.findBookByTitle(title);
        if (book!= null) {
            bookService.removeBook(book);
        }
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/users/{membershipNumber}")
    public void removeUser(@PathVariable int membershipNumber) {
        User user = userService.findUserByMembershipNumber(membershipNumber);
        if (user!= null) {
            userService.removeUser(user);
        }
    }

    @PostMapping("/loans")
    public void loanBook(@RequestParam String bookTitle, @RequestParam int userMembershipNumber, @RequestParam LocalDate expectedReturnDate) {
        Book book = bookService.findBookByTitle(bookTitle);
        User user = userService.findUserByMembershipNumber(userMembershipNumber);
        if (book!= null && user!= null) {
            loanService.loanBook(book, user, expectedReturnDate);
        }
    }

    @DeleteMapping("/loans/{bookTitle}")
    public void returnBook(@PathVariable String bookTitle) {
        Loan loan = loanService.getLoans().stream()
               .filter(l -> l.book().title().equals(bookTitle))
               .findFirst()
               .orElse(null);
        if (loan!= null) {
            loanService.returnBook(loan);
        }
    }
}