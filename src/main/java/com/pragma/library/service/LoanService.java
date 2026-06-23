package com.pragma.library.service;

import com.pragma.library.model.Book;
import com.pragma.library.model.Loan;
import com.pragma.library.model.User;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private final List<Loan> loans = new ArrayList<>();
    private final BookService bookService;
    private final UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void loanBook(Book book, User user, LocalDate expectedReturnDate) {
        if (book.available() && user.loans().size() < 3) {
            book.setAvailable(false);
            loans.add(new Loan(book, user, expectedReturnDate));
        } else {
            throw new RuntimeException("No se puede prestar el libro.");
        }
    }

    public void returnBook(Loan loan) {
        loan.book().setAvailable(true);
        loans.remove(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}