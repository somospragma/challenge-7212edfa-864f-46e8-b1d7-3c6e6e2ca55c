package com.pragma.library.model;

import java.time.LocalDate;

public record Loan(Book book, User user, LocalDate expectedReturnDate) {}