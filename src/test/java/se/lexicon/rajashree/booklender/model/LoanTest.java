package se.lexicon.rajashree.booklender.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {

    private LibraryUser loanTaker;
    private Book book;
    private Loan testLoan;


    @BeforeEach
    public void init() {
        loanTaker = new LibraryUser(LocalDate.parse("2019-07-31"), "Test Testsson");
        book = new Book("Test Book", 30, BigDecimal.valueOf(10), "Test description");
        testLoan = new Loan(loanTaker, book, LocalDate.parse("2019-07-31"));
    }

    @Test
    public void test_create_Loan_success() {
        LocalDate expectedRegDate = LocalDate.parse("2019-07-31");
        Loan loan= new Loan(loanTaker,book,LocalDate.parse("2019-07-31"));
        assertEquals("Test Book",loan.getBook().getTitle());
    }

    @Test
    public void test_add_unavailable_book_throws_IllegalArgumentException() {
        Book unavailableBook = new Book("OCP", 30, BigDecimal.valueOf(10), "Boring book");
        unavailableBook.setAvailable(false);
        assertThrows(IllegalArgumentException.class, () -> new Loan(loanTaker, unavailableBook, LocalDate.now()));
    }

    @Test
    public void test_loan_is_not_overdue() {
        assertTrue(testLoan.isOverDue());
    }



}
