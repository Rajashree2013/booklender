package se.lexicon.rajashree.booklender.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;
import se.lexicon.rajashree.booklender.repositories.BookRepository;
import se.lexicon.rajashree.booklender.repositories.LibraryUserRepository;
import se.lexicon.rajashree.booklender.repositories.LoanRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanObject;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryUserRepository libObject;



    @BeforeEach
        public void setup() {
        Book book1 = new Book("JAVA", 10, new BigDecimal("10.0"),"JAVA Book");
        Book book2 = new Book("C++", 10, new BigDecimal("10.0"),"C++ Book");
        bookRepository.save(book1);
        bookRepository.save(book2);
        LibraryUser libraryUser1 = new LibraryUser(1, LocalDate.parse("2019-07-31"),"TEST1","test1@gmail.com");
        LibraryUser libraryUser2 = new LibraryUser(2, LocalDate.parse("2019-08-31"),"TEST2","test2@gmail.com");
        libObject.save(libraryUser1);
        libObject.save(libraryUser2);
        Loan loan1= new Loan( libraryUser1,book1,LocalDate.parse("2019-07-31"));
        Loan loan2= new Loan( libraryUser2,book2,LocalDate.parse("2019-08-31"));
        loanObject.save(loan1);
        loanObject.save(loan2);
    }

    @Test
    public void test_findAll() {
        List<Loan> actualList = new ArrayList<Loan>();
        Iterator<Loan> listUser = loanObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        assertEquals(actualList.size(), 2);
    }

    @Test
    public void test_Delete(){
        loanObject.deleteAll();
        List<Loan> actualList = new ArrayList<Loan>();
        Iterator<Loan> listUser = loanObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        assertEquals(actualList.size(), 0);
    }
}
