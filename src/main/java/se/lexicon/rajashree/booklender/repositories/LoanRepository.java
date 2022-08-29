package se.lexicon.rajashree.booklender.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends CrudRepository <Loan, Integer> {

   Optional<Loan> findByUserId(int userId);
   @Modifying
   @Query("SELECT u FROM Loan u WHERE u.book = ? 1 ")
   List<Loan> findByBookId(int bookId);
   @Modifying
   @Query("SELECT u FROM Loan u WHERE u.concluded = ? 1 ")
   boolean findByTerminatedStaus(boolean val);








}
