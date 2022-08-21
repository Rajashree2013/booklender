package se.lexicon.rajashree.booklender.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void test_create_LibraryUser_success() {

        LocalDate expectedRegDate = LocalDate.parse("2019-07-31");
        String expectedTitle = "TestTitle";

        LibraryUser libUser= new LibraryUser(LocalDate.parse("2019-07-31"),"TestTitle");

        assertEquals(expectedRegDate , libUser.getRegDate());
        assertEquals(expectedTitle,libUser.getName());


    }
}
