package se.lexicon.rajashree.booklender.dto;

import org.junit.jupiter.api.Test;
import se.lexicon.rajashree.booklender.model.LibraryUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryUserDtoTest {

    @Test
    public void test_LibraryUser_Dto() {

        LocalDate expectedRegDate = LocalDate.parse("2019-07-31");
        String expectedTitle = "TestTitle";

        LibraryUserDto libUser= new LibraryUserDto(1,LocalDate.parse("2019-07-31"),"TestTitle","raj@gmail.com");

        assertEquals(expectedRegDate , libUser.getRegDate());
        assertEquals(expectedTitle,libUser.getName());


    }

}
