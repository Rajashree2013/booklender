package se.lexicon.rajashree.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanDtoTest {

    private LibraryUserDto loanTakerDto;
    private BookDto bookDto;
    private LoanDto testLoanDto;



    @BeforeEach
    public void init() {
        loanTakerDto = new LibraryUserDto(1,LocalDate.parse("2019-07-31"),"TestTitle","raj@gmail.com");
        bookDto = new BookDto(1,"Java",true,false,"Java Book",30,BigDecimal.valueOf(10));
        testLoanDto = new LoanDto(1, loanTakerDto,bookDto,LocalDate.parse("2019-07-31"),false);
    }

    @Test
    public void test_create_Loan_success() {

        assertEquals("TestTitle",loanTakerDto.getName());
    }



}
