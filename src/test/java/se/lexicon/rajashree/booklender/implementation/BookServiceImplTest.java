package se.lexicon.rajashree.booklender.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.Implementaion.BookServiceImpl;
import se.lexicon.rajashree.booklender.repositories.BookRepository;
import se.lexicon.rajashree.booklender.service.BookService;

import java.math.BigDecimal;

@DataJpaTest
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    ModelMapper modelMapper;
    private BookService bookService;
    private Book book;

    @BeforeEach
    public void setup(){
        ModelMapper modelMapper = new ModelMapper();
        BookDto bookdto = new BookDto("JAVA","JAVA Book",10,new BigDecimal("10.0"));

    }

    @Test
    public void test_save(){
        ModelMapper modelMapper = new ModelMapper();
        BookServiceImpl BookServiceImpl = new BookServiceImpl(bookRepository,modelMapper);
        BookDto bookdto = new BookDto("JAVA","JAVA Book",10,new BigDecimal("10.0"));
        Book convertedEntity  = modelMapper.map(bookdto,Book.class);
        bookdto = BookServiceImpl.create(bookdto);
        Assertions.assertEquals("JAVA",bookdto.getTitle());
    }








}
