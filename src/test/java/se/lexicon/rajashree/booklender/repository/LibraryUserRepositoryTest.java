package se.lexicon.rajashree.booklender.repository;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void given_email_findByEmail_return_optional_present() {
        LibraryUser expectedContent = new LibraryUser(1,LocalDate.parse("2019-07-31"),"TEST1","test1@gmail.com");
        Optional<LibraryUser> result = testObject.findById(1);
        assertEquals(expectedContent, result.get());
    }

    //@Test
    public void given_FindAll() {
        List<LibraryUser> actualList = new ArrayList<LibraryUser>();
        Iterator<LibraryUser> listUser = testObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        assertEquals(actualList.size(), 3);
    }
   @Test
    public void test_Delete(){
        testObject.deleteById(1);
        List<LibraryUser> actualList = new ArrayList<LibraryUser>();
        Iterator<LibraryUser> listUser = testObject.findAll().iterator();
        while(listUser.hasNext()){
            actualList.add(listUser.next());
        }
        assertEquals(actualList.size(), 2);
    }
}
