package se.lexicon.rajashree.booklender.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.repositories.BookRepository;

import java.math.BigDecimal;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void test_save(){
        Book book1 = new Book("JAVA", 10, new BigDecimal("10.0"),"JAVA Book");
        book1.setBookId(1);
        book1.setTitle("JAVA");
        book1.setMaxLoanDays(10);
        book1.setFinePerDay(new BigDecimal("10.0"));
        book1.setDescription("JAVABOOK");
        book1.setAvailable(true);
        book1.setReserved(true);
        System.out.println(book1);
        bookRepository.save(book1);
    }


    @Test
    public void given_id_findById()
    {
        Assertions.assertEquals(bookRepository.findById(1).get().getTitle(), "JAVA");
    }
}
