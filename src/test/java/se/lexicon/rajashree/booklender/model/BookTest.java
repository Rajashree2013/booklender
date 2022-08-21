package se.lexicon.rajashree.booklender.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void test_create_book_success() {
        int expectedMaxLoanDays = 30;
        BigDecimal expectedFinePerDay = BigDecimal.valueOf(10);
        String expectedDescription = "Test description";

        Book testBook = new Book("OCA", 30, BigDecimal.valueOf(10), "Test description");

        assertEquals(expectedMaxLoanDays, testBook.getMaxLoanDays());
        assertEquals(expectedFinePerDay, testBook.getFinePerDay());
        assertEquals(expectedDescription, testBook.getDescription());

        assertTrue(testBook.isAvailable());
        assertFalse(testBook.isReserved());
    }
}
