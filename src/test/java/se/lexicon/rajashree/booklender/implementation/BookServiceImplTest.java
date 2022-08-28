package se.lexicon.rajashree.booklender.implementation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.repositories.BookRepository;
import se.lexicon.rajashree.booklender.service.BookService;

import java.math.BigDecimal;

@DataJpaTest
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void create_BookDtoTest(){

        BookDto bookDto = new BookDto(1, "JAVA",true,false,"JAVA BOOK",10, BigDecimal.valueOf(10));

    }

}
