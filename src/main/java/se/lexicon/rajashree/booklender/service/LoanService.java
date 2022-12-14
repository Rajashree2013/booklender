package se.lexicon.rajashree.booklender.service;

import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.dto.LoanDto;
import se.lexicon.rajashree.booklender.model.Loan;

import java.util.List;

public interface LoanService  {

    LoanDto findById(long loanId);
    List<LoanDto> findByBookId(int bookId);
    List<LoanDto> findByUserId(int userId);
    List<LoanDto> findByTerminated(boolean status);
    List<LoanDto> findAll();
    LoanDto create(LoanDto loanDto);
    LoanDto update(LoanDto loanDto);
    boolean delete(long loanId);
}
