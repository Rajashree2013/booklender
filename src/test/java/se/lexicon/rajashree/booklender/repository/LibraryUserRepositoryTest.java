package se.lexicon.rajashree.booklender.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.repositories.LibraryUserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class LibraryUserRepositoryTest {

    @Autowired
private LibraryUserRepository testObject;

    @BeforeEach
    public void setup() {
        LibraryUser libraryUser1 = new LibraryUser(1,LocalDate.parse("2019-07-31"),"TEST1","test1@gmail.com");
        LibraryUser libraryUser2 = new LibraryUser(2,LocalDate.parse("2019-07-31"),"TEST2","test2@gmail.com");
        LibraryUser libraryUser3 = new LibraryUser(3,LocalDate.parse("2019-07-31"),"TEST3","test3@gmail.com");
        testObject.save(libraryUser1);
        testObject.save(libraryUser2);
        testObject.save(libraryUser3);
    }

    @Test
    public void given_email_findById() {
        Optional<LibraryUser> libraryUser1 = testObject.findById(1);
        String actualEmail = libraryUser1.get().getEmail();
        Assertions.assertEquals("test1@gmail.com", actualEmail);
    }

    @Test
    public void given_FindAll() {
        List<LibraryUser> actualList = new ArrayList<LibraryUser>();
        Iterator<LibraryUser> listUser = testObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        Assertions.assertEquals(actualList.size(), 3);
    }
   // @Test
    public void given_DeleteById() {
        List<LibraryUser> actualList = new ArrayList<LibraryUser>();
        testObject.deleteById(1);
        Iterator<LibraryUser> listUser = testObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        Assertions.assertEquals(actualList.size(), 2);

    }

}
