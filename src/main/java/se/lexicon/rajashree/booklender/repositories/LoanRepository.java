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

   Loan findByLoanTakerUserId(int userId);
   //Find by bookId
   List<Loan> findByBookBookId(int bookId);

   List<Loan> findByConcluded(boolean val);








}
