package se.lexicon.rajashree.booklender.dto;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class BookDtoTest {
    @Test
    public void test_BookDto_Setter() {
        int expectedMaxLoanDays = 30;
        BigDecimal expectedFinePerDay = BigDecimal.valueOf(10);
        String expectedDescription = "Java Book";

        BookDto testBook = new BookDto(1,"Java",true,false,"Java Book",30,BigDecimal.valueOf(10));

        assertEquals(expectedMaxLoanDays, testBook.getMaxLoanDays());
        assertEquals(expectedFinePerDay, testBook.getFinePerDay());
        assertEquals(expectedDescription, testBook.getDescription());

        assertTrue(testBook.isAvailable());
        assertFalse(testBook.isReserved());
    }

}
