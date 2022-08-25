package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;

import java.util.Optional;

public interface LoanRepository extends CrudRepository <Loan, Integer> {

   /*Optional<LibraryUser> findByUserId(int userId);
   Optional<Book> findByBookId(int bookId);
   boolean findByTerminatedStaus(boolean val);*/








}
